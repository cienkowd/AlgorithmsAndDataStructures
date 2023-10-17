package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Objects.isNull;

public class QuickSortIterativeRandom implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);
        quickSortRandom(nums);
    }

    private void validateParams(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
    }

    private void quickSortRandom(double[] data) {
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

    private int partition(double[] nums, int start, int end) {
        int left = start + 1;
        int right = end;
        int pivot = random(nums, start, end);

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

    private int random(double[] nums, int first, int last) {
        Random rand = new Random();
        int pivot = rand.nextInt(last - first + 1) + first;
        swap(nums, first, pivot);
        return first;
    }

    private void swap(double[] nums, int firstId, int secondId) {
        if (firstId != secondId) {

            double firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;
        }
    }
}
