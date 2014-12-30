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
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author memoshakya
 */
public class Questions {
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

            ResultSet rs = stmt.executeQuery("SELECT qc.q_category_desc FROM question_category qc where qc.q_category_id = '"+categoryId+"'");  
            while (rs.next()) {
                result= rs.getString("q_category_desc");
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

    
}
