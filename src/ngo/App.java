package ngo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author swshrestha
 */
public class App {

    public static void main(String[] args) {

        final Message licenseValidationMessage = new LicenseValidator().hasValidLicense();
        final boolean licenseStatus = licenseValidationMessage.getStatus();
        final String message = licenseValidationMessage.getMessage();
        LicenseValidation validation = new LicenseValidation(message);
        
        System.out.println("message" + message);
        System.out.println(LicenseValidator.LicenseValidationError.EXPIRED.getMessage());
        
        if (message.equals(LicenseValidator.LicenseValidationError.DOES_NOT_EXIST.getMessage())) {
            validation.setVisible(true);
        } else if (message.equals(LicenseValidator.LicenseValidationError.EXPIRED.getMessage())) {
            validation.setVisible(true);
        } else {
            HomePage home = new HomePage(message);
            home.setVisible(true);
        }

    }
}
