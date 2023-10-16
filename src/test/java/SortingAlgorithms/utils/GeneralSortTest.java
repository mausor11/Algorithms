package SortingAlgorithms.utils;

import SortingAlgorithms.services.Sorting;
import org.junit.Test;

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
    public void should_CorrectlyAscendingSort_WhenInputIsRandomAndHugeAndNegative() {
        // given
        int size = 10_000;
        double[] nums = createRandomDataNegative(size);
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);
    }

    @Test
    public void should_CorrectlyAscendingSort_WhenInputIsOneElement() {
        // given
        int size = 1;
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
    public void should_CorrectlyAscendingSort_WhenInputIsOddAndHuge() {
        // given
        int size = 30_000;
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
    public void should_CorrectlyAscendingSort_WhenInputIsEvenAndHuge() {
        // given
        int size = 30_001;
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
    public void should_CorrectlyAscendingSort_WhenInputIsOptimisticScenario() {
        // given
        int size = 10_000;
        double[] nums = new double[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);


    }

    @Test
    public void should_CorrectlyAscendingSort_WhenInputIsPessimisticScenario() {
        // given
        int size = 10_000;
        double[] nums = new double[size];
        int j = 10_000;
        for (int i = 0; i < size; i++) {
            nums[i] = j;
            j--;
        }
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);
    }

    @Test
    public void should_CorrectlyAscendingSort_WhenInputIsOneValueArray() {
        // given
        int size = 10_000;
        double[] nums = new double[size];
        for (int i = 0; i < size; i++) {
            nums[i] = 0;
        }
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);
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
    private double[] createRandomDataNegative(int size) {
        assert size >= 0;

        double[] nums = new double[size];

        long eliteSeed = 31337;
        Random rand = new Random(eliteSeed);

        for (int i = 0; i < size; i++) {
            nums[i] = -rand.nextDouble() * Double.MAX_VALUE;
        }

        return nums;
    }
}
