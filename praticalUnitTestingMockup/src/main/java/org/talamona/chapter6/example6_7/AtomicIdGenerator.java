/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter6.example6_7;

/**
 *
 * @author luigi
 */
public class AtomicIdGenerator implements IdGenerator {
    
    private static long timeBase = System.currentTimeMillis();

    public AtomicIdGenerator() {
    }

    @Override
    public Long nextId() {
        return Long.valueOf(timeBase ++);
    }
    
}
