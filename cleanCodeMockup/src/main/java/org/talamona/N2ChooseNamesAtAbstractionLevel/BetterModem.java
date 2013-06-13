package org.talamona.N2ChooseNamesAtAbstractionLevel;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/4/13
 * Time: 9:37 AM
 */
public interface BetterModem {
    public boolean dial(String connectionLocator);
    public boolean disconnect();
    public boolean send(char c);
    public char receive();
    public String getConnectedLocator();

}
