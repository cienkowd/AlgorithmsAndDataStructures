package pl.edu.pw.ee.aisd2023zlab3;

import pl.edu.pw.ee.aisd2023zlab3.utils.GeneralHashingTest;

public class HashQuadraticProbingTest extends GeneralHashingTest<HashQuadraticProbing<String>> {
    public HashQuadraticProbingTest() {
        super(new HashQuadraticProbing<>());
    }

    @Override
    protected void createHashTable(int initialSize) {
        hashTable = new HashQuadraticProbing<>(initialSize);
    }
}
