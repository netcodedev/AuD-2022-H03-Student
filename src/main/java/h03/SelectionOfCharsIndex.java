package h03;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A class that represents a function with a given alphabet.
 */
public class SelectionOfCharsIndex implements FunctionToInt<Character> {
    /**
     * The chars of the objects' alphabet.
     */
    private final char[] theChars;

    /**
     * Constructs a new SelectionOfCharsIndex object with the given alphabet scope.
     * The given alphabet must not be null, has to contain at least one element and each element has to be unique.
     *
     * @param theAlphabet The given alphabet.
     */
    public SelectionOfCharsIndex(List<Character> theAlphabet) {
        if(theAlphabet == null) throw new NullPointerException("alphabet must not be null");
        if(theAlphabet.size() == 0) throw new IllegalArgumentException("Alphabet must contain at least one element");
        if(containsDuplicates(theAlphabet)) throw new IllegalArgumentException("Alphabet must not contain duplicate characters");
        theChars = new char[theAlphabet.size()];
        IntStream.range(0, theAlphabet.size()).forEach(i -> theChars[i] = theAlphabet.get(i));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int sizeOfAlphabet() {
        return theChars.length;
    }

    /**
     * Returns the index at which the given parameter is contained in the alphabet.
     *
     * @param character The given parameter to be searched for.
     * @return The index of the given parameter.
     * @throws IllegalArgumentException Iff the given parameter is not contained in the alphabet.
     */
    @Override
    public int apply(Character character) throws IllegalArgumentException {
        for(int i = 0; i<theChars.length; i++){
            if(theChars[i] == character){
                return i;
            }
        }
        throw new IllegalArgumentException("The given character is not contained in the alphabet");
    }

    public static boolean containsDuplicates(List<Character> list) {
        return list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet()).size()>0;

    }
}
