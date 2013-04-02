package org.talamona.chapter5.exercise5_7_2;

/**
 *
 * @author luigi
 */
public interface Client {

    public void receive(Message m);

    public void setCategory(Category myCategory);

    public Category getCategory();
    
}
