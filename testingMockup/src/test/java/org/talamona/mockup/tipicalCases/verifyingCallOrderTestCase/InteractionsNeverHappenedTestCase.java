package org.talamona.mockup.tipicalCases.verifyingCallOrderTestCase;
/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/5/14
 * Time: 3:31 PM
 */
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class InteractionsNeverHappenedTestCase {
    List mockOne, mockTwo, mockThree;

    @BeforeMethod
    public void setup(){
        this.mockOne = mock(List.class);
        this.mockTwo = mock(List.class);
        this.mockThree = mock(List.class);
    }
    @Test
    public void ShouldBeVerifyExactOrdersOfInvocations() {
        	//using mocks - only mockOne is interacted
        	mockOne.add("one");
        	//ordinary verification
        	verify(mockOne).add("one");
        	//verify that method was never called on a mock
        	verify(mockOne, never()).add("two");
        	//verify that other mocks were not interacted
        	verifyZeroInteractions(this.mockTwo, this.mockThree);
    }
}
