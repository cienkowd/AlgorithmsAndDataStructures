package pl.edu.pw.ee.aisd2023zlab2;

public class HashListChainingMultiplicativeHashing<T extends Comparable<T>> extends HashListChaining<T>{

    public HashListChainingMultiplicativeHashing() {
        super();
    }

    public HashListChainingMultiplicativeHashing(int size) {
        super(size);
    }

    @Override
    int countHashId(T value) {
      int hashCode = value.hashCode();

        return (int) (size*(((hashCode & Integer.MAX_VALUE)*0.618) % 1));
    }
}
