package org.talamona.mockup.tipicalCases.verifyingCallOrderTestCase;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/5/14
 * Time: 3:31 PM
 */

import org.testng.annotations.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class VerifyExactNumberOfInvocatonsTestCase {

    @Test
    public void ShouldBeVerifyExactOrdersOfInvocations() {
        ArrayList mockedList = mock(ArrayList.class);

        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        mockedList.add("five times");
        mockedList.add("five times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");
        verify(mockedList, times(0)).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(3)).add("three times");
    }
}
