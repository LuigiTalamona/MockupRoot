package org.talamona.chapter6.exercise6_12_5;

import static org.talamona.chapter6.exercise6_12_5.OperatingSystemAssert.assertThat;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class CustomMatcherTestNG {
    private OperatingSystem instance;
    
    
    
    public CustomMatcherTestNG() {
    }

    @BeforeMethod
    public void setup(){
        this.instance = new LinuxOS();
    }
    
    @Test
    public void ShouldBeUseCustomMatcherToTestLinuxOS(){
       assertThat(instance).hasName("Linux").has128bits().hasVersion("ubuntu 12.04 LTS").wasReleasedIn(2012);

    }

}