package Lametayel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GeneralProperties {


        static JSONParser json = new JSONParser();

        static FileReader reader;

        static {
            try {
                reader = new FileReader(GeneralProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\JsonValues.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        static JSONObject obj;

        static {
            try {
                obj = (JSONObject) json.parse(reader);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        public static final String driverName = (String) obj.get("driverName");
        public static final String driverLocation = (String) obj.get("driverLocation");

        public static final String SiteURL1 = (String) obj.get("SiteURL1");
        public static final String SiteURLShop = (String) obj.get("SiteURLShop");
        public static final String SiteURLAttractions = (String) obj.get("SiteURLAttractions");
        public static final String LoginEmail = (String) obj.get("LoginEmail");
        public static final String LoginPassword = (String) obj.get("LoginPassword");
        public static final String username = (String) obj.get("username");
        public static final String userFirstName = (String) obj.get("userFirstName");
        public static final String userLastName = (String) obj.get("userLastName");
        public static final String userMobilePhone = (String) obj.get("userMobilePhone");
        public static final String userCity = (String) obj.get("userCity");
        public static final String userAddress = (String) obj.get("userAddress");

        public static final String myEmail = (String) obj.get("myEmail");
        public static final String myEmailPass = (String) obj.get("myEmailPass");

        public static final String autoITPathToPicture = (String) obj.get("autoITPathToPicture");
        public static final String blogExcelFilePath = (String) obj.get("blogExcelFilePath");

        public static final String dbUser = (String) obj.get("dbUser");
        public static final String dbPassword = (String) obj.get("dbPassword");






        public static String savedScreenshotLocation = (String) obj.get("savedScreenshotLocation");
//        public final static String CAPTURE = (String) obj.get("CAPTURE");

//        public GeneralProperties() throws IOException, ParseException {
//
//        }


    }
