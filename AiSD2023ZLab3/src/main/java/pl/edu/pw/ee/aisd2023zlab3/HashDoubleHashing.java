package pl.edu.pw.ee.aisd2023zlab3;

import pl.edu.pw.ee.aisd2023zlab3.exceptions.NotImplementedException;

public class HashDoubleHashing<T extends Comparable<T>> extends HashOpenAddressing<T> {

    public HashDoubleHashing() {
        super();
    }

    public HashDoubleHashing(int size) {
        super(size);
    }
    @Override
    int hashFunc(int key, int i) {
        int m = getSize();

        key = key & Integer.MAX_VALUE;

        int hashValue1 = hashFunc1(key, m);
        int hashValue2 = hashFunc2(key, m);

        return (hashValue1 + i * hashValue2 &Integer.MAX_VALUE) % m;
    }

    private int hashFunc1(int key, int i) {
        return (key % i) & Integer.MAX_VALUE;
    }

    private int hashFunc2(int key, int i) {
        return ((key % (i - 1)) + 1) & Integer.MAX_VALUE;
    }
}