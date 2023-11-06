package pl.edu.pw.ee.aisd2023zlab3;

import pl.edu.pw.ee.aisd2023zlab3.utils.GeneralHashingTest;

public class HashLinearProbingTest extends GeneralHashingTest<HashLinearProbing<String>> {
    public HashLinearProbingTest() {
        super(new HashLinearProbing<>());
    }

    @Override
    protected void createHashTable(int initialSize) {
        hashTable = new HashLinearProbing<>(initialSize);
    }
}
