package pl.edu.pw.ee.aisd2023zlab3;

public class HashQuadraticProbing<T extends Comparable<T>> extends HashOpenAddressing<T> {

    public HashQuadraticProbing() {
        super();
    }

    public HashQuadraticProbing(int size) {
        super(size);
    }

    @Override
    int hashFunc(int key, int i) {
        int m = getSize();

        key = key & Integer.MAX_VALUE;

        int hashValue = key % m;

        return (hashValue + i * i) % m;
    }
}
