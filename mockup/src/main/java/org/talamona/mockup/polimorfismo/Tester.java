package org.talamona.mockup.polimorfismo;

import java.util.Random;
/**
 *
 * @author luigi
 */
public class Tester {

    public static void main(String[] args) {
        Random randoming = new Random();
        int choice = randoming.nextInt();
        I obj = null;
        switch (choice) {
            case 0: {
                obj = new A();
                break;
            }
            case 1: {
                obj = new B();
                break;
            }
            case 2: {
                obj = new C();
                break;
            }
            default: {
                obj = new D();
                break;
            }
        }
        obj.doSomething();
    }
}
