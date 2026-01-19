package values;

import java.time.LocalDate;
import java.util.Random;

public class Values {

//<--------------------------Common Values--------------------------------->

    //login credentials and URL
    public static final String BASE_URL = "https://xplor-feeder-erp-test.netlify.app/";
    public static final String LOGIN_EMAIL = "sanandautomation@mailinator.com";
    public static final String LOGIN_EMAIL_TEST = "sanand@mailinator.com";
    public static final String LOGIN_UPPERCASE_EMAIL = "SANANDAUTOMATION@MAILINATOR.COM";
    public static final String LOGIN_PASSWORD = "Sanand@123";
    public static final String INVALID_LOGIN_EMAIL = "invalid@mailinator.com";
    public static final String INVALID_LOGIN_PASSWORD = "Invalid@123";

    //expected error messages
    public static final String EXPECTED_ERROR_TEXT_INVALID_LOGIN = "Invalid username or password";
    public static final String EXPECTED_ERROR_TEXT_FOR_EMPTY_LOGIN = "Please enter both username and password";


    //dashboard page
    public static final String DASHBOARD_PAGE_METRO_TEXT = "Metro Connect";







    //cluster tab---------------------->
        //add cluster
    public static final String ADD_NEW_CLUSTER_NAME = randomClusterName();
    public static final String ADD_ALREADY_EXISING_CLUSTER_NAME = "Kannur";
    public static final String EMPTY_CLUSTER_NAME = "";
    public static final String SPACE_CLUSTER_NAME = "     ";
    public static final String LEAD_AND_TRAIL_SPACE_CLUSTER_NAME = " LeadandTrail ";
    public static final String SPECIAL_CHAR_CLUSTER_NAME = "@#$%^!";
    public static final String INTEGER_CLUSTER_NAME = "12345";
    public static final String LONG_CLUSTER_NAME = "ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE";

        //Edit cluster
    public static final String EDIT_CLUSTER_NAME = randomClusterName();
    public static final String EDIT_ALREADY_EXISTING_CLUSTER_NAME = "Kannur";
    public static final String EDIT_EMPTY_CLUSTER_NAME = "";
    public static final String EDIT_SPACE_CLUSTER_NAME = "     ";
    public static final String EDIT_LEAD_AND_TRAIL_SPACE_CLUSTER_NAME = " EditLeadandTrail ";
    public static final String EDIT_SPECIAL_CHAR_CLUSTER_NAME = "!@#$%^^&*";
    public static final String EDIT_INTEGER_CLUSTER_NAME = "67890";
    public static final String EDIT_LONG_CLUSTER_NAME = "ZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQZYXWVUTSRQ";
    
    //error messages
    public static final String EXPECTED_DUPLICATE_CLUSTER_ERROR = "Cluster with name 'Kannur' already exists for this organization";
    public static final String EXPECTED_PASS_ERROR = "Pass amount is required when passes are enabled";

    //pass amount
    public static final String VALID_PASS_AMOUNT = "1500";
    public static final String CHAR_PASS_AMOUNT = "Abcde";
    public static final String SPECIAL_CHAR_PASS_AMOUNT = "@#$%^";
    public static final String DECIMAL_PASS_AMOUNT = "2499.55";
    public static final String LONG_DECIMAL_PASS_AMOUNT = "2412.123456";
    public static final String EMPTY_PASS_AMOUNT = "";
    public static final String ZERO_PASS_AMOUNT = "0";
    public static final String NEGATIVE_PASS_AMOUNT = "-500";
    public static final String EMOJI_PASS_AMOUNT = "😀😁🔥";


    //search cluster
    public static final String VALID_SEARCH_NAME = "Kannur";
    public static final String INVALID_SEARCH_NAME = "InvalidSearchClusterName";










    // Generate random cluster name
    public static String randomClusterName() {
    String prefix = "cluster";
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder result = new StringBuilder(prefix);
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
        result.append(characters.charAt(random.nextInt(characters.length())));
    }
    return result.toString();
    }








//<--------------------------APIs--------------------------------->

public static final String API_BASE_URL = "https://test.metrofeeder.goxploronline.net/api/v1/metro-feeder/";
public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbjoxMCIsInVzZXJfaWQiOjEwLCJvcmdhbml6YXRpb25fbmFtZSI6IlNhbmFuZCBBdXRvIiwidXNlcm5hbWUiOiJzYW5hbmRhdXRvbWF0aW9uQG1haWxpbmF0b3IuY29tIiwicm9sZSI6ImFkbWluIiwib3JnX2lkIjoxMCwidHlwZSI6ImFkbWluIn0.WNgKfqgjrTMYtJzbz9SGXqBEMVRH1fb1xJsFrlnpcqM";

//dashboard total report API endpoints
public static final String DASHBOARD_TOTAL_REVENUE_API_ENDPOINT = "/api/v1/metro-feeder/dashboard/revenue";

    public static String getDashboardRevenueEndpointForToday() {
        String todayDate = LocalDate.now().toString();

        return DASHBOARD_TOTAL_REVENUE_API_ENDPOINT
                + "?from_date=" + todayDate
                + "&to_date=" + todayDate;
    }
    
    public static String getDashboardRevenueEndpointForPastOneMonth() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);
        
        return DASHBOARD_TOTAL_REVENUE_API_ENDPOINT
                + "?from_date=" + oneMonthAgo.toString()
                + "&to_date=" + today.toString();
    }
    
    public static String getDashboardRevenueEndpointForPastOneWeek() {
    LocalDate today = LocalDate.now();
    LocalDate oneWeekAgo = today.minusWeeks(1);
    
    return DASHBOARD_TOTAL_REVENUE_API_ENDPOINT
            + "?from_date=" + oneWeekAgo.toString()
            + "&to_date=" + today.toString();
}


public static final String DASHBOARD_TOTAL_TICKETS_API_ENDPOINT = "";
public static final String DASHBOARD_TOTAL_PASSENGERS_API_ENDPOINT = "";

//dashboard live buses API endpoint
public static final String DASHBOARD_LIVE_BUSES_API_ENDPOINT = "/api/v1/metro-feeder/dashboard/bus-statistics";















}
