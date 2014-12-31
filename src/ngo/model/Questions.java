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
import javax.swing.JEditorPane;
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author memoshakya
 */
public class Questions {
    public static void main(String[] args) {
        getAnswer(1);
    }

    public TreeMap<Integer, TreeMap<Integer, String>> getCategoryWiseQuestions() {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        TreeMap<Integer, TreeMap<Integer, String>> result = new TreeMap<>();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT qc.q_category_id, q.q_id, q.question FROM questions q LEFT JOIN question_category qc ON qc.q_category_id = q.question_category_q_category_id;");
            while (rs.next()) {

                Integer questionId = rs.getInt("q_id");
                String question = rs.getString("question");
                Integer questionCategory = rs.getInt("q_category_id");

                if (!result.containsKey(questionCategory)) {
                    result.put(questionCategory, new TreeMap<Integer, String>());
                }

                result.get(questionCategory).put(questionId, question);
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

    public String getCategoryById(Integer categoryId) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        String result = "";
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT qc.q_category_desc FROM question_category qc where qc.q_category_id = '" + categoryId + "'");
            while (rs.next()) {
                result = rs.getString("q_category_desc");
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

    //ToDo get organisation id from form. 
    public boolean insertAnswer(TreeMap<Integer, JEditorPane> answers) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            c.setAutoCommit(false);
            for (Integer qId : answers.keySet()) {
                stmt = c.createStatement();
                String answer = answers.get(qId).getText();
                stmt.executeUpdate("Insert into answers ('answer','questions_q_id','organization_office_id') values " + "('" + answer + "', " + qId + ", " + 1 + ")");
            }

            stmt.close();
            c.commit();
            c.setAutoCommit(true);
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        System.out.println("Record inserted successfully");
        return true;
    }
    
    //ToDo get organisation id from form. 
    public boolean updateAnswer(TreeMap<Integer, JEditorPane> answers) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            c.setAutoCommit(false);
            for (Integer qId : answers.keySet()) {
                stmt = c.createStatement();
                String answer = answers.get(qId).getText();
                stmt.executeUpdate("update answers set 'answer' = '"+ answer+"'" +"where question_q_id="+qId+" and organization_office_id=1");
            }

            stmt.close();
            c.commit();
            c.setAutoCommit(true);
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        System.out.println("Record inserted successfully");
        return true;
    }

    public static TreeMap<Integer, String> getAnswer(Integer organizationId) {
        TreeMap<Integer, String> result = new TreeMap<>();

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt=c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT answer,questions_q_id FROM answers where organization_office_id= " + organizationId);
            while (rs.next()) {

                Integer questionId = rs.getInt("questions_q_id");
                String answer = rs.getString("answer");
                result.put(questionId, answer);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println(result);
        return result;
    }


}
