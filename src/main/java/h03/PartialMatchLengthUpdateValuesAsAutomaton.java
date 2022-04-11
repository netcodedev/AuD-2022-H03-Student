package h03;

import java.util.List;

/**
 * A class that represents string matching BOFA using an intern array of lists of transitions -
 * basically an array containing the states and their possible transitions to other states.
 *
 * @param <T> The type of the function/letters of the used alphabet.
 */
public class PartialMatchLengthUpdateValuesAsAutomaton<T> extends PartialMatchLengthUpdateValues<T> {
    /**
     * The states of the automaton as a list of its transitions.
     */
    private List<Transition<T>>[] theStates;

    /**
     * Constructs a PartialMatchLengthUpdateValuesAsAutomaton object with the given function and search string.
     * This is done by creating the private array of this object by creating the various lists and their possible transitions to other states.
     *
     * @param fct          The function to be used.
     * @param searchString The search string to be used.
     */
    public PartialMatchLengthUpdateValuesAsAutomaton(FunctionToInt<T> fct, T[] searchString) {
        super(null);
        throw new RuntimeException("H6 - not implemented"); // TODO: H6 - remove if implemented
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPartialMatchLengthUpdate(int state, T letter) {
        throw new RuntimeException("H6 - not implemented"); // TODO: H6 - remove if implemented
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSearchStringLength() {
        throw new RuntimeException("H7 - not implemented"); // TODO: H7 - remove if implemented
    }
}
