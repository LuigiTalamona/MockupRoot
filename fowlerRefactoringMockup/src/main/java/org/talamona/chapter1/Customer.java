package org.talamona.chapter1;

import java.util.List;

/**
 *
 * @author luigi
 */
public interface Customer {

    public List getRentals();

    public String statement();
    
    public String getName();

    public void setName(String name);
}
