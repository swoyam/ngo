/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public TreeMap<Integer, TreeMap<Integer, String>> getCategoryWiseQuestions() {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        TreeMap<Integer, TreeMap<Integer, String>> result = new TreeMap<Integer, TreeMap<Integer, String>>();

        PreparedStatement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            String sql = "SELECT * FROM questions;";
            stmt = c.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Integer questionId = rs.getInt("q_id");
                String question = rs.getString("question");
                Integer questionCategory = rs.getInt("question_category_q_category_id");

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
        System.out.println("Questions Fetched Successfully");
        return result;
    }

    public String getCategoryById(Integer categoryId) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        String result = "";
        PreparedStatement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            String sql = "SELECT qc.q_category_desc FROM question_category qc where qc.q_category_id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
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

    
    public TreeMap<Integer, String> getAnswerForOfficeId(Integer organizationId) {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();
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
