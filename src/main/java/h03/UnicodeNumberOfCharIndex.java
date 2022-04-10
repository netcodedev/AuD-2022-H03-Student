package h03;

/**
 * A class that represents a function with an alphabet over the unicode-characters.
 */
public class UnicodeNumberOfCharIndex implements FunctionToInt<Character> {

    /**
     * {@inheritDoc}
     */
    @Override
    public int sizeOfAlphabet() {
        throw new RuntimeException("H2 - not implemented"); // TODO: H2 - remove if implemented
    }

    /**
     * Returns the Unicode of the given character.
     *
     * @param character                 The character to be converted.
     * @return                          The Unicode value of the given character.
     * @throws IllegalArgumentException Will not be thrown.
     */
    @Override
    public int apply(Character character) throws IllegalArgumentException {
        throw new RuntimeException("H2 - not implemented"); // TODO: H2 - remove if implemented
    }
}
