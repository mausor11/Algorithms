package HashTables.Tests;

import HashTables.HashListChaining.HashListChainingModularHashing;
import HashTables.utils.GeneralHashListChainingTest;
import org.junit.Before;

public class HashListChainingModularHashingTest extends GeneralHashListChainingTest {
    @Before
    public void setup() {
        hashString = new HashListChainingModularHashing<>();
    }

}
