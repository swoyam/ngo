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
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author swshrestha
 */
public class Answers {

    String answer;
    int questionId;
    int officeId;
    String answerId;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public TreeMap<Integer, Answers> getQuestionIdWithAnswersForOfficeId(int officeId) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        TreeMap<Integer, Answers> answersMap = new TreeMap<Integer, Answers>();

        try {
            connection = new SqliteJDBC().getSqliteConnection();
            connection.setAutoCommit(false);

            String sql = "SELECT * FROM Answers where organization_office_id=?;";
            connection.prepareStatement(sql);
            stmt.setInt(1, officeId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Answers answer = new Answers();
                answer.setAnswer(rs.getString("answer"));
                answer.setQuestionId(rs.getInt("questions_q_id"));
                answer.setOfficeId(Integer.parseInt(rs.getString("organization_office_id")));
                answersMap.put(answer.getQuestionId(), answer);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return new TreeMap<Integer, Answers>();
        } finally {
            try {
                rs.close();
                stmt.close();
                connection.commit();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                return new TreeMap<Integer, Answers>();

            }
        }
        return answersMap;
    }

    public boolean insertAnswerForOfficeId(int officeId, TreeMap<Integer, JEditorPane> answers) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        PreparedStatement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            c.setAutoCommit(false);
            for (Integer qId : answers.keySet()) {

                String answer = answers.get(qId).getText();
                String sql = "Insert into answers ('answer','questions_q_id','organization_office_id') values " + "(?,?,?)";

                stmt = c.prepareStatement(sql);
                stmt.setString(1, answer);
                stmt.setInt(2, qId);
                stmt.setInt(3, officeId);

                stmt.executeUpdate();
            }

            stmt.close();
            c.commit();
            c.setAutoCommit(true);
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        System.out.println("Records inserted successfully");
        return true;
    }

    public boolean updateAnswerForOfficeId(int officeId, TreeMap<Integer, JEditorPane> answers) {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();
        PreparedStatement stmt = null;

        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            c.setAutoCommit(false);
            for (Integer qId : answers.keySet()) {

                String answer = answers.get(qId).getText();
                String sql = "UPDATE answers SET answer=? where questions_q_id=? and organization_office_id=?";

                stmt = c.prepareStatement(sql);

                stmt.setString(1, answer);
                stmt.setInt(2, qId);
                stmt.setInt(2, officeId);

                stmt.executeUpdate();
            }

            stmt.close();
            c.commit();
            c.setAutoCommit(true);
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        System.out.println("Record Updated successfully");
        return true;
    }

}
