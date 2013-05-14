package org.talamona.chapter1.original;

import java.util.ArrayList;
import java.util.List;
import org.talamona.chapter1.Customer;
import org.talamona.chapter1.Rental;

/**
 *
 * @author luigi
 */
public abstract class AbstractCustomer implements Customer {

    private List<Rental> rentals;
    private String name;

    public AbstractCustomer(){
        this.rentals = new ArrayList<Rental>();
    }
    
    public List<Rental> getRentals() {
        return this.rentals;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
