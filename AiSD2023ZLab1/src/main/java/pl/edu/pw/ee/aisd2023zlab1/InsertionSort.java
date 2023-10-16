package pl.edu.pw.ee.aisd2023zlab1;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.Objects;

public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        int n = nums.length;
        for (int i = 1; i < n; ++i) {

            double tmp = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = tmp;
        }
    }

    private void validateParams(double[] nums) {
        if (Objects.isNull(nums))
            throw new RuntimeException("Input args (nums) cannot be null!");
    }
}
