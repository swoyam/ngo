/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ngo.dbConnect.SqliteJDBC;
import ngo.utils.Message;

/**
 *
 * @author swshrestha
 */
public class Organization {

    private int officeId;
    private String officeName;
    private String address;
    private String website;
    private String email;
    private String telephoneNo;
    private String mobileNo;
    private String chairPerson;
    private String headOfOrg;
    private String sectorId;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getChairPerson() {
        return chairPerson;
    }

    public void setChairPerson(String chairPerson) {
        this.chairPerson = chairPerson;
    }

    public String getHeadOfOrg() {
        return headOfOrg;
    }

    public void setHeadOfOrg(String headOfOrg) {
        this.headOfOrg = headOfOrg;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    /**
     *
     * @return Message object where object.status -> status (true/false) for
     * query execution and object.message -> auto generated key for inserted row
     */
    public Message insertIntoOrganization() {
        
        Connection c = null;
        PreparedStatement stmt = null;
        int officeId = 0;

        try {
            c = new SqliteJDBC().getSqliteConnection();
            c.setAutoCommit(false);

            String sql = "INSERT INTO organization('office_name', 'address', 'website', 'email', 'telephone_no', 'mobile_number', 'chair_person', 'head_of_org', 'sector_sector_id') "
                    + "         VALUES (?,?,?,?,?,?,?,?,?);";
            System.out.println("sql = " + sql);
            stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, officeName);
            stmt.setString(2, address);
            stmt.setString(3, website);
            stmt.setString(4, email);
            stmt.setString(5, telephoneNo);
            stmt.setString(6, mobileNo);
            stmt.setString(7, chairPerson);
            stmt.setString(8, headOfOrg);
            stmt.setString(9, sectorId);
            
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            officeId = keys.getInt(1);

            stmt.close();
            c.commit();
            c.close();
            

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return new Message(false, String.valueOf(officeId));
        }
        
        return new Message(true, String.valueOf(officeId));
    }

    public boolean updateOrganization() {
        PreparedStatement stmt = null;
        int office_id = getOfficeId();
        try {
            Connection c = new SqliteJDBC().getSqliteConnection();
            c.setAutoCommit(false);

            String sql = "update organization set "
                    + "office_name=?, "
                    + "address=?, "
                    + "website=?, "
                    + "email=?, "
                    + "telephone_no=?, "
                    + "mobile_number=?, "
                    + "chair_person=?, "
                    + "head_of_org=?, "
                    + "sector_sector_id=? where office_id=?";
            
            stmt = c.prepareStatement(sql);
            stmt.setString(1, officeName);
            stmt.setString(2, address);
            stmt.setString(3, website);
            stmt.setString(4, email);
            stmt.setString(5, telephoneNo);
            stmt.setString(6, mobileNo);
            stmt.setString(7, chairPerson);
            stmt.setString(8, headOfOrg);
            stmt.setString(9, sectorId);
            stmt.setInt(10, office_id);
            
            stmt.executeUpdate();

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        
        return true;
    }

    public static Message deleteOrganization(int officeId) {
        Message returnMessage;
        Connection c = null;
        Statement stmt = null;
        try {
            c = new SqliteJDBC().getSqliteConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "DELETE from answers where organization_office_id='" + officeId + "';";
            stmt.executeUpdate(sql);

            sql = "DELETE from Organization where office_id='" + officeId + "';";
            stmt.executeUpdate(sql);

            returnMessage = new Message(true, "Organization Deleted Successfully.");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            returnMessage = new Message(false, "Could not delete the organization");

        } finally {
            try {
                stmt.close();
                c.commit();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Organization.class.getName()).log(Level.SEVERE, null, ex);
                returnMessage = new Message(false, "Oops! something wrong with database while closing.");

            }

        }

        return returnMessage;
    }

}
