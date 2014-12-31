/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ngo.license.LicenseValidator;
import ngo.utils.Message;
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author swoyambhu
 */
public class Users {

    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String LICENSE_KEY = "license_key";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String LICENSE_TYPE = "license_type";

    private String userId;
    private String userName;
    private String licenseKey;
    private long startDate;
    private long endDate;
    private LicenseValidator.ValidityPeriod licenseType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public LicenseValidator.ValidityPeriod getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseValidator.ValidityPeriod licenseType) {
        this.licenseType = licenseType;
    }

    public Message insertLicense() {
        Statement stmt = null;
        String insertValues = getInsertValues();
        try {
            Connection c = new SqliteJDBC().getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "INSERT INTO Users('" + USERNAME + "', '" + LICENSE_KEY + "', '" + START_DATE + "', '" + END_DATE + "', '" + LICENSE_TYPE + "') VALUES (" + insertValues + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return new Message(false, "Cannot insert into db");
        }
        System.out.println("Record:" + insertValues  + " inserted successfully");
        return new Message(true, "License Added Successfully");
    }

    private String getInsertValues() {
        StringBuilder builder = new StringBuilder();
        builder.append("'").append(this.userName).append("', ");
        builder.append("'").append(this.licenseKey).append("', ");
        builder.append("'").append(this.startDate).append("', ");
        builder.append("'").append(this.endDate).append("', ");
        builder.append("'").append(this.licenseType).append("'");
        return builder.toString();
    }

    public ArrayList<Users> getLicenseInfo() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        ArrayList<Users> usersList = new ArrayList<Users>();
        try {
            connection = new SqliteJDBC().getSqliteConnection();
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            String sql = "SELECT * FROM Users ORDER BY end_date DESC;";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Users userInfo = new Users();
                userInfo.setUserId(rs.getString(USER_ID));
                userInfo.setUserName(rs.getString(USERNAME));
                userInfo.setLicenseKey(rs.getString(LICENSE_KEY));
                userInfo.setStartDate(rs.getLong(START_DATE));
                userInfo.setEndDate(rs.getLong(END_DATE));
                userInfo.setLicenseType(LicenseValidator.ValidityPeriod.valueOf(rs.getString(LICENSE_TYPE)));
                usersList.add(userInfo);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return new ArrayList<>();
        } finally {
            try {
                rs.close();
                stmt.close();
                connection.commit();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<>();

            }
        }
        return usersList;
    }
}
