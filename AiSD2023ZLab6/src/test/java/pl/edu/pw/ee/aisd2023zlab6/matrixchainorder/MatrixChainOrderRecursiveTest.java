package pl.edu.pw.ee.aisd2023zlab6.matrixchainorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class MatrixChainOrderRecursiveTest {

    private MatrixChainOrderRecursive matrixChain;

    @BeforeEach
    public void setup() {
        matrixChain = new MatrixChainOrderRecursive();
    }

    @Test
    public void should_ThrowException_When_InputIsNull() {
        // given
        int[] matrixSizes = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            matrixChain.findOptimalOrder(matrixSizes);
        });

        // then
        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The matrixSizes cannot be null!");
    }

    @Test
    public void should_ThrowException_When_InputSizeIsLessThanTwo() {
        // given
        int[] matrixSizes = {7};

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            matrixChain.findOptimalOrder(matrixSizes);
        });

        // then
        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The matrixSizes must contain at least two values!");
    }

    /*
     * Based on: Cormen, Leiserson, Rivest, Stein
     */
    @Test
    public void should_ReturnCorrectResult_When_CorrectSmallInput() {
        // given
        int[] matrixSizes = {30, 35, 15, 5, 10, 20, 25};

        // when
        MatrixChainOrderResult result = matrixChain.findOptimalOrder(matrixSizes);
        int resultMinSum = result.getMinMultiplyCost();

        // then
        int expectedMinSum = 15125;
        assertThat(resultMinSum).isEqualTo(expectedMinSum);
    }

}
