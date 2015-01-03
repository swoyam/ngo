/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ngo.utils.Message;

/**
 *
 * @author swoyambhu
 */
public class SqliteJDBC {

    public Connection getSqliteConnection() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/ngo.db");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger(SqliteJDBC.class.getName()).log(Level.SEVERE, null, e);
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(SqliteJDBC.class.getName()).log(Level.SEVERE, null, e);
            System.exit(0);
        }

        System.out.println("Opened database successfully");
        return conn;
    }

    public Message initiateApplicationDatabase() {
        Statement stmt = null;
        try {
            Connection c = getSqliteConnection();
            stmt = c.createStatement();
            //users table
            String sql = "CREATE TABLE IF NOT EXISTS \"Users\" (\n"
                    + "    \"user_id\" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"username\" varchar(255) NOT NULL,\n"
                    + "    \"license_key\" varchar(255) NOT NULL,\n"
                    + "    \"start_date\" datetime NOT NULL,\n"
                    + "    \"end_date\" datetime NOT NULL,\n"
                    + "    \"license_type\" varchar(200) NOT NULL\n"
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

            //question category
            sql = "CREATE TABLE IF NOT EXISTS \"question_category\" (\n"
                    + "    \"q_category_id\" integer NOT NULL  PRIMARY KEY,\n"
                    + "    \"q_category_desc\" varchar(200) NOT NULL\n"
                    + ");";
            stmt.executeUpdate(sql);

            //question
            sql = " CREATE TABLE IF NOT EXISTS \"questions\" (\n"
                    + "    \"q_id\" integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                    + "    \"question\" text NOT NULL\n"
                    + "            ,\n"
                    + "    \"question_category_q_category_id\" integer NOT NULL\n"
                    + "            ,\n"
                    + "    FOREIGN KEY (\"question_category_q_category_id\") REFERENCES \"question_category\" (\"q_category_id\")\n"
                    + ");";
            stmt.executeUpdate(sql);

            //sector
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

        if (getCount("sector", "sector_id") == 0) {
            if (!insertIntoSector()) {
                return new Message(true, "Sectors cannot be initiated");
            }
        }

        if (getCount("question_category", "q_category_id") == 0) {
            if (!insertIntoQuestionCategory()) {
                return new Message(true, "Question Category cannot be initiated");
            }
        }
        if (getCount("questions", "q_id") == 0) {
            if (!insertIntoQuestions()) {
                return new Message(true, "Questions cannot be initiated");
            }
        }

        return new Message(true, "Database Created. Tables Created. Sectors Initiated");

    }

    public int getCount(String table, String id) {
        PreparedStatement stmt = null;
        int count = 0;

        try {
            Connection c = getSqliteConnection();
            String sql = "SELECT " + id + " FROM " + table;
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                count++;
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation completed successfully");
        return count;
    }

    public boolean insertIntoSector() {
        PreparedStatement stmt = null;
        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            String[] sectors = {"Agriculture", "Health", "Education", "Livelihoods", "Children", "Women and Development/Empowerment", "Human Rights", "Capacity Development", "Water Sanitation", "Religious", "Youth Clubs", "Mother Groups", "Other"};

            for (int i = 0; i < sectors.length; i++) {
                String sector = sectors[i];
                String sql = "INSERT INTO sector('sector_name', 'sector_desc') VALUES (?,?);";
                stmt.setString(1, sector);
                stmt.setString(2, sector);
                stmt = c.prepareStatement(sql);
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

    public boolean insertIntoQuestionCategory() {
        PreparedStatement stmt = null;

        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);
            String[] questionCategory = {"Registration and Legal Status", "Board Profile and Procedures", "General Organisational Information", "Management, Administration and Human Resources", "Challenges / Success story", "Publications", "Monitoring Mechanism"};
            for (int i = 0; i < questionCategory.length; i++) {
                String question = questionCategory[i];

                String sql = "INSERT INTO question_category('q_category_desc') VALUES ( ? );";
                stmt = c.prepareStatement(sql);
                stmt.setString(1, question);
                stmt.executeUpdate();
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        System.out.println("Record inserted successfully");
        return true;
    }

    public boolean insertIntoQuestions() {
        PreparedStatement stmt = null;

        try {
            Connection c = getSqliteConnection();
            c.setAutoCommit(false);

            TreeMap<Integer, List<String>> questionMap = new TreeMap<>();
            questionMap.put(1, Arrays.asList(new String[]{"Registration date in CDO office: ", "Registration  number: ", "Affiliated date with SWC: ", "Affiliation number: ", "Affiliation with others : (pls mention here)", "PAN Number/VAT number:", "Affiliated with NGO federation date and number: ", "Last AGM date : ", "Last election date of Governing Body: ", "Appreciation Letter from GO/others:  (Pls mention type of appreciation and date)"}));
            questionMap.put(2, Arrays.asList(new String[]{"List the Board members / their board position   role in the board and responsibilities / years of service in the board/ profession / qualifications/  experience / present employment or occupation ", "What is the Gender &  Social inclusive proportion of your Board ?", "Mention about  members  details / Members Profile:  ", "Do you have a CODE OF CONDUCT and a CONFLICT OF INTEREST POLICY for the Board?", "Do you have a Board Operation  Manual with Board Procedures?", "1) How often are Board meetings held? 2) Are they  minuted ? And 3) when was the last one held? ", "What is the Frequency with which 1)Board elections are held? 2) When was the last board election if held?", "What is the term/period for Chairperson? And ", "Can he/she be re elected continuously?", "Is there a General body and if so how many members? ", "Does the Director Board have sub-committees and if so what are they and what are their roles/functions?", "Do you have External Advisors to the board?(ie. giving Financial, legal or any other advise  etc.) If so who are they and what advise do you receive from them?"}));
            questionMap.put(3, Arrays.asList(new String[]{"What is the Vision , Mission , Goal & Objectives of the Organisation?", "Organizational Governance status", "NGO Profile Description ", "Does the Organisation have a Strategic Plan and a Business Plan and if so how many years do they cover", "Does the Organisation have Operating plans? (Annual/ Quarterly) and do they reflect the strategic plan?", "Does the Organisation have a written fundraising strategy / plan?", "Organization working areas, programs field & Target group ", "Annual Budget &  funding sources", "Does the Organisation produce Annual Reports and distributed?", "Does the Organisation carry out regular independent Audits (ie Annual Audits / special project audits) and social audit ?", "Is your Audit report filed with relevant authorities and shared with others and if so with whom ?", "What other information/reports do you currently file with authorities (ie Annual report, quarterly plans and budgets etc ) and are you up to date with it?", "Does the Organisation have any pending or threatened Litigation?", "List Organisational liabilities – ie Loans, guarantees, Overdrafts, outstanding Creditors etc", "What Sector/s is the organisation working in?", "What are the Current programmes/projects being implemented and those that have been planned? ", "List Beneficiaries / Target Groups –both current and planned through new projects", "List Partnerships and agreements you currently have", "List the Current sources of committed funding (funders) and amounts available for the next three years", "Does the Organisation have a reserve fund/savings?", "What Other core resources are available?  Ie.  Property, Infrastructure, Technological resources, other Assets and Are they Insured?", "Who is the external Auditor and internal auditor of your organization (Pls mention name & status)", "Who is your legal advisor / your Lawyers", "List the Bank Accounts of your organisation"}));
            questionMap.put(4, Arrays.asList(new String[]{"Do you have an Organisational structure with clearly defined lines of authority and responsibility?", "What Organisational and Management Policies do you have in place?", "Give a List of updated operational and procedures manuals that the organisation follows", "List members of the Management Team and describe their role", "Do you take into consideration the collective/ individual team members’ view before taking major organisational decisions/change?", "How and to what extent do you include beneficiaries in decisions about adoption and implementation of programmes? (Please explain)", "What decisions need approval by the Board", "Does the organization provide Management Reports? (ie. Financial/activity/progress/impact/donor reports etc ) What are they? and to whom are they given?", "Does the organisation maintain a Fixed Asset Register and take a physical count of assets annually? and are they insured?", "Human Resources Profile:  Pls mention HR profile.", "Who are the current Cheque Signatories and what their Limits are - And what delegated Authorities do you have in place. ", "How often and to what extent have you engaged/ arranged the following activities?  (Often / Occasionally / Never)", "Direct lobbying", "Grass-roots lobbying", "Financial support for political parties", "Do you hire Consultants", "List of staff members as of date  and their designation/ qualifications/ years of service in the organisation/ total number of years of experience ", "Give qualifications and  experience of organizational Head and list his/her current responsibilities in the organization", "Were there any Labour issues over the last two years"}));
            questionMap.put(5, Arrays.asList(new String[]{"Assess and state briefly any challenges you expect to face as a result of your internal organisational operating environment in implementing the projects using the following areas as guidance:\n"
                + "<br>Staffing (capacity/ Skills/ Turnover)</br> <br>Funding and fundraising skills</br><br>Infrastructure and Assets</br><br>Leadership</br><br>The Board</br><br>Systems and Procedures</br><br>Any other", "Assess and state briefly any challenges you expect to face as a result of your external operating environment in implementing the programmes using the following areas as guidance:</br><br>Implementing the model directly or through other partnerships</br>"
                + "<br>Political stability</br>"
                + "<br>Economic stability</br>"
                + "<br>Legal environment</br>"
                + "<br>Funding environment – locally and overseas</br>"
                + "<br>Government Policies and regulations</br>"
                + "<br>Attitudes towards NGOs and Outlook for NGOs in operating country</br>"
                + "<br>Any other</br>"}));
            questionMap.put(6, Arrays.asList(new String[]{"List of publications from your organisation"}));
            questionMap.put(7, Arrays.asList(new String[]{"From Donors: when? Donors visit report", "Government agencies", "Joint monitoring", "Other"}));

            for (Integer qId : questionMap.keySet()) {
                for (String question : questionMap.get(qId)) {
                    String sql = "INSERT INTO questions('question','question_category_q_category_id') VALUES (?,?)";
                    stmt = c.prepareStatement(sql);
                    stmt.setString(1, question);
                    stmt.setInt(2, qId);
                    System.out.println("sql" + sql);
                    stmt.executeUpdate();
                }
            }

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        System.out.println("Record inserted successfully");
        return true;
    }
}
