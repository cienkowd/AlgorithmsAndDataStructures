package pl.edu.pw.ee.aisd2023zlab2;

import org.junit.Before;
import pl.edu.pw.ee.aisd2023zlab2.utils.GeneralHashListChainingTest;

public class HashListChainingMultiplicativeHashingTest extends GeneralHashListChainingTest {

    @Before
    public void setup() {
        hashString = new HashListChainingMultiplicativeHashing<>();
    }

}