/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo.search;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class TextPrompt extends JLabel
        implements FocusListener, DocumentListener {

    private JTextComponent component;
    private Document document;

    public TextPrompt(String text, JTextComponent component) {
        this.component = component;
        document = component.getDocument();

        setText(text);
        setFont(new java.awt.Font("Ubuntu", 2, 12));
        setBorder(new EmptyBorder(component.getInsets()));

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.add(this);
    }

    public void checkForPrompt() {
        if (document.getLength() == 0) {
            setSize(component.getSize());
        } else {
            setSize(0, 0);
        }
    }

//  Implement FocusListener
    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    public void focusLost(FocusEvent e) {
        
        checkForPrompt();
        //setSize(0, 0);
    }

//  Implement DocumentListener
    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void changedUpdate(DocumentEvent e) {
    }

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JTextField tf1 = new JTextField(10);
        panel.add(tf1);
        JTextField tf2 = new JTextField(10);
        panel.add(tf2);

        new TextPrompt("First Name", tf1);
        new TextPrompt("Last Name", tf2);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
