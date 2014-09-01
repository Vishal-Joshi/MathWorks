package mw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 8/28/2014.
 */
public class OddNumberIdentifier implements NumberIdentifier {

    public List<Integer> identify(List<Integer> listOfNumbers) {
        final List<Integer> listOfOddNumbers = new ArrayList<Integer>();
        for (Integer number : listOfNumbers) {
            if(isOdd(number)){
                listOfOddNumbers.add(number);
            }
        }
        return listOfOddNumbers;
    }

    private boolean isOdd(Integer number) {
        if(number%2!=0){
            return true;
        }
        return false;
    }
}
