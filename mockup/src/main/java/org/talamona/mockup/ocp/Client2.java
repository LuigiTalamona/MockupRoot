package org.talamona.mockup.ocp;

/**
 *
 * @author luigi
 */
public class Client2 {
    private Server1 server;
    
    public void run(){
        this.server.call();
    }
    
}
