package mw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 8/28/2014.
 */
public class NumbersIdentifierBetweenSpecifiedRange implements NumberIdentifier {

    private int minimumNimber;
    private int maximumNumber;
    public NumbersIdentifierBetweenSpecifiedRange(int minimumNimber, int maximumNumber){
        this.maximumNumber=maximumNumber;
        this.minimumNimber=minimumNimber;
    }

    @Override
    public List<Integer> identify(List<Integer> listOfNumbers) {
        List<Integer> listOfNumbersBetween5To10 = new ArrayList<Integer>();
        for (Integer number : listOfNumbers) {
            if(ifNumberIsBetween5To10(number)) {
                listOfNumbersBetween5To10.add(number);
            }
        }
        return listOfNumbersBetween5To10;
    }

    private boolean ifNumberIsBetween5To10(int number) {
        if(number>=minimumNimber && number<=maximumNumber){
            return true;
        }
        return false;
    }
}
