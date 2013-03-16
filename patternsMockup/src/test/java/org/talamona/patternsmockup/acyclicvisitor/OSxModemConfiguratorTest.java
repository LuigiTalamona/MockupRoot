/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.acyclicvisitor;

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
public class OSxModemConfiguratorTest {

    private OSxModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private LuigiModem l;

    public OSxModemConfiguratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        v = new OSxModemConfigurator();
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
        System.out.println("visit HayesModem for OSx Lion - acyclic mode");
        h.accept(v);
        String configValue = h.getConfigurationValue();
        assertEquals(configValue, "&s1=8&D=3&M=1 - acyclic");
    }

    /**
     * Test of visit method, of class LinuxModemVisitor.
     */
    @Test
    public void testVisitZoomModem() {
        System.out.println("visit ZoomModem for OSx Lion - acyclic mode");
        z.accept(v);
        int configValue = z.getConfigurationValue();
        assertEquals(configValue, 62);
    }

    /**
     * Test of visit method, of class LinuxModemVisitor.
     */
    @Test
    public void testVisitLuigiModem() {
        System.out.println("visit LuigiModem for OSx Lion - acyclic mode");
        l.accept(v);
        String configValue = l.getConfigurationValue();
        assertEquals(configValue, "configuration for OSx Lion - acyclic");
    }
}
