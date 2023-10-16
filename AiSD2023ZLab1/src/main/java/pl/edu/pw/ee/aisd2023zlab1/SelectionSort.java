package pl.edu.pw.ee.aisd2023zlab1;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.Objects;

public class SelectionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        int n = nums.length;
        int minValid;

        for (int i = 0; i < n - 1; i++) {
            minValid = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minValid]) {
                    minValid = j;
                }
            }
            swap(nums, i, minValid);
        }
    }

    private void validateParams(double[] nums) {
        if (Objects.isNull(nums))
            throw new RuntimeException("Input args (nums) cannot be null!");
    }

    private void swap(double[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            double firstValue = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstValue;
        }
    }
}
