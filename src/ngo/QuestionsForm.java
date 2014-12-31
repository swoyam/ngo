/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import ngo.utils.GeneralUtils;
import java.util.TreeMap;
import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import ngo.model.Questions;

/**
 *
 * @author swshrestha
 */
public class QuestionsForm extends javax.swing.JFrame {

    public QuestionsForm() {
        this(1);
    }

    /**
     * Creates new form QuestionsTest
     */
    public QuestionsForm(int officeId) {
        questionIdAnswersMap = new Questions().getAnswerForOfficeId(officeId);

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        GeneralUtils.setUILookAndFeel(this);
    }

    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        editorPaneMap = new TreeMap<Integer, JEditorPane>();
        submitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        closeMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Additional Questions");

        title.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        title.setForeground(new java.awt.Color(16, 59, 16));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("NGO Federation of Nepal  Kaski");
        title.setBorder(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Additional Questions"));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        //code to add dynamic labels
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel1Layout.setAutoCreateGaps(true);

        jPanel1.setLayout(jPanel1Layout);

        GroupLayout.ParallelGroup horizontalGroupForJPanel = jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false);
        GroupLayout.SequentialGroup verticalGroupForJPanel = jPanel1Layout.createSequentialGroup();

        TreeMap<Integer, TreeMap<Integer, String>> questions = new Questions().getCategoryWiseQuestions();

        for (Integer categoryId : questions.keySet()) {
            TreeMap<Integer, String> questionMap = questions.get(categoryId);
            JLabel[] labelArray = new JLabel[questionMap.size()];
            //  JEditorPane[] editorPaneArray = new JEditorPane[questionMap.size()];
            JSeparator[] seperatorArray = new JSeparator[questionMap.size()];
            JScrollPane[] scrollPaneArray = new JScrollPane[questionMap.size()];

            populateArrays(labelArray, questionMap, editorPaneMap, seperatorArray, scrollPaneArray, questionIdAnswersMap);
            //setViewPortForScrollPane(scrollPaneArray, editorPaneMap, questionMap);

            JLabel categoryLabel = new JLabel();
            categoryLabel.setText("<html><i><strong>" + new Questions().getCategoryById(categoryId) + "</strong></i></html>");

            populateGroups(categoryLabel, horizontalGroupForJPanel, labelArray, scrollPaneArray, seperatorArray);
            populateGroupsVertical(categoryLabel, verticalGroupForJPanel, labelArray, scrollPaneArray, seperatorArray);

        }

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(resetButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(submitButton))
                                .addGroup(horizontalGroupForJPanel)).addContainerGap(28, Short.MAX_VALUE)
                )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verticalGroupForJPanel
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(submitButton)
                                .addComponent(resetButton))
                        .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        closeMenu.setText("Close");
        closeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuActionPerformed(evt);
            }
        });
        jMenu1.add(closeMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void closeMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {

        boolean insert = questionIdAnswersMap.size() <= 0;
        if (insert) {
            new Questions().insertAnswer(editorPaneMap);
            JOptionPane.showMessageDialog(null, "Record inserted sucessfully");
        } else {
            new Questions().insertAnswer(editorPaneMap);
            JOptionPane.showMessageDialog(null, "Record updated sucessfully");
        }
    }

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int key : editorPaneMap.keySet()) {
            editorPaneMap.get(key).setText(null);
        }

    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        saveMenuActionPerformed(evt);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem closeMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    TreeMap<Integer, JEditorPane> editorPaneMap;
    TreeMap<Integer, String> questionIdAnswersMap;

    // End of variables declaration      
    private void populateArrays(JLabel[] labelArray, TreeMap<Integer, String> questionWithIdMap, TreeMap<Integer, JEditorPane> editorPaneWithQuestionIdMap, JSeparator[] seperatorArray, JScrollPane[] scrollPaneArray, TreeMap<Integer, String> answers) {

        int j = 0;

        for (Integer questionId : questionWithIdMap.keySet()) {

            JEditorPane editorPane1 = new JEditorPane();
            editorPane1.setText(answers.containsKey(questionId) ? answers.get(questionId) : null);

            labelArray[j] = new JLabel(getHtmlQuotes(questionWithIdMap.get(questionId)));
            editorPaneWithQuestionIdMap.put(questionId, editorPane1);
            seperatorArray[j] = new JSeparator(0);
            scrollPaneArray[j] = new JScrollPane();

            scrollPaneArray[j].setViewportView(editorPaneWithQuestionIdMap.get(questionId)); // todo do this to replace function setViewPortForScrollPane

            j++;
        }

    }

    private String getHtmlQuotes(String inputText) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>").append(inputText).append("</html>");
        return sb.toString();
    }

    private void populateGroups(JLabel categoryLabel, GroupLayout.ParallelGroup group, JLabel[] labelArray, JScrollPane[] scrollPaneArray, JSeparator[] seperatorArray) {
        for (int i = 0; i < labelArray.length; i++) {
            group.addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
            group.addComponent(labelArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
            group.addComponent(scrollPaneArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
            group.addComponent(seperatorArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
        }

    }

    private void populateGroupsVertical(JLabel categoryLabel, GroupLayout.SequentialGroup group, JLabel[] labelArray, JScrollPane[] scrollPaneArray, JSeparator[] seperatorArray) {
        group.addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);

        for (int i = 0; i < labelArray.length; i++) {
            group.addComponent(labelArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            group.addComponent(scrollPaneArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            group.addComponent(seperatorArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        }

    }

}
