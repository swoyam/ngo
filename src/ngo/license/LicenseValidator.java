package ngo.license;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ngo.utils.Message;
import ngo.model.Users;
import org.joda.time.DateTime;

/**
 *
 * @author swoyambhu
 */
public class LicenseValidator {

    private final static String SPECIAL_KEY = "swoyam^*~2014";
    private static final String HASH_ALGORITHM = "SHA-1";

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

    }

    public Message addLicenseKey(String username, String key) {

        Valididy validtyOfLicenseKey = getValidity(username, key);

        if (!validtyOfLicenseKey.getPeriod().equals(ValidityPeriod.INVALID)) {
            Message insertLicenseMessage = insertLicenseToDb(username, key);
            if (insertLicenseMessage.getStatus()) {
                String message = "License Key Registered to " + username + "."
                        + "\nLicense Type: " + validtyOfLicenseKey.getPeriod().name() + "."
                        + "\nValid from " + validtyOfLicenseKey.getFromDateString() + " to " + validtyOfLicenseKey.getToDateString() + ".";
                return new Message(true, message);
            } else {
                return insertLicenseMessage;
            }
        }

        return new Message(false, "License Key Invalid.");

    }

    private Message insertLicenseToDb(String username, String licenseKey) {

        ArrayList<Users> userInfoList = new Users().getLicenseInfo();
        for (Users userInfo : userInfoList) {
            if(userInfo.getLicenseKey().equals(licenseKey)){
                return new Message(false, "License Key already used. Please enter a new one.");
            }
        }

        Users userInfo = new Users();
        userInfo.setUserName(username);
        userInfo.setLicenseKey(licenseKey);

        Valididy validityObj = getValidity(username, licenseKey);

        userInfo.setLicenseType(validityObj.getPeriod());
        userInfo.setStartDate(validityObj.getFromDate());
        userInfo.setEndDate(validityObj.getToDate());

        Message message = userInfo.insertLicense();

        return message;
    }

    public Message hasValidLicense() {

        ArrayList<Users> userInfoList = new Users().getLicenseInfo();
        System.out.println("userInfoList = " + userInfoList);

        if (userInfoList == null || userInfoList.size() == 0) {
            return new Message(false, LicenseValidationError.DOES_NOT_EXIST.getMessage());
        } else {
            for (Users userInfo : userInfoList) {

                long fromDate = userInfo.getStartDate();
                long toDate = userInfo.getEndDate();
                String username = userInfo.getUserName();
                ValidityPeriod period = userInfo.getLicenseType();

                long currentDate = new Date().getTime();
                System.out.println("currentDate = " + new DateTime(currentDate).toString("yyyy-MM-dd"));
                System.out.println("fromDate = " + new DateTime(fromDate).toString("yyyy-MM-dd"));
                System.out.println("toDate = " + new DateTime(toDate).toString("yyyy-MM-dd"));

                if ((ValidityPeriod.PERPETUAL.equals(period))
                        || (currentDate >= fromDate && currentDate <= toDate)) {
                    return new Message(true, "License Key Registered to " + username);
                } else {
                    return new Message(false, LicenseValidationError.EXPIRED.getMessage());
                }
            }
        }
        return new Message(false, "Oops Something went wrong!");
    }

    public enum LicenseValidationError {

        EXPIRED("License Key Expired."), DOES_NOT_EXIST("License Key Missing.");

        String message;

        LicenseValidationError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

    private static Valididy getValidity(String username, String key) {

        ValidityPeriod period = getValidityPeriod(username, key);
        long currentDate = new DateTime().getMillis();
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
