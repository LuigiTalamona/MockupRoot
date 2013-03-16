/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup;

import junit.framework.TestCase;

/**
 *
 * @author luigi
 */
public class ProfilesManagerTest extends TestCase {

    public ProfilesManagerTest(String testName) {
        super(testName);
    }

    /**
     * Test of isProfiled method, of class ProfilesManager.
     */
    public void testIsProfiled() {
        System.out.println("isProfiled");
        
        User profile = new User();
        profile.setId("Luigi Talamona");
        profile.setARSSid("talamona");
        profile.setARSSpwd("password");
        String user = "Luigi Talamona";
        ProfilesManager instance = new ProfilesManager();
        instance.writeProfile(profile);
        boolean expResult = true;
        boolean result = instance.isProfiled(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of readProfile method, of class ProfilesManager.
     */
    public void testReadProfile() {
        System.out.println("readProfile");
        User profile = new User();
        profile.setId("Luigi Talamona");
        profile.setARSSid("talamona");
        profile.setARSSpwd("password");
        String user = "Luigi Talamona";
        ProfilesManager instance = new ProfilesManager();
        instance.writeProfile(profile);
        
        User newProfile = instance.readProfile("Luigi Talamona");
        assertEquals(newProfile.getId(), profile.getId());
    }

    /**
     * Test of writeProfile method, of class ProfilesManager.
     */
    public void testWriteProfile() {
        System.out.println("writeProfile");
        User profile = new User();
        profile.setId("Luigi Talamona");
        profile.setARSSid("talamona");
        profile.setARSSpwd("password");
        ProfilesManager instance = new ProfilesManager();
        boolean expResult = true;
        boolean result = instance.writeProfile(profile);
        assertEquals(expResult, result);
    }
}
