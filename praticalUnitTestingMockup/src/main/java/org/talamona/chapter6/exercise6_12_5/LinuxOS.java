/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter6.exercise6_12_5;

/**
 *
 * @author luigi
 */
public class LinuxOS implements OperatingSystem{

    @Override
    public int getNumberOfBits() {
        return 128;
    }

    @Override
    public void setNumberOfBits(int bits) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return "Linux";
    }

    @Override
    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getVersion() {
        return "ubuntu 12.04 LTS";
    }

    @Override
    public void setVersion(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getReleaseYear() {
        return 2012;
    }

    @Override
    public void setReleaseYear(int bits) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
