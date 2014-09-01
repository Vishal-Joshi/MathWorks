package mw;

import java.util.List;

/**
 * Created by ee on 8/28/2014.
 */
public class OddAndPrimeNumberIdentifierBetweenGivenRange implements NumberIdentifier {

    private final NumbersIdentifierBetweenSpecifiedRange numbersIdentifierBetweenSpecifiedRange;
    private final OddAndPrimeNumberIdentifier oddAndPrimeNumberIdentifier;

    public OddAndPrimeNumberIdentifierBetweenGivenRange(NumbersIdentifierBetweenSpecifiedRange numbersIdentifierBetweenSpecifiedRange,OddAndPrimeNumberIdentifier oddAndPrimeNumberIdentifier) {
        this.numbersIdentifierBetweenSpecifiedRange = numbersIdentifierBetweenSpecifiedRange;
        this.oddAndPrimeNumberIdentifier = oddAndPrimeNumberIdentifier;
    }

    @Override
    public List<Integer> identify(List<Integer> listOfNumbers) {
       return oddAndPrimeNumberIdentifier.identify(numbersIdentifierBetweenSpecifiedRange.identify(listOfNumbers));
    }
}
