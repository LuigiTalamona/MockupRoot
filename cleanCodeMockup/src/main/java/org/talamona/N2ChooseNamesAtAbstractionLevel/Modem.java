package org.talamona.N2ChooseNamesAtAbstractionLevel;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/4/13
 * Time: 9:34 AM
 */
public interface Modem {
    public boolean dial(String phoneNumber);
    public boolean disconnect();
    public boolean send(char c);
    public char receive();
    public String getConnectedPhoneNumber();
}
