package ngo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author swoyambhu
 */
public class LicenseValidator {

    private final static String SPECIAL_KEY = "swoyam^*~2014";
    private static final String HASH_ALGORITHM = "SHA-1";

    private static boolean insertLicenseToDb() {
        return true;
    }

    private static boolean updateLicenseInDb() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum ValidityPeriod {

        MONTHLY(30), YEARLY(365), PERPETUAL(3650), INVALID(-1);

        int days;

        ValidityPeriod(int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();

        System.out.println("month");
        System.out.println(generateLicenseKey(userName, ValidityPeriod.MONTHLY));
        System.out.println("year");
        System.out.println(generateLicenseKey(userName, ValidityPeriod.YEARLY));
        System.out.println("perpetual");
        System.out.println(generateLicenseKey(userName, ValidityPeriod.PERPETUAL));

        System.out.println(addLicenseKey(userName, generateLicenseKey(userName, ValidityPeriod.MONTHLY)));
        System.out.println(addLicenseKey(userName, generateLicenseKey(userName, ValidityPeriod.YEARLY)));
        System.out.println(addLicenseKey(userName, generateLicenseKey(userName, ValidityPeriod.PERPETUAL)));
        System.out.println(addLicenseKey(userName, "651290451032cba256b17ddad927c8808cf694ef"));

    }

    public static Message addLicenseKey(String username, String key) {

        Valididy validtyOfLicenseKey = getValidity(username, key);

        if (!validtyOfLicenseKey.getPeriod().equals(ValidityPeriod.INVALID)) {
            if (insertLicenseToDb()) {
                String message = "License Key Registered to " + username + "."
                        + "\nLicense Type: " + validtyOfLicenseKey.getPeriod().name() + "."
                        + "\nValid from " + validtyOfLicenseKey.getFromDateString() + " to " + validtyOfLicenseKey.getToDateString() + ".";
                return new Message(true, message);
            }
        }

        return new Message(false, "License Key Invalid.");

    }

    public static Message updateLicenseKey(String username, String key) {

        Valididy validtyOfLicenseKey = getValidity(username, key);

        if (!validtyOfLicenseKey.getPeriod().equals(ValidityPeriod.INVALID)) {
            if (updateLicenseInDb()) {
                String message = "License Key Updated."
                        + "\nLicense Key Registered to " + username + "."
                        + "\nLicense Type: " + validtyOfLicenseKey.getPeriod().name() + "."
                        + "\nValid from " + validtyOfLicenseKey.getFromDateString() + " to " + validtyOfLicenseKey.getToDateString() + ".";
                return new Message(true, message);
            }
        }

        return new Message(false, "License Key Invalid.");

    }

    public Message hasValidLicense() {

        //for each entry in db.
        //todo get dates from db
        long fromDate = getDateInMillis("2001-01-01");
        long toDate = getDateInMillis("205-01-01");
        String username = "username";
        String periodFromDb = "PERPETUAL";
        ValidityPeriod period = ValidityPeriod.valueOf(periodFromDb);
        
        long currentDate = new Date().getTime();
        
        if(false){ // no data in db
            return new Message(false, LicenseValidationError.DOES_NOT_EXIST.getMessage());

        }
        
        if ((ValidityPeriod.PERPETUAL.equals(period)) 
                ||  ( currentDate >= fromDate && currentDate <= toDate)) {
            return new Message(true, "License Key Registered to "+ username );
        } else {
            return new Message(false, LicenseValidationError.EXPIRED.getMessage());
        }

    }

    enum LicenseValidationError{
        EXPIRED("License Key Expired."),DOES_NOT_EXIST("License Key Missing.");
        
        String message;
        
        LicenseValidationError(String message){
            this.message = message;
        }
        
        public String getMessage(){
            return message;
        }
    
    }
    
    
    private static Valididy getValidity(String username, String key) {

        ValidityPeriod period = getValidityPeriod(username, key);
        long currentDate = new Date().getTime();
        long toDate = new DateTime(currentDate).plusDays(period.getDays()).getMillis();
        Valididy validityObject = new Valididy(period, currentDate, toDate);

        return validityObject;

    }

    private static ValidityPeriod getValidityPeriod(String username, String key) {

        for (ValidityPeriod period : ValidityPeriod.values()) {
            if (key.equals(generateLicenseKey(username, period))) {
                return period;
            }
        }

        return ValidityPeriod.INVALID;
    }

    private static String generateLicenseKey(String userName, ValidityPeriod validityPeriod) {

        String text = userName + SPECIAL_KEY + validityPeriod.name();
        String hash = generateHash(text);

        return (hash);

    }

    //http://www.mkyong.com/java/java-md5-hashing-example/
    private static String generateHash(final String text) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            md.update(text.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LicenseValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Cannot generate Hash");
    }

    private long getDateInMillis(String dateInString) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date t;
        try {
            t = ft.parse(dateInString);
            return t.getTime();
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
        throw new RuntimeException("Unparseable String: " + dateInString);
    }

    static class Valididy {

        public Valididy(ValidityPeriod period, long fromDate, long toDate) {
            this.period = period;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }

        public ValidityPeriod getPeriod() {
            return period;
        }

        public void setPeriod(ValidityPeriod period) {
            this.period = period;
        }

        public long getFromDate() {
            return fromDate;
        }

        public String getFromDateString() {
            return new DateTime(fromDate).toString("yyyy-MM-dd");
        }

        public void setFromDate(long fromDate) {
            this.fromDate = fromDate;
        }

        public long getToDate() {
            return toDate;
        }

        public String getToDateString() {
            return new DateTime(toDate).toString("yyyy-MM-dd");
        }

        public void setToDate(long toDate) {
            this.toDate = toDate;
        }

        ValidityPeriod period;
        long fromDate;
        long toDate;

    }

}
