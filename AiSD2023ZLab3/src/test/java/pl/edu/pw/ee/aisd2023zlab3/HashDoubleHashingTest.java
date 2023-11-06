package pl.edu.pw.ee.aisd2023zlab3;

import pl.edu.pw.ee.aisd2023zlab3.utils.GeneralHashingTest;

public class HashDoubleHashingTest extends GeneralHashingTest<HashDoubleHashing<String>> {
    public HashDoubleHashingTest() {
        super(new HashDoubleHashing<>());
    }

    @Override
    protected void createHashTable(int initialSize) {
        hashTable = new HashDoubleHashing<>(initialSize);
    }
}
