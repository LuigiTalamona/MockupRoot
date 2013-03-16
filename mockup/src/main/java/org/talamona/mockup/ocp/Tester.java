package org.talamona.mockup.ocp;

/**
 *
 * @author luigi
 */
public class Tester{

    public static void main(String[] args) {
        
        Client1 c = null;
        if (args[0] != null){
            c = new Client1(new Server1());
        }else{
            c = new Client1(new Server2());
        }
        c.run();
    }
    
}
