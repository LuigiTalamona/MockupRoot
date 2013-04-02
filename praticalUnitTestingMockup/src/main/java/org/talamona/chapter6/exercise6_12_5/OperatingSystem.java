package org.talamona.chapter6.exercise6_12_5;

/**
 *
 * @author luigi
 */
public interface OperatingSystem {
    
    public int getNumberOfBits();
    public void setNumberOfBits(int bits);
    
    public String getName();
    public void setName(String string);
    
    public String getVersion();
    public void setVersion(String string);
    
    public int getReleaseYear();
    public void setReleaseYear(int bits);
}
