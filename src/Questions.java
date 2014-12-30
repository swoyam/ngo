
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;
import ngo.dbConnect.SqliteJDBC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author memoshakya
 */
public class Questions {

    public TreeMap<String, TreeMap<Integer, String>> getCategoryWiseQuestions() {

        SqliteJDBC sqliteJDBC = new SqliteJDBC();

        TreeMap<String, TreeMap<Integer, String>> result = new TreeMap<>();
        Statement stmt = null;
        try {
            Connection c = sqliteJDBC.getSqliteConnection();
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT qc.question_category_desc, q.question_id, q.question FROM questions q LEFT JOIN question_category qc ON organization.sector_sector_id = sector.sector_id;");
            while (rs.next()) {

                Integer questionId = rs.getInt("question_id");
                String question = rs.getString("question");
                String questionCategory = rs.getString("question_category_desc");

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

}
