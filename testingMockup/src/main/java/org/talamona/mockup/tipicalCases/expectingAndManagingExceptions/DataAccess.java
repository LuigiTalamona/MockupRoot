package org.talamona.mockup.tipicalCases.expectingAndManagingExceptions;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 3:34 PM
 */
public interface DataAccess {
    public BigDecimal getPriceBySku(String sku);
}
