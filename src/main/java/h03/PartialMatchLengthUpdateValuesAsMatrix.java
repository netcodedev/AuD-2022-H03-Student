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
     * @param fct          The function to be used.
     * @param searchString The search string to be used.
     */
    @SuppressWarnings("unchecked")
    public PartialMatchLengthUpdateValuesAsMatrix(FunctionToInt<T> fct, T[] searchString) {
        super(fct);
        matrix = new int[searchString.length+1][fct.sizeOfAlphabet()];
        for(int i = 0; i<=searchString.length; i++){
            for(int j = 0; j<searchString.length; j++){
                if(i<searchString.length && searchString[i] == searchString[j]){
                    matrix[i][fct.apply(searchString[j])] = i+1;
                } else {
                    T[] substr = (T[])new Object[i+1];
                    for(int k = 0; k<i;k++){
                        substr[k] = searchString[k];
                    }
                    substr[i] = searchString[j];
                    var match = computePartialMatchLengthUpdateValues(substr);
                    if(match > 0){
                        System.out.print("match: "+match+": ");
                        for(int l = 0; l<substr.length; l++){
                            System.out.print(substr[l]);
                        }
                        System.out.println();
                    }
                    matrix[i][fct.apply(searchString[j])] = match;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPartialMatchLengthUpdate(int state, T letter) {
        return matrix[state][fct.apply(letter)];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSearchStringLength() {
        return matrix.length-1;
    }
}
