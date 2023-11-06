package pl.edu.pw.ee.aisd2023zlab3.utils;

import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab3.services.HashTable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static pl.edu.pw.ee.aisd2023zlab3.utils.AdvancedGetters.getNumOfElems;

public abstract class GeneralHashingTest<T extends HashTable<String>> {
    protected T hashTable;

    public GeneralHashingTest(T hashTable) {
        this.hashTable = hashTable;
    }

    protected abstract void createHashTable(int initialSize);

    @Test
    public void should_ThrowException_WhenInitialSizeIsLowerThanOne() {
        // given
        int initialSize = 0;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            createHashTable(initialSize);
        });

        // then
        String message = "Initial size of hash table cannot be lower than 1!";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_CorrectlyAddNewElems_WhenNotExistInHashTable() {
        // given
        String newElem = "P. Czarnek";

        // when
        int nOfElemsBeforePut = getNumOfElems(hashTable);
        hashTable.put(newElem);
        int nOfElemsAfterPut = getNumOfElems(hashTable);

        // then
        assertThat(nOfElemsBeforePut).isEqualTo(0);
        assertThat(nOfElemsAfterPut).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyAddMultipleElements() {
        // given
        String[] newElems = {"Ala", "Ula", "Ola"};

        // when
        for (String elem : newElems) {
            hashTable.put(elem);
        }

        // then
        assertThat(getNumOfElems(hashTable)).isEqualTo(newElems.length);
    }

    @Test
    public void should_RemoveElements() {
        // given
        String newElem = "Czarnek";

        // when
        hashTable.put(newElem);
        hashTable.delete(newElem);

        // then
        assertThat(getNumOfElems(hashTable)).isEqualTo(0);
    }

    @Test
    public void should_GetElements() {
        // given
        String newElem = "Ela";

        // when
        hashTable.put(newElem);

        // then
        assertThat(hashTable.get(newElem)).isEqualTo(newElem);
    }

    @Test
    public void should_OverwriteElementWithSameKey() {
        // given
        String value1 = "value";
        String value2 = "value";

        // when
        hashTable.put(value1);
        hashTable.put(value2);

        // then
        assertThat(hashTable.get(value1)).isEqualTo(value2);
    }

    @Test
    public void should_NotThrowExceptionWhenDeletingFromEmptyTable() {
        // given
        String key = "key";

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashTable.delete(key);
        });

        // then
        assertThat(getNumOfElems(hashTable)).isEqualTo(0);
        assertThat(exceptionCaught).isNull();
    }

    @Test
    public void should_NotThrowExceptionWhenDeletingNonExistingElement() {
        // given
        String key = "key";
        String value = "value";

        // when
        hashTable.put(value);
        Throwable exceptionCaught = catchThrowable(() -> {
            hashTable.delete(key);
        });

        // then
        assertThat(getNumOfElems(hashTable)).isEqualTo(1);
        assertThat(exceptionCaught).isNull();
    }

    @Test
    public void should_ThrowExceptionWhenAddingNullElement() {
        // given
        String nullElem = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashTable.put(nullElem);
        });

        // then
        assertThat(exceptionCaught).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_ThrowExceptionWhenGettingNullElement() {
        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashTable.get(null);
        });

        // then
        assertThat(exceptionCaught).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_ThrowExceptionWhenDeletingNullElement() {
        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashTable.delete(null);
        });

        // then
        assertThat(exceptionCaught).isInstanceOf(IllegalArgumentException.class);
    }
}
