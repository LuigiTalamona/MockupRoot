package org.talamona.substituteAlgorithm;

import org.talamona.substituteAlgorithm.after.SubstituteAlgorithmBaseClassRefactored;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/25/13
 * Time: 11:28 AM
 */
public class SubstituteAlgorithmBaseClassTest {




    @DataProvider
    public Object[][] getTestValues(){
        return null;

    }


    @Test
    public void shouldBeFindAPerson() throws Exception {
        SubstituteAlgorithmBaseClass sut = new SubstituteAlgorithmBaseClass();

        String[] people = {"Peppino", "Peppone", "Pallino"};
        String expected = "Peppino";
        String actual = sut.findPerson(people);
        assertEquals(actual, expected);
    }
    @Test
    public void shouldBeFindAPersonRefactored() throws Exception {
        SubstituteAlgorithmBaseClassRefactored sut = new SubstituteAlgorithmBaseClassRefactored();

        String[] people = {"Peppino", "Peppone", "Pallino"};
        String expected = "Peppino";
        String actual = sut.findPerson(people);
        assertEquals(actual, expected);
    }
}
