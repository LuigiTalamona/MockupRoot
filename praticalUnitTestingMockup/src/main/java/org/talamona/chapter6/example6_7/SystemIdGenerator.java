/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter6.example6_7;

/**
 *
 * @author luigi
 */
public class SystemIdGenerator implements IdGenerator {
    

    public SystemIdGenerator() {
    }

    @Override
    public Long nextId() {
        return Long.valueOf(System.currentTimeMillis());
    }
    
}
