package org.talamona.mockup.tipicalCases.verifyingCallOrderTestCase;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:45 PM
 */
import org.talamona.mockup.tipicalCases.verifyingBehavior.WaterSource;

import org.testng.annotations.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.inOrder;

public class WaterSourceForCallOrderTest {

    @Test
    public void shouldVerifyInOrderThroughDifferentMocks() {
        WaterSource waterSource1 = mock(WaterSource.class);
        WaterSource waterSource2 = mock(WaterSource.class);
        waterSource1.doSelfCheck();
        waterSource2.getPressure();
        waterSource1.getTemperature();
        InOrder inOrder = inOrder(waterSource1, waterSource2);
        inOrder.verify(waterSource1).doSelfCheck();
        inOrder.verify(waterSource2).getPressure();
        inOrder.verify(waterSource1).getTemperature();
    }
}
