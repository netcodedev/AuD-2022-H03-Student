package h03;

public class PartialMatchLengthUpdateValuesAsAutomaton<T> extends PartialMatchLengthUpdateValues<T> {
    public PartialMatchLengthUpdateValuesAsAutomaton(FunctionToInt<T> fct, T[] searchString) {
        super(null);
    }

    @Override
    public int getPartialMatchLengthUpdate(int state, T letter) {
        return 0;
    }

    @Override
    public int getSearchStringLength() {
        return 0;
    }
}
