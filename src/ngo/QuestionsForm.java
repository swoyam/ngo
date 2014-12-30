/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

/**
 *
 * @author swshrestha
 */
public class QuestionsForm extends javax.swing.JFrame {

    /**
     * Creates new form QuestionsTest
     */
    public QuestionsForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        GeneralUtils.setUILookAndFeel(this);
    }

                    
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
       
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        closeMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Additional Questions");

        title.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        title.setForeground(new java.awt.Color(16, 59, 16));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("NGO Federation of Nepal  Kaski");
        title.setBorder(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Additional Questions"));
//        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane1.setHorizontalScrollBar(null);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        //code to add dynamic labels
        String[] questionArray = {
            "1. I have something to say, it's beter to burn out then to fade away. "
           ,
            "2. I have something to say, it's beter to burn out then to fade away. "
            + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            ,
            "3. I have something to say, it's beter to burn out then to fade away. "
          
                  + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."  + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            + " This is a very long String to see if you can wrap with in",
            "4. I have something to say, it's beter to burn out then to fade away. "
            + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            + " This is a very long String to see if you can wrap with in",
            "5. I have something to say, it's beter to burn out then to fade away. ", "1. I have something to say, it's beter to burn out then to fade away. "
           ,
            "2. I have something to say, it's beter to burn out then to fade away. "
            + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            ,
            "3. I have something to say, it's beter to burn out then to fade away. "
          
                  + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."  + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            + " This is a very long String to see if you can wrap with in",
            "4. I have something to say, it's beter to burn out then to fade away. "
            + "This is a very long String to see if you can wrap with in "
            + "the available spaceI have something to say, it's beter to burn out then to fade away."
            + " This is a very long String to see if you can wrap with in",
            "5. I have something to say, it's beter to burn out then to fade away. "
            };

        JLabel[] labelArray = new JLabel[questionArray.length];
        JEditorPane[] editorPaneArray = new JEditorPane[questionArray.length];
        JSeparator[] seperatorArray = new JSeparator[questionArray.length];
        JScrollPane[] scrollPaneArray = new JScrollPane[questionArray.length];

        populateArrays(labelArray, questionArray, editorPaneArray, seperatorArray, scrollPaneArray);

        setViewPortForScrollPane(scrollPaneArray, editorPaneArray);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel1Layout.setAutoCreateGaps(true);

        jPanel1.setLayout(jPanel1Layout);
        GroupLayout.ParallelGroup horizontalGroupForJPanel = jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false);
        GroupLayout.SequentialGroup verticalGroupForJPanel = jPanel1Layout.createSequentialGroup();
        populateGroups(horizontalGroupForJPanel, labelArray, scrollPaneArray, seperatorArray);
        populateGroupsVertical(verticalGroupForJPanel, labelArray, scrollPaneArray, seperatorArray);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                .addGroup(horizontalGroupForJPanel)).addContainerGap(28, Short.MAX_VALUE)
                )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verticalGroupForJPanel
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2))
                        .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    // End of variables declaration      

    private void populateArrays(JLabel[] labelArray, String[] questionArray, JEditorPane[] textAreaArray, JSeparator[] seperatorArray, JScrollPane[] scrollPaneArray) {

        for (int i = 0; i < questionArray.length; i++) {

            labelArray[i] = new JLabel(getHtmlQuotes(questionArray[i]));
            textAreaArray[i] = new JEditorPane();
            seperatorArray[i] = new JSeparator(0);
            scrollPaneArray[i] = new JScrollPane();
        }

    }

    private String getHtmlQuotes(String inputText) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>").append(inputText).append("</html>");
        return sb.toString();
    }

    private void populateGroups(GroupLayout.ParallelGroup group, JLabel[] labelArray, JScrollPane[] scrollPaneArray, JSeparator[] seperatorArray) {
        for (int i = 0; i < labelArray.length; i++) {

            group.addComponent(labelArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
            group.addComponent(scrollPaneArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
            group.addComponent(seperatorArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE);
//            group.addComponent(labelArray[i],  javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
//            group.addComponent(textAreaArray[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }

    }

    private void populateGroupsVertical(GroupLayout.SequentialGroup group, JLabel[] labelArray, JScrollPane[] scrollPaneArray, JSeparator[] seperatorArray) {

        for (int i = 0; i < labelArray.length; i++) {
            group.addComponent(labelArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            group.addComponent(scrollPaneArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            group.addComponent(seperatorArray[i], javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        }

    }

    private void setViewPortForScrollPane(JScrollPane[] scrollPaneArray, JEditorPane[] editorPaneArray) {
        for (int i = 0; i < editorPaneArray.length; i++) {
            scrollPaneArray[i].setViewportView(editorPaneArray[i]);

        }
    }

}
