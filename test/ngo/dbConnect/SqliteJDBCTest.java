/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.dbConnect;

import java.sql.Connection;
import java.util.Collection;
import java.util.LinkedHashMap;
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
public class SqliteJDBCTest {
    
    public SqliteJDBCTest() {
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
     * Test of main method, of class SqliteJDBC.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SqliteJDBC.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSqliteConnection method, of class SqliteJDBC.
     */
    @Test
    public void testGetSqliteConnection() {
        System.out.println("getSqliteConnection");
        SqliteJDBC instance = new SqliteJDBC();
        Connection expResult = null;
        Connection result = instance.getSqliteConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initiateApplicationDatabase method, of class SqliteJDBC.
     */
    @Test
    public void testInitiateApplicationDatabase() {
        System.out.println("initiateApplicationDatabase");
        SqliteJDBC instance = new SqliteJDBC();
        instance.initiateApplicationDatabase();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertTest method, of class SqliteJDBC.
     */
    @Test
    public void testInsertTest_0args() {
        System.out.println("insertTest");
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertTest method, of class SqliteJDBC.
     */
    @Test
    public void testInsertTest_String() {
        System.out.println("insertTest");
        String sql = "";
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertTest(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectTest method, of class SqliteJDBC.
     */
    @Test
    public void testSelectTest() {
        System.out.println("selectTest");
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.selectTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoSector method, of class SqliteJDBC.
     */
    @Test
    public void testInsertIntoSector() {
        System.out.println("insertIntoSector");
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertIntoSector();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoOrganization method, of class SqliteJDBC.
     */
    @Test
    public void testInsertIntoOrganization() {
        System.out.println("insertIntoOrganization");
        LinkedHashMap<String, Object> values = null;
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertIntoOrganization(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrganization method, of class SqliteJDBC.
     */
    @Test
    public void testUpdateOrganization() {
        System.out.println("updateOrganization");
        LinkedHashMap<String, Object> values = null;
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.updateOrganization(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoQuestionCategory method, of class SqliteJDBC.
     */
    @Test
    public void testInsertIntoQuestionCategory() {
        System.out.println("insertIntoQuestionCategory");
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertIntoQuestionCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoQuestions method, of class SqliteJDBC.
     */
    @Test
    public void testInsertIntoQuestions() {
        System.out.println("insertIntoQuestions");
        SqliteJDBC instance = new SqliteJDBC();
        boolean expResult = false;
        boolean result = instance.insertIntoQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsertString method, of class SqliteJDBC.
     */
    @Test
    public void testGetInsertString() {
        System.out.println("getInsertString");
        Collection<Object> values = null;
        String expResult = "";
        String result = SqliteJDBC.getInsertString(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUpdateString method, of class SqliteJDBC.
     */
    @Test
    public void testGetUpdateString() {
        System.out.println("getUpdateString");
        LinkedHashMap<String, Object> values = null;
        String expResult = "";
        String result = SqliteJDBC.getUpdateString(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
