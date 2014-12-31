package ngo;

import ngo.utils.Message;
import ngo.license.LicenseValidation;
import ngo.license.LicenseValidator;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ngo.dbConnect.SqliteJDBC;

/**
 *
 * @author swshrestha
 */
public class App {

    public static void main(String[] args) {

        init();

        final Message licenseValidationMessage = new LicenseValidator().hasValidLicense();
        final boolean licenseStatus = licenseValidationMessage.getStatus();
        final String message = licenseValidationMessage.getMessage();
        System.out.println(licenseValidationMessage);
        LicenseValidation validation = new LicenseValidation(message);

        if (message.equals(LicenseValidator.LicenseValidationError.DOES_NOT_EXIST.getMessage())) {

            JOptionPane.showMessageDialog(new JFrame(), message, "Warning!", JOptionPane.ERROR_MESSAGE);
            validation.setVisible(true);
        } else if (message.equals(LicenseValidator.LicenseValidationError.EXPIRED.getMessage())) {
            JOptionPane.showMessageDialog(new JFrame(), message, "Warning!", JOptionPane.INFORMATION_MESSAGE);
            validation.setVisible(true);
        } else if (licenseStatus) {
            HomePage home = new HomePage(message);
            home.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Something went wrong during license validation.");
        }

    }

    private static void init() {
        File folderName = new File("db");
        folderName.mkdirs(); //creating db folder to store database
        SqliteJDBC jdbc = new SqliteJDBC();
        
        Message initDbMessage;
        initDbMessage = jdbc.initiateApplicationDatabase();
        
        System.out.println(initDbMessage);
    }
}
