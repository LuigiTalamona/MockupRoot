package org.talamona.chapter5.exercise5_7_2;

import java.util.Date;

/**
 *
 * @author luigi
 */
public interface Message {
    public String getText();
    public Date getDate();

    public void setCategory(Category category);

    public Category getCategory();
}
