package org.talamona.mockup.tipicalCases.expectingAndManagingExceptions;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 3:43 PM
 */
public class PricingServiceImpl implements PricingService {

    private DataAccess dataAccess;

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public BigDecimal getPrice(String sku) throws SkuNotFoundException {
        BigDecimal price = this.dataAccess.getPriceBySku(sku);
        if (price == null) {
            throw new SkuNotFoundException("SKU not found.");
        }
        return price;
    }
}
