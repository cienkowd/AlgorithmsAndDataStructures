package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class QuickSortIterativeWithInSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        quickSortWithInSort(nums);
    }

    private void validateParams(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
    }

    private void quickSortWithInSort(double[] data) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        Integer left = 0;
        Integer right = data.length - 1;

        starts.add(left);
        ends.add(right);

        int n = 1;
        int pivot;

        if (left < right) {

            while (n > 0) {
                n--;
                left = starts.remove(n);
                right = ends.remove(n);
                if (right - left <= 25) {
                    insertionSort(data, left, right);
                } else {
                    pivot = partition(data, left, right);

                    if (pivot - 1 > left) {
                        starts.add(left);
                        ends.add(pivot - 1);
                        n++;
                    }

                    if (pivot + 1 < right) {
                        starts.add(pivot + 1);
                        ends.add(right);
                        n++;
                    }
                }
            }
        }
    }

    private int partition(double[] nums, int start, int end) {
        int left = start + 1;
        int right = end;
        int pivot = start;

        while (true) {
            while (left <= right && nums[left] < nums[pivot]) {
                left++;
            }

            while (left <= right && nums[right] >= nums[pivot]) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, pivot, right);
        return right;
    }

    private void swap(double[] nums, int firstId, int secondId) {
        if (firstId != secondId) {

            double firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;
        }
    }

    private void insertionSort(double[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            double tmp = nums[i];
            int j = i - 1;

            while (j >= left && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = tmp;
        }
    }
}
