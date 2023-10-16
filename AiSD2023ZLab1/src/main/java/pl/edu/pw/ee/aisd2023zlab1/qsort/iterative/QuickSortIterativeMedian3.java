package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.InsertionSort;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class QuickSortIterativeMedian3 implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        quickSortMedian3(nums);
    }

    private void validateParams(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
    }

    private void quickSortMedian3(double[] nums) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        Integer left = 0;
        Integer right = nums.length - 1;

        starts.add(left);
        ends.add(right);

        int n = 1;
        int pivot;

        if (left < right) {

            while (n > 0) {
                n--;
                left = starts.remove(n);
                right = ends.remove(n);
                pivot = partition(nums, left, right);

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

    private int partition(double[] nums, int start, int end) {
        int pivot = sortFirstMiddleLast(nums, start, end);
        swap(nums, start + 1, pivot);
        pivot = start + 1;
        int left = start + 2;
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

        swap(nums, pivot, right);
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

    private void swap(double[] nums, int firstId, int secondId) {
        if (firstId != secondId) {

            double firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;
        }
    }
}