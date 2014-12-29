/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ngo.dbConnect.SqliteJDBC;
import ngo.model.Dashboard;

/**
 *
 * @author swoyambhu
 */
public class AddOrganization extends javax.swing.JFrame {

    private boolean isAdd = true;
    private Integer org_id = null;

    /**
     * Creates new form AddOrganization
     */
    public AddOrganization() {
        initComponents();
        GeneralUtils.setUILookAndFeel(this);
        setLocationRelativeTo(null);

        sectorComboBox.setModel(getModelForSectorComboBox(new Dashboard().getSectors()));
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
        sectorComboBox = new javax.swing.JComboBox();
        asterisk1 = new javax.swing.JLabel();
        asterisk2 = new javax.swing.JLabel();
        asterisk3 = new javax.swing.JLabel();
        asterisk4 = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        asterisk5 = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        addOrganizationButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        closeMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Organization");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Organization Details"));

        orgNameLabel.setLabelFor(orgNameTxtField);
        orgNameLabel.setText("Organization's Name");

        addressLabel.setLabelFor(addressTxtField);
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

        sectorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectorComboBoxActionPerformed(evt);
            }
        });

        asterisk1.setForeground(new java.awt.Color(238, 13, 13));
        asterisk1.setText("*");

        asterisk2.setForeground(new java.awt.Color(246, 9, 9));
        asterisk2.setText("*");

        asterisk3.setForeground(new java.awt.Color(244, 7, 7));
        asterisk3.setText("*");

        asterisk4.setForeground(new java.awt.Color(236, 7, 7));
        asterisk4.setText("*");

        info1.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        info1.setText("Please fill in the organization details below. Fields marked with");

        asterisk5.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        asterisk5.setForeground(new java.awt.Color(232, 10, 10));
        asterisk5.setText("*");

        info2.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        info2.setText("are mandatory.");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addOrganizationButton.setText("Add");
        addOrganizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationButtonActionPerformed(evt);
            }
        });

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
                                .addComponent(orgNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asterisk1))
                            .addComponent(addressLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(telephoneNoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asterisk2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chairPersonLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asterisk3))
                            .addComponent(mobileNumberLabel)
                            .addComponent(emailAddLabel)
                            .addComponent(websiteNameLabel)
                            .addComponent(sectorLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hodLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asterisk4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(mobileTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(websiteTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(chairPersonTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(hodTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sectorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(orgNameTxtField)
                            .addComponent(addressTxtField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(info1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asterisk5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(info2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addOrganizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asterisk5)
                            .addComponent(info2))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orgNameLabel)
                    .addComponent(orgNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asterisk1))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneNoLabel)
                    .addComponent(asterisk2))
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
                    .addComponent(chairPersonLabel)
                    .addComponent(asterisk3))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hodTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hodLabel)
                    .addComponent(asterisk4))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectorLabel)
                    .addComponent(sectorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(addOrganizationButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeMenuActionPerformed

    private void sectorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectorComboBoxActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        this.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    @SuppressWarnings("empty-statement")
    private void addOrganizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationButtonActionPerformed

        if (!validateTextField(orgNameTxtField, "Organization Name")) {
            return;
        }
        if (!validateTextField(telephoneTxtField, "Telephone Number")) {
            return;
        }
        if (!validateTextField(chairPersonTxtField, "Chairperson Name")) {
            return;
        }
        if (!validateTextField(hodTxtField, "Head of Organization")) {
            return;
        }

        String sectorId = Integer.toString(((Item) sectorComboBox.getSelectedItem()).getId());

//        LinkedList<Object> values = new LinkedList<Object>();
//        values.add(orgNameTxtField.getText());
//        values.add(addressTxtField.getText());
//        values.add(websiteTextField.getText());
//        values.add(emailTextField.getText());
//        values.add(telephoneTxtField.getText());
//        values.add(mobileTxtField.getText());
//        values.add(chairPersonTxtField.getText());
//        values.add(hodTxtField.getText());
//        values.add(sectorId);
//        if(!isAdd) values.add(this.org_id);
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        values.put("office_name", orgNameTxtField.getText());
        values.put("address", addressTxtField.getText());
        values.put("website", websiteTextField.getText());
        values.put("email", emailTextField.getText());
        values.put("telephone_no", telephoneTxtField.getText());
        values.put("mobile_number", mobileTxtField.getText());
        values.put("chair_person", chairPersonTxtField.getText());
        values.put("head_of_org", hodTxtField.getText());
        values.put("sector_sector_id", sectorId);

        if (!isAdd) {
            values.put("office_id", this.org_id);
        }

        if (isAdd) {
            if (new SqliteJDBC().insertIntoOrganization(values)) {
                JOptionPane.showMessageDialog(this,
                        "Organization Added Successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error! Operation Failed",
                        "Error",
                        JOptionPane.ERROR);
            }
        } else {
            if (new SqliteJDBC().updateOrganization(values)) {
                JOptionPane.showMessageDialog(this,
                        "Organization updated Successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error! Operation Failed"
                );
            }
        }


    }//GEN-LAST:event_addOrganizationButtonActionPerformed

    private void orgNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgNameTxtFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrganization().setVisible(true);
            }
        });
    }

    private void reset() {
        orgNameTxtField.setText(null);
        addressTxtField.setText(null);
        websiteTextField.setText(null);
        emailTextField.setText(null);
        telephoneTxtField.setText(null);
        mobileTxtField.setText(null);
        chairPersonTxtField.setText(null);
        hodTxtField.setText(null);
        sectorComboBox.setSelectedIndex(0);
    }

    public ComboBoxModel getModelForSectorComboBox(TreeMap<Integer, String> inputMap) {
        Vector vector = new Vector();
        for (Map.Entry<Integer, String> entry : inputMap.entrySet()) {
            vector.add(new Item(entry.getKey(), entry.getValue()));
        }
        return new javax.swing.DefaultComboBoxModel(vector);
    }

    private boolean validateTextField(JTextField field, String label) {
        String testString = field.getText();
        if (testString == null || testString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    label + " Cannot be Empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    public void setValues(Map<String, Object> valueMap) {
        System.out.println("valueMap" + valueMap);
        this.orgNameTxtField.setText(valueMap.get("officeName").toString());
        this.addressTxtField.setText(valueMap.get("address").toString());
        this.websiteTextField.setText(valueMap.get("website").toString());
        this.telephoneTxtField.setText(valueMap.get("telephone_no").toString());
        this.mobileTxtField.setText(valueMap.get("mobile_number").toString());
        this.chairPersonTxtField.setText(valueMap.get("chair_person").toString());
        this.hodTxtField.setText(valueMap.get("head_of_org").toString());
        this.addOrganizationButton.setText("update");
        this.sectorComboBox.setEnabled(true);
        this.isAdd = false;
        this.org_id = Integer.parseInt(valueMap.get("office_id").toString());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrganizationButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTxtField;
    private javax.swing.JLabel asterisk1;
    private javax.swing.JLabel asterisk2;
    private javax.swing.JLabel asterisk3;
    private javax.swing.JLabel asterisk4;
    private javax.swing.JLabel asterisk5;
    private javax.swing.JLabel chairPersonLabel;
    private javax.swing.JTextField chairPersonTxtField;
    private javax.swing.JMenuItem closeMenu;
    private javax.swing.JLabel emailAddLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel hodLabel;
    private javax.swing.JTextField hodTxtField;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mobileNumberLabel;
    private javax.swing.JTextField mobileTxtField;
    private javax.swing.JLabel orgNameLabel;
    private javax.swing.JTextField orgNameTxtField;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox sectorComboBox;
    private javax.swing.JLabel sectorLabel;
    private javax.swing.JLabel telephoneNoLabel;
    private javax.swing.JTextField telephoneTxtField;
    private javax.swing.JLabel websiteNameLabel;
    private javax.swing.JTextField websiteTextField;
    // End of variables declaration//GEN-END:variables
}
