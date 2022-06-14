package h03;

import java.util.ArrayList;
import java.util.Arrays;
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
    @SuppressWarnings("unchecked")
    public PartialMatchLengthUpdateValuesAsAutomaton(FunctionToInt<T> fct, T[] searchString) {
        super(null);
        theStates = new List[searchString.length];
        for(int i = 0; i<searchString.length; i++){
            var transitions = new ArrayList<Transition<T>>();
            for(int j = 0; j<searchString.length; j++){
                if(i<searchString.length && searchString[i] == searchString[j]){
                    transitions.add(new Transition<T>(i+1, Arrays.asList(searchString[j])));
                } else {
                    T[] substr = (T[])new Object[i+1];
                    for(int k = 0; k<i;k++){
                        substr[k] = searchString[k];
                    }
                    substr[i] = searchString[j];
                    var match = computePartialMatchLengthUpdateValues(substr);
                    transitions.add(new Transition<T>(match, Arrays.asList(searchString[j])));
                }
            }
            theStates[i] = transitions;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPartialMatchLengthUpdate(int state, T letter) {
        if(state >= theStates.length){
            return 0;
        }
        for(var t : theStates[state]){
            if(t.LETTERS.contains(letter)){
                return t.J;
            }
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSearchStringLength() {
        return theStates.length;
    }
}
