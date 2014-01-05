package org.talamona.mockup.tipicalCases.expectingAndManagingExceptions;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 3:47 PM
 */
public class PricingServiceImplTest {
    private final String SKU = "3283947";
    private final String BAD_SKU = "-3283947";
    private final BigDecimal TEST_VALUE = new BigDecimal(100);


    private PricingService sut;

    @Mock
    private DataAccess mockedDependency;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.sut = new PricingServiceImpl();
        this.sut.setDataAccess(mockedDependency);
    }

    @Test
    public void testGetPrice() throws Exception {
        when(mockedDependency.getPriceBySku(SKU)).thenReturn(TEST_VALUE);
        final BigDecimal price = sut.getPrice(SKU);
        // Verify state
        assertEquals(price, TEST_VALUE);
        // Verify behavior
        verify(mockedDependency).getPriceBySku(SKU);
    }

    @Test(expectedExceptions = SkuNotFoundException.class)
    public void getPriceNonExistentSkuThrowsException() throws SkuNotFoundException {
        when(mockedDependency.getPriceBySku(BAD_SKU)).thenReturn(null);
        final BigDecimal price = sut.getPrice(BAD_SKU);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void getPriceDataAccessThrowsRuntimeException() throws SkuNotFoundException {
        when(mockedDependency.getPriceBySku(SKU)).thenThrow(new RuntimeException("Fatal data access exception."));
        final BigDecimal price = sut.getPrice(SKU);
    }
}


