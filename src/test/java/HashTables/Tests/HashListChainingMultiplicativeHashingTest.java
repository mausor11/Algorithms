package HashTables.Tests;

import HashTables.HashListChaining.HashListChainingMultiplicativeHashing;
import HashTables.utils.GeneralHashListChainingTest;
import org.junit.Before;

public class HashListChainingMultiplicativeHashingTest extends GeneralHashListChainingTest {
    @Before
    public void setup() {
        hashString = new HashListChainingMultiplicativeHashing<>();
    }
}
