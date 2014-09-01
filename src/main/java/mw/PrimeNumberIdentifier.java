package mw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 8/28/2014.
 */
public class PrimeNumberIdentifier implements NumberIdentifier{

    public List<Integer> identify(List<Integer> listOfNumbers){
        final List<Integer> listOfPrimeNumbers = new ArrayList<Integer>();
        //logic to find prime numbers
        for(Integer number:listOfNumbers){
            if(isPrime(number)){
                listOfPrimeNumbers.add(number);
            }
        }
        return listOfPrimeNumbers;
    }

    private boolean isPrime(final int number){
        if(number==1){
            return false;
        }
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
