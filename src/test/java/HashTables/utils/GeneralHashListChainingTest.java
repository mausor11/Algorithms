package HashTables.utils;

import static HashTables.utils.AdvancedGetters.getHashElemById;
import static HashTables.utils.AdvancedGetters.getNumOfElems;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import HashTables.HashListChaining.HashListChainingModularHashing;
import HashTables.services.HashTable;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public abstract class GeneralHashListChainingTest {

    protected HashTable<String> hashString;

    public abstract void setup();

    @Test
    public void should_ThrowException_WhenTryingAddNullValue() {
        // given
        String nullValue = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashString.add(nullValue);
        });

        // then
        String message = "Value of elem in hash table cannot be null!";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenTryingGetNullValue() {
        // given
        String nullValue = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            hashString.add(nullValue);
        });

        // then
        String message = "Value of elem in hash table cannot be null!";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenTryingToCreateHashWithSizeEqualZero() {
        // given
        int size = 0;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            new HashListChainingModularHashing(size);
        });

        // then
        String message = "Hash size cannot be less than \"1\"!";

        assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ReturnCorrectSize_AfterAddingElement() {
        // given
        String value = "Ala";

        // when
        int nOfElemsBeforeAdd = getNumOfElems(hashString);
        hashString.add(value);
        int nOfElemsAfterAdd = getNumOfElems(hashString);

        // then
        assertThat(nOfElemsBeforeAdd).isEqualTo(0);
        assertThat(nOfElemsAfterAdd).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000})
    void should_NotThrowException_WhenCreatingHashWithSizeBiggerThanZero(int hashSize) {
        // given, when
        new HashListChainingModularHashing(hashSize);

        // then
        assert true;
    }

    @Test
    public void should_ReturnCorrectValue_WhenHeapIsNotEmpty() {
        // given
        hashString.add("Ala");
        hashString.add("Ola");
        hashString.add("Ewa");

        // when
        String returnedName = hashString.get("Ola");

        // then
        assertThat(returnedName).isEqualTo("Ola");
    }

    @Test
    public void should_CorrectlyAddThreeDifferentElems_WhenHashSizeEqualOne() {
        // given
        int hashSize = 1;
        HashTable<String> names = new HashListChainingModularHashing<>(hashSize);
        names.add("Ola");
        names.add("Ala");
        names.add("Ula");

        // when
        int nOfElemsInHash = getNumOfElems(names);
        String firstName = getHashElemById(names, 0);
        String secondName = getHashElemById(names, 1);
        String thirdName = getHashElemById(names, 2);

        // then
        assertThat(nOfElemsInHash).isEqualTo(3);
        assertThat(firstName).isEqualTo("Ula");
        assertThat(secondName).isEqualTo("Ala");
        assertThat(thirdName).isEqualTo("Ola");
    }

}
