/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.license;

import javax.swing.JOptionPane;
import ngo.utils.GeneralUtils;
import ngo.HomePage;
import ngo.utils.Message;
import ngo.utils.TextPrompt;

/**
 *
 * @author swoyambhu
 */
public class LicenseValidation extends javax.swing.JFrame {

    String message;

    public LicenseValidation() {
        this("");
    }

    /**
     * Creates new form LicenseValidation
     */
    public LicenseValidation(String message) {

        setLocationRelativeTo(null);
        this.message = message;
        setResizable(false);
        initComponents();
        GeneralUtils.setUILookAndFeel(this);

        licenseLabel.setText(this.message);
        new TextPrompt("User Name", userNameTextField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        licenseKeyLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        validateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        licenseKeyEditorPane = new javax.swing.JEditorPane();
        licenseLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("License Key Validation");

        jLabel1.setText("Please Enter License Key Below");

        userNameLabel.setText("User Name");

        licenseKeyLabel.setText("License Key");

        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        validateButton.setText("Validate");
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(licenseKeyEditorPane);

        licenseLabel.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        licenseLabel.setForeground(new java.awt.Color(239, 14, 2));
        licenseLabel.setText("License");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 244, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(licenseKeyLabel)
                                    .addComponent(userNameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(userNameTextField))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(licenseLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(licenseLabel)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(licenseKeyLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(validateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        String userName = userNameTextField.getText().trim();
        String licenseKey = licenseKeyEditorPane.getText().trim();
        Message message = new LicenseValidator().addLicenseKey(userName, licenseKey);
        if (message.getStatus()) {
            JOptionPane.showMessageDialog(this,
                    message.getMessage(),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            String messageForHomePage = message.getMessage().substring(0, message.getMessage().indexOf("\n"));
            HomePage page = new HomePage(messageForHomePage);
            page.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    message.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_validateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LicenseValidation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane licenseKeyEditorPane;
    private javax.swing.JLabel licenseKeyLabel;
    private javax.swing.JLabel licenseLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables

}
