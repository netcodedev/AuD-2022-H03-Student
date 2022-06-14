package h03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class realizes the algorithm of string matching BOFA using a pre-processed PartialMatchLengthUpdateValues object to search through a given source string.
 *
 * @param <T> The type of the letters, etc.
 */
public class StringMatcher<T> {
    /**
     * The update values to be used in the algorithm.
     */
    private final PartialMatchLengthUpdateValues<T> VALUES;

    /**
     * Constructs a new StringMatcher object with the given PartialMatchLengthUpdateValues object.
     *
     * @param values The update values for this object.
     */
    public StringMatcher(PartialMatchLengthUpdateValues<T> values) {
        this.VALUES = values;
    }

    /**
     * Finds and returns all indices at which an occurrence of the search string (pre-processed with the update values object) starts in the given source.
     *
     * @param source The source string to search through.
     * @return The list of calculated indices.
     */
    public List<Integer> findAllMatches(T[] source) {
        var matches = new ArrayList<Integer>();
        if(source.length == 0) return matches;
        var potentialMatches = new HashMap<Integer, Integer>();
        for(int i = 0; i<source.length; i++){
            var toRemove = new ArrayList<Integer>();
            for(var pm : potentialMatches.entrySet()){
                var lm = VALUES.getPartialMatchLengthUpdate(pm.getValue(), source[i]);
                if(lm == VALUES.getSearchStringLength()){
                    matches.add(pm.getKey()+1);
                    toRemove.add(pm.getKey());
                } else if(lm == 0){
                    toRemove.add(pm.getKey());
                } else if(lm == pm.getValue()) {
                    toRemove.add(pm.getKey());
                } else {
                    potentialMatches.computeIfPresent(pm.getKey(), (k,v) -> v=lm);
                }
            }
            toRemove.stream().forEach(e -> potentialMatches.remove(e));
            var localMatch = VALUES.getPartialMatchLengthUpdate(0, source[i]);
            if(localMatch > 0){
                potentialMatches.put(i, localMatch);
            }
        }
        return matches;
    }
}
