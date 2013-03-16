package org.talamona.mockup.ocp;

/**
 *
 * @author luigi
 */
public class Client1 {
    private IServer server;
    
    public Client1(IServer s){
        this.server = s;
    }
    
    public void run(){
        this.server.call();
    }
    
}
