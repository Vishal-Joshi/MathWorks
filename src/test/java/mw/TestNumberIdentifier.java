package mw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 8/27/2014.
 */
public class TestNumberIdentifier {

    List<Integer> listOfNumbers;

    @Before
    public void setUp() {
        //Given

        listOfNumbers = new ArrayList<Integer>();
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 15;
        final int INCREMENT_BY = 1;
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i = i + INCREMENT_BY) {
            listOfNumbers.add(i);
        }
    }

    @Test
    public void testShouldReturnPrimeNumbersFromTheListContainingPrimeAndNonPrimeNumbers() {
        //Given
        List<Integer> expectedListOfPrimeNumbers = new ArrayList<Integer>() {
        };
        expectedListOfPrimeNumbers.add(2);
        expectedListOfPrimeNumbers.add(3);
        expectedListOfPrimeNumbers.add(5);
        expectedListOfPrimeNumbers.add(7);
        expectedListOfPrimeNumbers.add(11);
        expectedListOfPrimeNumbers.add(13);
        NumberIdentifier primeNumberIdentifier = new PrimeNumberIdentifier();
        //When
        List<Integer> listOfPrimeNumbers = primeNumberIdentifier.identify(listOfNumbers);
        //Then
        Assert.assertEquals(expectedListOfPrimeNumbers, listOfPrimeNumbers);

    }

    @Test
    public void testShouldBeAbleToFindOddNumbersFromTheGivenSetOfNumbers() {
        //Given
        List<Integer> expectedListOfOddNumbers = new ArrayList<Integer>();
        expectedListOfOddNumbers.add(1);
        expectedListOfOddNumbers.add(3);
        expectedListOfOddNumbers.add(5);
        expectedListOfOddNumbers.add(7);
        expectedListOfOddNumbers.add(9);
        expectedListOfOddNumbers.add(11);
        expectedListOfOddNumbers.add(13);
        expectedListOfOddNumbers.add(15);
        NumberIdentifier oddNumberIdentifier = new OddNumberIdentifier();

        //When
        List<Integer> listOfOddNumbers = oddNumberIdentifier.identify(listOfNumbers);

        //Then
        Assert.assertEquals(expectedListOfOddNumbers, listOfOddNumbers);
    }

    @Test
    public void testShouldBeAbleToFindOddPrimeNumbers() {
        //Given
        List<Integer> expectedListOfOddPrimeNumbers = new ArrayList<Integer>();
        expectedListOfOddPrimeNumbers.add(3);
        expectedListOfOddPrimeNumbers.add(5);
        expectedListOfOddPrimeNumbers.add(7);
        expectedListOfOddPrimeNumbers.add(11);
        expectedListOfOddPrimeNumbers.add(13);
        PrimeNumberIdentifier primeNumberIdentifier = new PrimeNumberIdentifier();
        OddNumberIdentifier oddNumberIdentifier = new OddNumberIdentifier();
        NumberIdentifier oddAndPrimeNumberIdentifier = new OddAndPrimeNumberIdentifier(primeNumberIdentifier,
                oddNumberIdentifier);

        //When
        List<Integer> listOfOddPrimeNumbers = oddAndPrimeNumberIdentifier.identify(listOfNumbers);

        //Then
        Assert.assertEquals(expectedListOfOddPrimeNumbers, listOfOddPrimeNumbers);
    }

    @Test
    public void testShouldBeAbleToFindNumbersBetween5to10() {
        //Given
        List<Integer> expectedListOfNumbersBetween5To10 = new ArrayList<Integer>();
        expectedListOfNumbersBetween5To10.add(5);
        expectedListOfNumbersBetween5To10.add(6);
        expectedListOfNumbersBetween5To10.add(7);
        expectedListOfNumbersBetween5To10.add(8);
        expectedListOfNumbersBetween5To10.add(9);
        expectedListOfNumbersBetween5To10.add(10);
        final int MINIMUM_NUMBER = 5;
        final int MAXIMUM_NUMBER = 10;
        NumberIdentifier numbersBetween5and10Identifier = new NumbersIdentifierBetweenSpecifiedRange(MINIMUM_NUMBER,
                MAXIMUM_NUMBER);

        //When
        List<Integer> listOfNumbersBetween5To10 = numbersBetween5and10Identifier.identify(listOfNumbers);

        //Then
        Assert.assertEquals(expectedListOfNumbersBetween5To10, listOfNumbersBetween5To10);
    }

    @Test
    public void testShouldBeAbleToFindOddAndPrimeNumbersBetween2to31() {
        //Given
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 35;
        final int INCREMENT_BY = 1;
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i = i + INCREMENT_BY) {
            listOfNumbers.add(i);
        }
        List<Integer> expectedListOfOddAndPrimeNumbersBetween2To31 = new ArrayList<Integer>();
        expectedListOfOddAndPrimeNumbersBetween2To31.add(3);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(5);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(7);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(11);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(13);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(17);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(19);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(23);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(29);
        expectedListOfOddAndPrimeNumbersBetween2To31.add(31);
        final int MINIMUM_NUMBER = 2;
        final int MAXIMUM_NUMBER = 31;
        NumbersIdentifierBetweenSpecifiedRange numbersBetween5and10Identifier = new
                NumbersIdentifierBetweenSpecifiedRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        PrimeNumberIdentifier primeNumberIdentifier = new PrimeNumberIdentifier();
        OddNumberIdentifier oddNumberIdentifier = new OddNumberIdentifier();
        OddAndPrimeNumberIdentifier oddAndPrimeNumberIdentifier = new OddAndPrimeNumberIdentifier
                (primeNumberIdentifier, oddNumberIdentifier);
        NumberIdentifier oddAndPrimeNumberIdentifierBetweenGivenRange =
                new OddAndPrimeNumberIdentifierBetweenGivenRange(numbersBetween5and10Identifier,
                        oddAndPrimeNumberIdentifier);

        //When
        List<Integer> listOfOddAndPrimeNumbersBetween2To31 = oddAndPrimeNumberIdentifierBetweenGivenRange.identify
                (listOfNumbers);

        //Then
        Assert.assertEquals(expectedListOfOddAndPrimeNumbersBetween2To31, listOfOddAndPrimeNumbersBetween2To31);
    }
}
