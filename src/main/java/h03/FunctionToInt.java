package h03;

public interface FunctionToInt<T> {
    int sizeOfAlphabet();
    int apply(T t) throws IllegalArgumentException;
}
