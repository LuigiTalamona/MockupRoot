package org.talamona.substituteAlgorithm.after;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/25/13
 * Time: 11:25 AM
 */
public class SubstituteAlgorithmBaseClassRefactored {


    public String findPerson(String[] people){
        String retValue = null;
        String[] candidates = {"Peppino","Nome1","Nome2","Nome3"};
        List persons = Arrays.asList(people);
        for (int i = 0; i < people.length; i++){
            if (persons.contains(people[i])){
                retValue = people[i];
                break;
            }
        }
        return retValue;
    }
}
