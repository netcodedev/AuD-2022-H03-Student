package h03;

public class EnumIndex<T extends Enum<T>> implements FunctionToInt<T>{
    public EnumIndex(Class<T> enumClass) {
    }

    @Override
    public int sizeOfAlphabet() {
        return 0;
    }

    @Override
    public int apply(T t) throws IllegalArgumentException {
        return 0;
    }
}
