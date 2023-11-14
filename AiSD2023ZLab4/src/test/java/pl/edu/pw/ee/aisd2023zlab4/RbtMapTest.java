package pl.edu.pw.ee.aisd2023zlab4;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static pl.edu.pw.ee.aisd2023zlab4.utils.AdvancedTreeGetters.getNumOfElems;

public class RbtMapTest {
    private RbtMap<Integer, String> rbtMap;

    private RedBlackTree<Integer, String> tree;

    @Before
    public void setUp() {
        rbtMap = new RbtMap<>();
    }

    @Test
    public void shouldGetCorrectValueAfterSetValue() {
        //when
        rbtMap.setValue(1, "One");
        rbtMap.setValue(2, "Two");
        rbtMap.setValue(3, "Three");

        //then
        assertThat("One").isEqualTo(rbtMap.getValue(1));
        assertThat("Two").isEqualTo(rbtMap.getValue(2));
        assertThat("Three").isEqualTo(rbtMap.getValue(3));
    }

    @Test
    public void shouldThrowExceptionWhenSettingValueWithNullKey() {
        //given
        String value = null;

        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            rbtMap.setValue(null, value);
        });

        // then
        String message = "Params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldThrowExceptionWhenGettingValueWithNullKey1() {
        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            rbtMap.getValue(null);
        });

        // then
        String message = "Cannot get value by null key.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldThrowExceptionWhenGettingValueWithNullKey2() {
        //given
        tree = new RedBlackTree<>();

        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            tree.get(null);
        });

        // then
        String message = "Key cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldThrowExceptionWhenPuttingValueWithNullKey() {
        //given
        tree = new RedBlackTree<>();
        String value = "value";

        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            tree.put(null, value);
        });

        // then
        String message = "Input params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldThrowExceptionWhenPuttingNullValueWithKey() {
        //given
        tree = new RedBlackTree<>();
        String value = null;

        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            tree.put(1, value);
        });

        // then
        String message = "Input params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldThrowExceptionWhenSettingNullValueWithKey() {
        //given
        String value = null;

        //when
        Throwable exceptionCaught = catchThrowable(() -> {
            rbtMap.setValue(1, value);
        });

        // then
        String message = "Params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void shouldReturnNullResultWhenGettingNotExistingKey() {
        //when
        tree = new RedBlackTree<>();
        tree.get(1);

        //then
        assertThat(tree.get(1)).isEqualTo(null);
    }

    @Test
    public void testSizeAfterInsertion() {
        //given
        String newElem = "P. Czarnek";

        // when
        int nOfElemsBeforePut = getNumOfElems(rbtMap);
        for (int i = 0; i < 10; i++)
            rbtMap.setValue(i, newElem + i);
        int nOfElemsAfterPut = getNumOfElems(rbtMap);

        // then
        assertThat(nOfElemsBeforePut).isEqualTo(0);
        assertThat(nOfElemsAfterPut).isEqualTo(10);
    }

    @Test
    public void shouldOverwriteElementWithSameKey() {
        // given
        String value1 = "Value1";
        String value2 = "Value2";

        // when
        rbtMap.setValue(1, value1);
        rbtMap.setValue(1, value2);

        // then
        assertThat(rbtMap.getValue(1)).isEqualTo(value2);
    }

    @Test
    public void shouldCorrectlyAddWord() {
        //given
        rbtMap.setValue(2, "C");
        rbtMap.setValue(9, "z");
        rbtMap.setValue(1, "a");
        rbtMap.setValue(8, "r");
        rbtMap.setValue(7, "o");
        rbtMap.setValue(3, "d");
        rbtMap.setValue(5, "i");
        rbtMap.setValue(4, "e");
        rbtMap.setValue(6, "j");

        //when
        Node<Integer, String> root = rbtMap.getRoot();

        //then
        assertRightLeavesAreNotRed(root);
        assertLeftLeavesAfterEachOtherAreNotRed(root);
    }

    private void assertRightLeavesAreNotRed(Node<Integer, String> node) {
        if (node == null) {
            return;
        }

        Node<Integer, String> leftChild = node.getLeft();
        Node<Integer, String> rightChild = node.getRight();

        if (rightChild != null)
            assertThat(rightChild.getColor()).isNotEqualTo(Color.RED);

        if (rightChild != null)
            assertRightLeavesAreNotRed(rightChild);
        if (leftChild != null)
            assertRightLeavesAreNotRed(leftChild);
    }

    private void assertLeftLeavesAfterEachOtherAreNotRed(Node<Integer, String> node) {
        if (node == null) {
            return;
        }

        Node<Integer, String> leftChild = node.getLeft();
        Node<Integer, String> rightChild = node.getRight();

        if (node.isRed() && leftChild != null)
            assertThat(leftChild.getColor()).isNotEqualTo(Color.RED);

        if (leftChild != null)
            assertLeftLeavesAfterEachOtherAreNotRed(leftChild);
        if (rightChild != null)
            assertLeftLeavesAfterEachOtherAreNotRed(rightChild);

    }
}
