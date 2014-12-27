/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;
import java.util.Vector;
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author swoyambhu
 */
public class Dashboard {

    public TreeMap getSectors() {


        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();

        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM sector;");
            while (rs.next()) {

                Integer id = rs.getInt("sector_id");
                String name = rs.getString("sector_name");

                result.put(id, name);

            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation completed successfully");
        return result;

    }

    public TreeMap<String, TreeMap<Integer, String>> getSectorWiseOrganizations() {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        TreeMap<String, TreeMap<Integer, String>> result = new TreeMap<String, TreeMap<Integer, String>>();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT sector.sector_name, organization.office_id, organization.office_name FROM sector LEFT JOIN organization ON organization.sector_sector_id = sector.sector_id;");
            while (rs.next()) {

                Integer officeId = rs.getInt("office_id");
                String officeName = rs.getString("office_name");
                String sectorName = rs.getString("sector_name");

                if (!result.containsKey(sectorName)) {
                    result.put(sectorName, new TreeMap<Integer, String>());
                }

                result.get(sectorName).put(officeId, officeName);
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation completed successfully");
        return result;
    }
    
    public Vector<String> getMatchingOrganizations(String queryWord) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        Vector<String> resultVector = new Vector<String>();
        
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT organization.office_id, organization.office_name FROM organization WHERE office_name LIKE '%"+queryWord+"%'");
            while (rs.next()) {

                Integer officeId = rs.getInt("office_id");
                String officeName = rs.getString("office_name");

                resultVector.add(officeName);
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation completed successfully");
        return resultVector;
    }
}
