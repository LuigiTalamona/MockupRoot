package org.talamona.chapter7.exercise7_8_1;

/**
 *
 * @author luigi
 */
public class MailClient {
    
    public void sendMail(String address, String title, String body){
        Email email = new Email(address, title, body);
        EmailServer.sendMail(email);
    }
}
