/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.model;

import java.awt.Window;
import java.util.ArrayList;
import ngo.LicenseValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author swoyambhu
 */
public class UsersTest {
    
    public UsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserId method, of class Users.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class Users.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        Users instance = new Users();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class Users.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Users.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        Users instance = new Users();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLicenseKey method, of class Users.
     */
    @Test
    public void testGetLicenseKey() {
        System.out.println("getLicenseKey");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getLicenseKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLicenseKey method, of class Users.
     */
    @Test
    public void testSetLicenseKey() {
        System.out.println("setLicenseKey");
        String licenseKey = "";
        Users instance = new Users();
        instance.setLicenseKey(licenseKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Users.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Users instance = new Users();
        long expResult = 0L;
        long result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Users.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        long startDate = 0L;
        Users instance = new Users();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class Users.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Users instance = new Users();
        long expResult = 0L;
        long result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class Users.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        long endDate = 0L;
        Users instance = new Users();
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLicenseType method, of class Users.
     */
    @Test
    public void testGetLicenseType() {
        System.out.println("getLicenseType");
        Users instance = new Users();
        LicenseValidator.ValidityPeriod expResult = null;
        LicenseValidator.ValidityPeriod result = instance.getLicenseType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLicenseType method, of class Users.
     */
    @Test
    public void testSetLicenseType() {
        System.out.println("setLicenseType");
        LicenseValidator.ValidityPeriod licenseType = null;
        Users instance = new Users();
        instance.setLicenseType(licenseType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLicenseInfo method, of class Users.
     */
    //@Test
    public void testGetLicenseInfo() {
        System.out.println("getLicenseInfo");
        Users instance = new Users();
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = instance.getLicenseInfo();
        System.out.println("result = " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
