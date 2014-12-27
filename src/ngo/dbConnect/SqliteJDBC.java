/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swoyambhu
 */
public class SqliteJDBC {

    public static void main(String[] args) {
//        initiateApplicationDatabase();
//        insertTest();
//        selectTest();
        insertIntoSector();
    }

    public static Connection getSqliteConnection() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/ngo.db");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SqliteJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return conn;
    }

    public static void initiateApplicationDatabase() {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            stmt = c.createStatement();
            //users table
            String sql = "CREATE TABLE IF NOT EXISTS \"Users\" (\n"
                    + "    \"user_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"username\" varchar(255) NOT NULL,\n"
                    + "    \"password\" varchar(255) NOT NULL,\n"
                    + "    \"created_date\" datetime\n"
                    + ")";
            stmt.executeUpdate(sql);

            //answers
            sql = "CREATE TABLE IF NOT EXISTS \"answers\" (\n"
                    + "    \"ans_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"answer\" text,\n"
                    + "    \"questions_q_id\" integer NOT NULL,\n"
                    + "    \"organization_office_id\" integer NOT NULL,\n"
                    + "    FOREIGN KEY (\"questions_q_id\") REFERENCES \"questions\" (\"q_id\"),\n"
                    + "    FOREIGN KEY (\"organization_office_id\") REFERENCES \"organization\" (\"office_id\")\n"
                    + ")";
            stmt.executeUpdate(sql);

            //organization
            sql = "CREATE TABLE IF NOT EXISTS \"organization\" (\n"
                    + "    \"office_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"office_name\" text NOT NULL,\n"
                    + "    \"address\" text,\n"
                    + "    \"website\" varchar(200),\n"
                    + "    \"email\" varchar(200),\n"
                    + "    \"telephone_no\" varchar(50) NOT NULL,\n"
                    + "    \"mobile_number\" varchar(50),\n"
                    + "    \"chair_person\" varchar(255) NOT NULL,\n"
                    + "    \"head_of_org\" varchar(255) NOT NULL,\n"
                    + "    \"sector_sector_id\" integer NOT NULL,\n"
                    + "    FOREIGN KEY (\"sector_sector_id\") REFERENCES \"sector\" (\"sector_id\")\n"
                    + ")";
            stmt.executeUpdate(sql);

            //question
            sql = "CREATE TABLE IF NOT EXISTS \"questions\" (\n"
                    + "    \"q_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"question\" text NOT NULL\n"
                    + ")";
            stmt.executeUpdate(sql);

            //question
            sql = "CREATE TABLE IF NOT EXISTS \"sector\" (\n"
                    + "    \"sector_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"sector_name\" varchar(400) NOT NULL,\n"
                    + "    \"sector_desc\" text\n"
                    + ")";
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqliteJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("Tables created successfully");
    }

    public static boolean insertTest() {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "INSERT INTO sector('sector_name', 'sector_desc') VALUES ('Health', 'Health' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return true;
    }

    public static boolean insertTest(String sql) {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            //String sql = "INSERT INTO sector('sector_name', 'sector_desc') VALUES ('Health', 'Health' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return true;
    }

    public static boolean selectTest() {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM sector;");
            while (rs.next()) {
                int id = rs.getInt("sector_id");
                String name = rs.getString("sector_name");
                String desc = rs.getString("sector_desc");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("DESC = " + desc);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation completed successfully");
        return true;
    }

    public static boolean insertIntoSector() {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String[] sectors = {"Agriculture", "Health", "Education", "Livelihoods", "Children", "Women and Development/Empowerment", "Human Rights", "Capacity Development", "Water Sanitation", "Religious", "Youth Clubs", "Mother Groups", "Other"};

            for (int i = 0; i < sectors.length; i++) {
                String sector = sectors[i];

                String sql = "INSERT INTO sector('sector_name', 'sector_desc') VALUES ('" + sector + "', '" + sector + "' );";
                stmt.executeUpdate(sql);

            }

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return true;
    }

    public boolean insertIntoOrganization(LinkedList<String> values) {
        Statement stmt = null;
        String insertValue = getInsertString(values);
        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "INSERT INTO organization('office_name', 'address', 'website', 'email', 'telephone_no', 'mobile_number', 'chair_person', 'head_of_org', 'sector_sector_id') VALUES (" + insertValue + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        System.out.println("Record:"+insertValue+" inserted successfully");
        return true;
    }

    public static String getInsertString(LinkedList<String> values) {

        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append("'").append(value).append("', ");
        }
        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }

}
