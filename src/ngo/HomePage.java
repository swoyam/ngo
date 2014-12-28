/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import ngo.model.Dashboard;

/**
 *
 * @author swoyambhu
 */
public class HomePage extends javax.swing.JFrame {

    private final JTextField searchBoxTextField;
    private final Vector<String> vector = new Vector<String>();
    private boolean hide_flag = false;
    String[] defaultMessageForSearchBox = {"Type text to search."};

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();

        setLocationRelativeTo(null);
        jTree1.setRootVisible(false);
        jTree1.setModel(getTreeModel(new Dashboard().getSectorWiseOrganizations()));

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selRow = jTree1.getRowForLocation(e.getX(), e.getY());
                MyDefaultTreeNode selectedNode = (MyDefaultTreeNode) jTree1.getLastSelectedPathComponent();
                if (selRow != -1) {
                    if (e.getClickCount() == 2 && selectedNode.isLeaf()) {
                        searchMessage.setText(selectedNode.toString());
                        ViewOrganization viewOrganization = new ViewOrganization();
                        viewOrganization.setVisible(true);
                        viewOrganization.setValues(new Dashboard().getOrganization(selectedNode.userId));
                    }
                }
            }
        };
        jTree1.addMouseListener(ml);

        searchBoxTextField = (JTextField) searchBox.getEditor().getEditorComponent();
        searchBoxTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        String text = searchBoxTextField.getText();
                        if (text.length() == 0) {
                            searchBox.hidePopup();
                            setModel(new DefaultComboBoxModel(defaultMessageForSearchBox), "");
                        } else {
                            DefaultComboBoxModel m = getSuggestedModel(text);
                            if (m.getSize() == 0 || hide_flag) {
                                searchBox.hidePopup();
                                hide_flag = false;
                            } else {
                                setModel(m, text);
                                searchBox.showPopup();
                            }
                        }
                    }
                });
            }

            public void keyPressed(KeyEvent e) {
                String text = searchBoxTextField.getText();
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ENTER) {
                    Vector<String> vector = new Dashboard().getMatchingOrganizations(text);
                    if (!vector.contains(text)) {
                        vector.addElement(text);
                        Collections.sort(vector);
                        setModel(getSuggestedModel(text), text);
                    }
                    SearchResultPage searchResultPage = new SearchResultPage(text);
                    searchResultPage.setVisible(true);
                    System.out.println(searchBoxTextField.getText());
                    hide_flag = true;
                } else if (code == KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                } else if (code == KeyEvent.VK_RIGHT) {
                    Vector<String> vector = new Dashboard().getMatchingOrganizations(text);
                    for (int i = 0; i < vector.size(); i++) {
                        String str = vector.elementAt(i);
                        if (str.toLowerCase().contains(text.toLowerCase())) {
                            searchBox.setSelectedIndex(-1);
                            searchBoxTextField.setText(str);
                            return;
                        }
                    }
                }
            }
        });

        //setModel(new DefaultComboBoxModel(defaultMessage), "");
    }

    private class MyDefaultTreeNode extends DefaultMutableTreeNode {
        
        Integer userId;
        
        public MyDefaultTreeNode(String userObject) {
            this.userObject = userObject;
        }

        public MyDefaultTreeNode(Integer userId, String userObject) {
            this.userId = userId;
            this.userObject = userObject;
        }

        @Override
        public String toString() {
            if (userObject == null) {
                return "";
            } else {
                return userObject.toString();
            }
        }

    }

    private void setModel(DefaultComboBoxModel mdl, String str) {
        searchBox.setModel(mdl);
        searchBox.setSelectedIndex(-1);
        searchBoxTextField.setText(str);
    }

    private static DefaultComboBoxModel getSuggestedModel(String text) {

        DefaultComboBoxModel model = new DefaultComboBoxModel(new Dashboard().getMatchingOrganizations(text));

        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        searchMessage = new javax.swing.JLabel();
        searchBox = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        refreshMenu = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addNewOrganization = new javax.swing.JMenuItem();
        editOrganization = new javax.swing.JMenuItem();
        deleteOrganization = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        title.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        title.setForeground(new java.awt.Color(16, 59, 16));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("NGO Federation of Nepal  Kaski");
        title.setBorder(null);

        jLabel1.setText("Sectoral");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        searchBox.setEditable(true);
        searchBox.setToolTipText("Search");
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        refreshMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        refreshMenu.setText("Refresh");
        refreshMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuActionPerformed(evt);
            }
        });
        jMenu1.add(refreshMenu);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Organization");

        addNewOrganization.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        addNewOrganization.setText("Add New");
        addNewOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewOrganizationActionPerformed(evt);
            }
        });
        jMenu2.add(addNewOrganization);

        editOrganization.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        editOrganization.setText("Edit");
        editOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrganizationActionPerformed(evt);
            }
        });
        jMenu2.add(editOrganization);

        deleteOrganization.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        deleteOrganization.setText("Delete");
        deleteOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrganizationActionPerformed(evt);
            }
        });
        jMenu2.add(deleteOrganization);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchMessage)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void addNewOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewOrganizationActionPerformed
        AddOrganization addOrganization = new AddOrganization();
        addOrganization.setVisible(true);
    }//GEN-LAST:event_addNewOrganizationActionPerformed

    private void editOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editOrganizationActionPerformed

    private void refreshMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuActionPerformed
        refreshJTree();
    }//GEN-LAST:event_refreshMenuActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        System.out.println("Window Refreshed");
        refreshJTree();
    }//GEN-LAST:event_formWindowGainedFocus

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed

    }//GEN-LAST:event_searchBoxActionPerformed

    private void deleteOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteOrganizationActionPerformed

    private void refreshJTree() {
        jTree1.setModel(getTreeModel(new Dashboard().getSectorWiseOrganizations()));
        jTree1.repaint();

    }

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });

    }

    public TreeModel getTreeModel(TreeMap<String, TreeMap<Integer, String>> inputMap) {

        MyDefaultTreeNode treeNodeRoot = new MyDefaultTreeNode("root");

        for (Map.Entry<String, TreeMap<Integer, String>> firstLevelEntry : inputMap.entrySet()) {

            MyDefaultTreeNode treeNode1 = new MyDefaultTreeNode(firstLevelEntry.getKey());

            for (Map.Entry<Integer, String> secondLevelEntry : firstLevelEntry.getValue().entrySet()) {
                MyDefaultTreeNode treeNode2 = new MyDefaultTreeNode(secondLevelEntry.getKey(), secondLevelEntry.getValue());
                treeNode1.add(treeNode2);
            }

            treeNodeRoot.add(treeNode1);
        }
        DefaultTreeModel model = new DefaultTreeModel(treeNodeRoot);
        return model;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNewOrganization;
    private javax.swing.JMenuItem deleteOrganization;
    private javax.swing.JMenuItem editOrganization;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem refreshMenu;
    private javax.swing.JComboBox searchBox;
    private javax.swing.JLabel searchMessage;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}