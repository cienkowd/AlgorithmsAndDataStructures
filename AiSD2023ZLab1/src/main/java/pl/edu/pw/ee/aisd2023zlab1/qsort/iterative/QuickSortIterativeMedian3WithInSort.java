package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.InsertionSort;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class QuickSortIterativeMedian3WithInSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        quickSortMedian3WithInSort(nums);
    }

    private void validateParams(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
    }

    private void quickSortMedian3WithInSort(double[] data) {
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
                if (right - left < 60) {
                    insertionSort(data, left, right);
                } else {
                    pivot = partition(data, left, right);

                    if (pivot > left) {
                        starts.add(left);
                        ends.add(pivot);
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
        int pivot = sortFirstMiddleLast(nums, start, end);
        swap(nums, start + 1, pivot);
        pivot = start;
        int left = start + 1;
        int right = end;

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
        return right;
    }

    private int sortFirstMiddleLast(double[] nums, int start, int end) {
        int middle = start + ((end - start) / 2) + twoPlus(start, end);
        double[] threeElements = new double[]{nums[start], nums[middle], nums[end]};

        InsertionSort ThreeSort = new InsertionSort();
        ThreeSort.sort(threeElements);

        nums[start] = threeElements[0];
        nums[middle] = threeElements[1];
        nums[end] = threeElements[2];

        return middle;
    }

    private int twoPlus(int left, int right) {
        if (right - left == 1) {
            return 1;
        }
        return 0;
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

    private void swap(double[] nums, int firstId, int secondId) {
        if (firstId != secondId) {

            double firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;
        }
    }
}

