package RedBlackTrees;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static RedBlackTrees.utils.AdvancedGetters.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RbtMapTest {
    private RbtMap<Integer, String> stringRbtMap;
    private RedBlackTree<Integer, String> stringRedBlackTree;
    @Before
    public void setup() {
        stringRbtMap = new RbtMap<>();
        stringRedBlackTree = new RedBlackTree<>();
    }
    @Test
    public void should_RbtMap_ThrowException_WhenTryingAdd_NullValue() {
        // given
        String nullValue = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRbtMap.setValue(0, nullValue);
        });
        int nOfElemsAfterSet = getNumOfElems(stringRbtMap);

        // then
        String message = "Params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
        assertThat(nOfElemsAfterSet).isEqualTo(0);
    }
    @Test
    public void should_RbtMap_ThrowException_WhenTryingAdd_NullKey() {
        // given
        Integer nullKey = null;
        String value = "K. West";

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRbtMap.setValue(nullKey, value);
        });
        int nOfElemsAfterSet = getNumOfElems(stringRbtMap);

        // then
        String message = "Params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
        assertThat(nOfElemsAfterSet).isEqualTo(0);
    }
    @Test
    public void should_RbtMap_ThrowException_WhenTryingGet_NullKey() {
        // given
        Integer nullKey = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRbtMap.getValue(nullKey);
        });

        // then
        String message = "Cannot get value by null key.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
    @Test
    public void should_RedBlackTree_ThrowException_WhenTryingGet_NullKey() {
        // given
        Integer nullKey = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRedBlackTree.get(nullKey);
        });

        // then
        String message = "Key cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
    @Test
    public void should_RedBlackTree_ThrowException_WhenTryingPut_NullKey() {
        // given
        Integer nullKey = null;
        String value = "Drake";

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRedBlackTree.put(nullKey, value);
        });

        // then
        String message = "Input params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
    @Test
    public void should_RedBlackTree_ThrowException_WhenTryingPut_NullValue() {
        // given
        Integer key = 1;
        String nullValue = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            stringRedBlackTree.put(key, nullValue);
        });

        // then
        String message = "Input params (key, value) cannot be null.";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
    @Test
    public void should_CorrectlyAddNewElems() {
        // given
        int key = 0;
        String value = "T. Lanez";

        // when
        int nOfElemsBeforeSet = getNumOfElems(stringRbtMap);
        stringRbtMap.setValue(key, value);
        int nOfElemsAfterSet = getNumOfElems(stringRbtMap);


        //then
        assertThat(nOfElemsBeforeSet).isEqualTo(0);
        assertThat(nOfElemsAfterSet).isEqualTo(1);
        assertThat(isRed(stringRbtMap.getRoot())).isFalse();
        assertThat(stringRbtMap.getRoot().getLeft()).isNull();
        assertThat(stringRbtMap.getRoot().getRight()).isNull();
    }
    @Test
    public void should_CorrectlyAdd_CZARODIEJ_Word() {

        // when
        stringRbtMap.setValue(2, "c");
        stringRbtMap.setValue(9, "z");
        stringRbtMap.setValue(1, "a");
        stringRbtMap.setValue(8, "r");
        stringRbtMap.setValue(7, "o");
        stringRbtMap.setValue(3, "d");
        stringRbtMap.setValue(5, "i");
        stringRbtMap.setValue(4, "e");
        stringRbtMap.setValue(6, "j");

        // then

        // 1. level
        assertThat(isRed(stringRbtMap.getRoot())).isFalse();
        assertThat(stringRbtMap.getRoot().getValue()).isEqualTo("i");

        // 2. level
        assertThat(isRed(stringRbtMap.getRoot().getLeft())).isFalse();
        assertThat(stringRbtMap.getRoot().getLeft().getValue()).isEqualTo("c");
        assertThat(isRed(stringRbtMap.getRoot().getRight())).isFalse();
        assertThat(stringRbtMap.getRoot().getRight().getValue()).isEqualTo("r");

        // 3. level
        assertThat(isRed(stringRbtMap.getRoot().getLeft().getLeft())).isFalse();
        assertThat(stringRbtMap.getRoot().getLeft().getLeft().getValue()).isEqualTo("a");
        assertThat(isRed(stringRbtMap.getRoot().getLeft().getRight())).isFalse();
        assertThat(stringRbtMap.getRoot().getLeft().getRight().getValue()).isEqualTo("e");

        assertThat(isRed(stringRbtMap.getRoot().getRight().getLeft())).isFalse();
        assertThat(stringRbtMap.getRoot().getRight().getLeft().getValue()).isEqualTo("o");
        assertThat(isRed(stringRbtMap.getRoot().getRight().getRight())).isFalse();
        assertThat(stringRbtMap.getRoot().getRight().getRight().getValue()).isEqualTo("z");

        // 4. level
        assertThat(stringRbtMap.getRoot().getLeft().getLeft().getLeft()).isNull();
        assertThat(stringRbtMap.getRoot().getLeft().getLeft().getRight()).isNull();

        assertThat(isRed(stringRbtMap.getRoot().getLeft().getRight().getLeft())).isTrue();
        assertThat(stringRbtMap.getRoot().getLeft().getRight().getLeft().getValue()).isEqualTo("d");
        assertThat(stringRbtMap.getRoot().getLeft().getRight().getRight()).isNull();

        assertThat(isRed(stringRbtMap.getRoot().getRight().getLeft().getLeft())).isTrue();
        assertThat(stringRbtMap.getRoot().getRight().getLeft().getLeft().getValue()).isEqualTo("j");
        assertThat(stringRbtMap.getRoot().getRight().getLeft().getRight()).isNull();

        assertThat(stringRbtMap.getRoot().getRight().getRight().getLeft()).isNull();
        assertThat(stringRbtMap.getRoot().getRight().getRight().getRight()).isNull();

        // 5. level
        assertThat(stringRbtMap.getRoot().getLeft().getRight().getLeft().getLeft()).isNull();
        assertThat(stringRbtMap.getRoot().getLeft().getRight().getLeft().getRight()).isNull();

        assertThat(stringRbtMap.getRoot().getRight().getLeft().getLeft().getLeft()).isNull();
        assertThat(stringRbtMap.getRoot().getRight().getLeft().getLeft().getRight()).isNull();

        assertThat(isBlackRedTree(stringRbtMap.getRoot())).isTrue();

        for(int i = 1; i < 10; i++) {
            assertThat(stringRbtMap.getValue(i)).isNotNull();
        }

    }
    @Test
    public void should_ReturnNull_WhenTryingGet_NonExistingValue() {
        // given
        String existedValue = "Marek";

        // when
        stringRbtMap.setValue(0, existedValue);

        // then
        assertThat(stringRbtMap.getValue(1)).isNull();
    }
    @Test
    public void should_CorrectlyAddNewElems_BigData() {
        // given
        int key = 0;
        Random random = new Random(31137);

        // when
        int nOfElemsBeforeSet = getNumOfElems(stringRbtMap);
        for(; key < 100_000; key++) {
            stringRbtMap.setValue(key, random.nextInt() + "");
        }
        int nOfElemsAfterSet = getNumOfElems(stringRbtMap);

        // then
        assertThat(nOfElemsBeforeSet).isEqualTo(0);
        assertThat(nOfElemsAfterSet).isEqualTo(100_000);
        assertThat(isBlackRedTree(stringRbtMap.getRoot())).isTrue();
        assertThat(isBlackRedTreeTwoRedLeft(stringRbtMap.getRoot())).isTrue();
    }
    @Test
    public void should_CorrectlyAddNewElems_TwoElemsTheSameKey() {
        // given
        int key = 0;
        String valueBefore = "Offset";
        String valueAfter = "Future";

        // when
        int nOfElemsBeforeSet = getNumOfElems(stringRbtMap);
        stringRbtMap.setValue(key, valueBefore);
        String firstValue = stringRbtMap.getValue(key);

        int nOfElemsFirstSet = getNumOfElems(stringRbtMap);
        stringRbtMap.setValue(key, valueAfter);
        String secondValue = stringRbtMap.getValue(key);

        int nOfElemsAfterSet = getNumOfElems(stringRbtMap);

        //then
        assertThat(nOfElemsBeforeSet).isEqualTo(0);
        assertThat(nOfElemsFirstSet).isEqualTo(1);
        assertThat(nOfElemsAfterSet).isEqualTo(1);
        assertThat(firstValue).isEqualTo(valueBefore);
        assertThat(secondValue).isEqualTo(valueAfter);
    }
    @Test
    public void should_CorrectlyDeleteElems() {
        // given
        String value1 = "Travis Scott";
        String value2 = "Kanye";

        // when
        int nOfElemsBeforePut = getNumOfElemsTree(stringRedBlackTree);
        stringRedBlackTree.put(0, value1);
        stringRedBlackTree.put(1, value2);
        int nOfElemsAfterPut = getNumOfElemsTree(stringRedBlackTree);
        stringRedBlackTree.deleteMin();
        int nOfElemsAfterDelete = getNumOfElemsTree(stringRedBlackTree);

        // then
        assertThat(nOfElemsBeforePut).isEqualTo(0);
        assertThat(nOfElemsAfterPut).isEqualTo(2);
        assertThat(nOfElemsAfterDelete).isEqualTo(1);
    }
    @Test
    public void should_DoNothingWhenDelete_NullRoot() {
        // when
        int nOfElemsBeforeDelete = getNumOfElemsTree(stringRedBlackTree);
        stringRedBlackTree.deleteMin();
        int nOfElemsAfterDelete = getNumOfElemsTree(stringRedBlackTree);

        // then
        assertThat(nOfElemsBeforeDelete).isEqualTo(nOfElemsAfterDelete);
    }
    @Test
    public void should_CorrectlyDelete_BigData() {
        // given
        int key = 0;
        Random random = new Random(31137);

        // when
        int nOfElemsBeforeSet = getNumOfElemsTree(stringRedBlackTree);

        for(; key < 100_000; key++) {
            stringRedBlackTree.put(key, random.nextInt() + "");
        }
        int nOfElemsAfterSet = getNumOfElemsTree(stringRedBlackTree);

        for(int i = 0; i < 100_000; i++) {
            stringRedBlackTree.deleteMin();
        }
        int nOfElemsAfterDelete = getNumOfElemsTree(stringRedBlackTree);

        // then
        assertThat(nOfElemsBeforeSet).isEqualTo(0);
        assertThat(nOfElemsAfterSet).isEqualTo(100_000);
        assertThat(nOfElemsAfterDelete).isEqualTo(0);
    }

}
