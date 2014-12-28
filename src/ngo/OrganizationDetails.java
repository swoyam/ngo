/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import java.util.Map;
import ngo.model.Dashboard;

/**
 *
 * @author memoshakya
 */
public class OrganizationDetails extends javax.swing.JFrame {

    private Integer office_id;

    /**
     * Creates new form ViewOrganization
     */
    public OrganizationDetails() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("View Organization");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
       
        //sectorComboBox.setModel(getModelForSectorComboBox(new Dashboard().getSectors()));
    }
    
    public OrganizationDetails(int officeId) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("View Organization");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setValues(new Dashboard().getOrganization(officeId));
        
       
    }

    public void setValues(Map<String, Object> valueMap) {
        System.out.println(valueMap);
        this.orgNameTxtField.setText(valueMap.get("officeName").toString());
        this.orgNameTxtField.setEditable(false);
        this.addressTxtField.setText(valueMap.get("address").toString());
        this.addressTxtField.setEditable(false);
        this.websiteTextField.setText(valueMap.get("website").toString());
        this.websiteTextField.setEditable(false);
        this.emailTextField.setText(valueMap.get("email").toString());
        this.emailTextField.setEditable(false);
        this.telephoneTxtField.setText(valueMap.get("telephone_no").toString());
        this.telephoneTxtField.setEditable(false);
        this.mobileTxtField.setText(valueMap.get("mobile_number").toString());
        this.mobileTxtField.setEditable(false);
        this.chairPersonTxtField.setText(valueMap.get("chair_person").toString());
        this.chairPersonTxtField.setEditable(false);
        this.hodTxtField.setText(valueMap.get("head_of_org").toString());
        this.hodTxtField.setEditable(false);
        this.sectorTextField.setText(valueMap.get("sector_name").toString());
        this.sectorTextField.setEditable(false);
        
        this.office_id = Integer.parseInt(valueMap.get("office_id").toString());
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
        orgNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        websiteNameLabel = new javax.swing.JLabel();
        mobileNumberLabel = new javax.swing.JLabel();
        emailAddLabel = new javax.swing.JLabel();
        chairPersonLabel = new javax.swing.JLabel();
        hodLabel = new javax.swing.JLabel();
        orgNameTxtField = new javax.swing.JTextField();
        addressTxtField = new javax.swing.JTextField();
        telephoneTxtField = new javax.swing.JTextField();
        mobileTxtField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        websiteTextField = new javax.swing.JTextField();
        chairPersonTxtField = new javax.swing.JTextField();
        hodTxtField = new javax.swing.JTextField();
        telephoneNoLabel = new javax.swing.JLabel();
        sectorLabel = new javax.swing.JLabel();
        asterisk2 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        sectorTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        closeMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Organization Details"));

        orgNameLabel.setText("Organization's Name");

        addressLabel.setText("Address");
        addressLabel.setToolTipText("");

        websiteNameLabel.setText("Website");

        mobileNumberLabel.setText("Mobile Number");

        emailAddLabel.setText("Email Address");

        chairPersonLabel.setText("Chair Person");

        hodLabel.setText("Head of Organization");

        orgNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgNameTxtFieldActionPerformed(evt);
            }
        });

        telephoneNoLabel.setText("Telephone Number");

        sectorLabel.setText("Sector");

        asterisk2.setForeground(new java.awt.Color(246, 9, 9));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Update.setText("Edit");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orgNameLabel)
                            .addComponent(addressLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(telephoneNoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asterisk2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chairPersonLabel)
                            .addComponent(mobileNumberLabel)
                            .addComponent(emailAddLabel)
                            .addComponent(websiteNameLabel)
                            .addComponent(sectorLabel)
                            .addComponent(hodLabel))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                            .addComponent(mobileTxtField)
                            .addComponent(emailTextField)
                            .addComponent(websiteTextField)
                            .addComponent(chairPersonTxtField)
                            .addComponent(hodTxtField)
                            .addComponent(orgNameTxtField)
                            .addComponent(addressTxtField)
                            .addComponent(sectorTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orgNameLabel)
                    .addComponent(orgNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneNoLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileNumberLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(websiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(websiteNameLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chairPersonTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chairPersonLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hodTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hodLabel))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectorLabel)
                    .addComponent(sectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(asterisk2)
                .addGap(0, 8, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        AddOrganization addOrganization = new AddOrganization();
        addOrganization.setVisible(true);
        addOrganization.setValues(new Dashboard().getOrganization(this.office_id));
        this.dispose();
    }//GEN-LAST:event_UpdateActionPerformed

    private void closeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeMenuActionPerformed

    private void orgNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgNameTxtFieldActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrganizationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrganizationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrganizationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizationDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTxtField;
    private javax.swing.JLabel asterisk2;
    private javax.swing.JLabel chairPersonLabel;
    private javax.swing.JTextField chairPersonTxtField;
    private javax.swing.JMenuItem closeMenu;
    private javax.swing.JLabel emailAddLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel hodLabel;
    private javax.swing.JTextField hodTxtField;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mobileNumberLabel;
    private javax.swing.JTextField mobileTxtField;
    private javax.swing.JLabel orgNameLabel;
    private javax.swing.JTextField orgNameTxtField;
    private javax.swing.JLabel sectorLabel;
    private javax.swing.JTextField sectorTextField;
    private javax.swing.JLabel telephoneNoLabel;
    private javax.swing.JTextField telephoneTxtField;
    private javax.swing.JLabel websiteNameLabel;
    private javax.swing.JTextField websiteTextField;
    // End of variables declaration//GEN-END:variables
}
