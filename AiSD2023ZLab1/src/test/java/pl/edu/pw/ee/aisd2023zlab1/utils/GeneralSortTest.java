package pl.edu.pw.ee.aisd2023zlab1.utils;

import org.testng.annotations.Test;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public abstract class GeneralSortTest {

    protected Sorting sorter;

    public GeneralSortTest(Sorting sorter) {
        this.sorter = sorter;
    }

    @Test
    public void should_ThrowException_WhenInputIsNull() {
        // given
        double[] nums = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            sorter.sort(nums);
        });

        // then
        String message = "Input args (nums) cannot be null!";

        assertThat(exceptionCaught)
                .isInstanceOf(RuntimeException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ReturnEmptyArray_WhenInputIsEmpty() {
        // given
        double[] nums = {};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isEmpty();
    }

    @Test
    public void should_CorrectlyAscendingSort_WhenInputIsRandomAndHuge() {
        // given
        int size = 10_000;
        double[] nums = createRandomData(size);
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);
    }

    @Test
    public void should_CorrectlySortInWorstCaseScenario() {
        // given
        double[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_HandleEdgeCaseWithSingleElement() {
        // given
        double[] nums = {42};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_HandleEdgeCaseWithTwoElements() {
        // given
        double[] nums = {42, 15};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    void should_HandleEdgeCaseWithThreeElements() {
        // given
        double[] nums = {42, 15, 35};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_CorrectlySortNegativeNumbers() {
        // given
        double[] nums = {-4, -2, -5, -1, -3};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_CorrectlySortLargestAndSmalestValue() {
        // given
        double[] nums = {Double.MAX_VALUE, Double.MIN_VALUE};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_PreserveDuplicateOrder_WhenInputContainsDuplicates() {
        // given
        double[] nums = {4, 2, 1, 4, 3, 2, 1, 3, 1, 2, 4, 3};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_PreserveOrder_WhenInputIsAlreadySorted() {
        // given
        double[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted();
    }

    @Test
    public void should_HandleLargeDataSetQuickly() {
        // given
        int size = 1000000;
        double[] nums = createRandomData(size);

        // when
        long startTime = System.currentTimeMillis();
        sorter.sort(nums);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // then
        assertThat(nums).isSorted();
        System.out.println("Sortowanie " + size + " elementów zajęło " + executionTime + " ms.");
    }

    private double[] createRandomData(int size) {
        assert size >= 0;

        double[] nums = new double[size];

        long eliteSeed = 31337;
        Random rand = new Random(eliteSeed);

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextDouble();
        }

        return nums;
    }
}
