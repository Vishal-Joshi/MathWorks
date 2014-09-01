package mw;

import java.util.List;

/**
 * Created by ee on 8/28/2014.
 */
public class OddAndPrimeNumberIdentifier implements NumberIdentifier {

    private final PrimeNumberIdentifier primeNumberIdentifier;
    private final OddNumberIdentifier oddNumberIdentifier;

    public OddAndPrimeNumberIdentifier(PrimeNumberIdentifier primeNumberIdentifier, OddNumberIdentifier oddNumberIdentifier) {
        this.primeNumberIdentifier = primeNumberIdentifier;
        this.oddNumberIdentifier = oddNumberIdentifier;
    }

    public List<Integer> identify(List<Integer> listOfNumbers) {
        List<Integer> listOfOddAndPrimeNumbers = oddNumberIdentifier.identify(primeNumberIdentifier.identify(listOfNumbers));
        return listOfOddAndPrimeNumbers;
    }
}
