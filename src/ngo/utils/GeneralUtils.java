/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author swshrestha
 */
public class GeneralUtils {

    public static void setUILookAndFeel(JFrame frame) {
        try {
            UIManager.setLookAndFeel(UIManager
                    .getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }
    
    public static boolean validateTextField(JFrame frame, JTextField field, String label) {
        String testString = field.getText();
        if (testString == null || testString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    label + " Cannot be Empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validateLength(JFrame frame, JTextField field, String componentLabel, int maxLength) {
        String testString = field.getText().trim();

        if (testString.length() > maxLength) {
            JOptionPane.showMessageDialog(frame,
                    componentLabel + " Cannot be more than " + maxLength + " characters.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return false;
        }

        return true;
    }
    
}
