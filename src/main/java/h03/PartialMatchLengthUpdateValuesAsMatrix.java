package h03;

/**
 * A class that represents string matching BOFA using an intern matrix.
 *
 * @param <T> The type of the function/letters of the used alphabet.
 */
public class PartialMatchLengthUpdateValuesAsMatrix<T> extends PartialMatchLengthUpdateValues<T> {
    /**
     * The matrix of this object in which the lookup-table is implemented.
     */
    private int[][] matrix;

    /**
     * Constructs a PartialMatchLengthUpdateValuesAsMatrix object with the given function and search string.
     * This is done by creating the private matrix of this object so that it may be used to look up next possible states.
     *
     * @param fct           The function to be used.
     * @param searchString  The search string to be used.
     */
    public PartialMatchLengthUpdateValuesAsMatrix(FunctionToInt<T> fct, T[] searchString) {
        super(null);
        throw new RuntimeException("H5 - not implemented"); // TODO: H5 - remove if implemented
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPartialMatchLengthUpdate(int state, T letter) {
        throw new RuntimeException("H5 - not implemented"); // TODO: H5 - remove if implemented
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSearchStringLength() {
        throw new RuntimeException("H7 - not implemented"); // TODO: H7 - remove if implemented
    }
}
