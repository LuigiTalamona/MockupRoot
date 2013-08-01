package org.talamona.substituteAlgorithm;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/25/13
 * Time: 11:25 AM
 */
public class SubstituteAlgorithmBaseClass {


    public String findPerson(String[] people){
        String retValue = null;
        for (int i = 0; i < people.length; i++){
            if (people[i].equals("Peppino")){
                return "Peppino";
            }
            if (people[i].equals("John")) {
                return "John";
            }
            if (people[i].equals("Albert")) {
                return "Albert";
            }
        }
        return retValue;
    }




}
