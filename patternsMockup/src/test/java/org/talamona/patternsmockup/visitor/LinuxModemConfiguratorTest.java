/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.visitor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luigi
 */
public class LinuxModemConfiguratorTest {

    private LinuxModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private LuigiModem l;

    public LinuxModemConfiguratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        v = new LinuxModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        l = new LuigiModem();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of visit method, of class LinuxModemVisitor.
     */
    @Test
    public void testVisitHayesModem() {
        System.out.println("visit HayesModem for Linux");
        h.accept(v);
        String configValue = h.getConfigurationValue();
        assertEquals(configValue, "&s1=4&D=3");
    }

    /**
     * Test of visit method, of class LinuxModemVisitor.
     */
    @Test
    public void testVisitZoomModem() {
        System.out.println("visit ZoomModem for Linux");
        z.accept(v);
        int configValue = z.getConfigurationValue();
        assertEquals(configValue, 42);
    }

    /**
     * Test of visit method, of class LinuxModemVisitor.
     */
    @Test
    public void testVisitLuigiModem() {
        System.out.println("visit LuigiModem for Linux");
        l.accept(v);
        String configValue = l.getConfigurationValue();
        assertEquals(configValue, "No configuration");
    }
}
