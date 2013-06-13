package org.talamona.refactoringSerialDate.org.jfree.date;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/28/13
 * Time: 4:04 PM
 */
public abstract class DayDateFactory {
    private DayDateFactory instance;

    public DayDateFactory getInstance(){
        if (this.instance == null){
            this.instance = new SpreadsheetDateFactory();
        }
        return this.instance;
    }
    public void setInstance(DayDateFactory factory){
        this.instance = factory;
    }

    public abstract DayDate makeDate(int ordinal);
    public abstract DayDate makeDate(int day, DayDate.Month month, int year);
    public abstract DayDate makeDate(int day, int month, int year);
    public abstract DayDate makeDate(java.util.Date date);

    public abstract int getMinimumYear();
    public abstract int getMaximumYear();
}
