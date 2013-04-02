package org.talamona.chapter6.exercise6_12_5;

import org.fest.assertions.*;
 
/**
 *
 * @author luigi
 */
public class OperatingSystemAssert extends GenericAssert<OperatingSystemAssert, OperatingSystem>{
    
    public OperatingSystemAssert(OperatingSystem actual){
        super(OperatingSystemAssert.class, actual);
    }
    public static OperatingSystemAssert assertThat(OperatingSystem actual){
        return new OperatingSystemAssert(actual);
    }
    public OperatingSystemAssert has128bits(){
        int expected = 128;
        String errorMessage = String.format("Expected bit for OS to be %s but is %s", expected, actual.getNumberOfBits());
        Assertions.assertThat(actual.getNumberOfBits()).overridingErrorMessage(errorMessage).isEqualTo(expected);
        return this;
    }
    public OperatingSystemAssert hasName(String name){
        String errorMessage = String.format("Expected name for OS to be %s but is %s", name, actual.getName());
        Assertions.assertThat(actual.getName()).overridingErrorMessage(errorMessage).isEqualTo(name);
        return this;
    }
    public OperatingSystemAssert wasReleasedIn(int year){
        String errorMessage = String.format("Expected year for OS to be %s but is %s", year, actual.getReleaseYear());
        Assertions.assertThat(actual.getReleaseYear()).overridingErrorMessage(errorMessage).isEqualTo(year);
        return this;
    }
    public OperatingSystemAssert hasVersion(String version){
        String errorMessage = String.format("Expected version for OS to be %s but is %s", version, actual.getVersion());
        Assertions.assertThat(actual.getVersion()).overridingErrorMessage(errorMessage).isEqualTo(version);
        return this;
    }
}
    

