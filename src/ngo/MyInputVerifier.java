/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author swoyambhu
 */
class NullValueInputVerifier extends InputVerifier {

    public NullValueInputVerifier() {
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if (text == null || text.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

}
