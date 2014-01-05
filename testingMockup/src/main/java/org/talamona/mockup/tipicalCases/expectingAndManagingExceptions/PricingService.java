package org.talamona.mockup.tipicalCases.expectingAndManagingExceptions;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 3:32 PM
 */
public interface PricingService {
public void setDataAccess(DataAccess dataAccess);
public BigDecimal getPrice(String sku) throws SkuNotFoundException;
}

