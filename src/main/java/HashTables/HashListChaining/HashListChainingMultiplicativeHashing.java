package HashTables.HashListChaining;

public class HashListChainingMultiplicativeHashing<T extends Comparable<T>> extends HashListChaining<T> {
    public HashListChainingMultiplicativeHashing() {
        super();
    }

    public HashListChainingMultiplicativeHashing(int size) {
        super(size);
    }

    private static double factor = 0.618;
    @Override
    int countHashId(T value) {
        int hashCode = value.hashCode();
        return (int) (size*(((hashCode & Integer.MAX_VALUE)*factor)%1));
    }
}
