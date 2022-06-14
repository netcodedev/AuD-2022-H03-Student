package h03;

/**
 * An abstract class that contains a function (FunctionToInt) and can compute the length of partial string matches of a given string of type T.
 *
 * @param <T> The type of objects to be searched through by an object of this class.
 */
public abstract class PartialMatchLengthUpdateValues<T> {
    /**
     * The function to be used in this object.
     */
    protected FunctionToInt<T> fct;

    /**
     * Constructs a PartialMatchLengthUpdateValues object with the given function.
     *
     * @param fct The function to be used by this object.
     */
    public PartialMatchLengthUpdateValues(FunctionToInt<T> fct) {
        this.fct = fct;
    }

    /**
     * Returns the next state that will be entered when using the given letter from the given state.
     *
     * @param state  The current state.
     * @param letter The letter to be added.
     * @return The next state.
     */
    public abstract int getPartialMatchLengthUpdate(int state, T letter);

    /**
     * Returns the length of the search string used in this object.
     *
     * @return The length of the search string.
     */
    public abstract int getSearchStringLength();

    /**
     * Returns the amount of elements k in searchString so that the first k elements of searchString match the last k elements of searchString.
     *
     * @param searchString The searchString to search through.
     * @return The amount k.
     */
    protected int computePartialMatchLengthUpdateValues(T[] searchString) {
        // Stolen from https://www.geeksforgeeks.org/longest-prefix-also-suffix/
        // slightly adjusted to also cover overlaps
        int n = searchString.length;
        if(n<2){
            return 0;
        }
        int len = 0;
        int i = n/2;
        while(i<n){
            if(searchString[i] == searchString[len]){
                ++len;
                ++i;
            } else {
                i = i-len+1;
                len = 0;
            }
        }
        return len;
    }
}
