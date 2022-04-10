package h03;

public abstract class PartialMatchLengthUpdateValues<T> {
    public PartialMatchLengthUpdateValues(FunctionToInt<T> fct) {
    }

    public abstract int getPartialMatchLengthUpdate(int state, T letter);

    //Hinweis aus H7
    public abstract int getSearchStringLength();

    protected int computePartialMatchLengthUpdateValues(T[] searchString) {
        return 0;
    }
}
