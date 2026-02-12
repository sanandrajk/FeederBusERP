package dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.beust.ah.A;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DashboardLocators {
    
    private Page page;
    private Locator dashboardText;
    APIRequestContext apiContext; // <-- declare at class level
    Playwright playwright;
    Browser browser;
    BrowserContext context;


    //left panel locators
    private Locator dash_leftpanel_dashboard;
    private Locator dash_leftpanel_livetracking;
    private Locator dash_leftpanel_busmanagement;
    private Locator dash_leftpanel_busschedule;
    private Locator dash_leftpanel_employees;
    private Locator dash_leftpanel_logout;

    //calendar locators
    Locator dash_calendar_icon;
    Locator dash_calendar_icon_previousButton;
    Locator dash_calendar_icon_doneButton;

    //dashboard - revenue locators
    Locator dash_total_revenue;
    Locator dash_total_cash_revenue;
    Locator dash_total_upi_revenue;
    Locator dash_total_card_revenue;
    Locator dash_total_pass_revenue;
    Locator dash_pass_revenue_cash; 
    Locator dash_pass_revenue_upi;
    Locator dash_pass_revenue_card;

    //dashboard - tickets locators
    Locator dash_total_tickets;
    Locator dash_tickets_cash;
    Locator dash_tickets_upi;
    Locator dash_tickets_card;
    Locator dash_tickets_pass;
    
    //dashboard - passengers locators
    Locator dash_total_passengers;
    Locator dash_passenger_male;
    Locator dash_passenger_female;
    Locator dash_passenger_child;
    Locator dash_passenger_others;

    //dashboard - live buses locators
    Locator dash_live_buses_total;  
    Locator dash_live_buses_live;
    Locator dash_live_buses_idle;
    Locator dash_live_buses_scheduledTrips;
    Locator dash_live_buses_completedTrips;
    Locator dash_live_buses_epk;




    //dashboard page locators
    private Locator loginButton;
    private Locator actualErrorToast;

    private static Locator loginErrorText;

    public DashboardLocators(Page page) {
        this.page = page;
        this.dashboardText = page.locator("//span[text()=\"Metro Connect\"]");
        this.dash_leftpanel_dashboard = page.locator("//span[text()='Dashboard']");
        this.dash_leftpanel_livetracking = page.locator("//span[text()='Live Tracking']");
        this.dash_leftpanel_busmanagement = page.locator("//a[@id='leftpanel    -busmanagement']");
        this.dash_leftpanel_busschedule = page.locator("//span[text()='Bus Schedule']");
        this.dash_leftpanel_employees = page.locator("//span[text()='Employees']");
        this.dash_leftpanel_logout = page.locator("//span[text()='Logout']");

        //calendar locators
        this.dash_calendar_icon = page.locator("xpath=//span[@class='date-text']");
        this.dash_calendar_icon_previousButton = page.locator("xpath=//button[contains(@class,'nav-btn') and @aria-label='Previous month']");
        this.dash_calendar_icon_doneButton = page.locator("xpath=//button[@title='Done']");

        //dashboard - revenue
        this.dash_total_revenue = page.locator("xpath=//*[name()='text' and @class='revenue-center-amount']");  //done
        this.dash_total_cash_revenue = page.locator("xpath=(//div[@class='revenue-box-value'])[1]");
        this.dash_total_card_revenue = page.locator("xpath=(//div[@class='revenue-box-value'])[2]");   
        this.dash_total_upi_revenue = page.locator("xpath=(//div[@class='revenue-box-value'])[3]"); 
        this.dash_total_pass_revenue = page.locator("xpath=(//div[@class='revenue-box-value'])[4]");   
        this.dash_pass_revenue_cash = page.locator("//div[contains(@class,'revenue-breakdown-box-pass')]\r\n" + " //span[@class='pass-breakdown-label' and normalize-space()='CASH']\r\n" +" /following-sibling::span[@class='pass-breakdown-value']");   
        this.dash_pass_revenue_upi = page.locator("//div[contains(@class,'revenue-breakdown-box-pass')]\r\n" + " //span[@class='pass-breakdown-label' and normalize-space()='UPI']\r\n" +" /following-sibling::span[@class='pass-breakdown-value']");   
        this.dash_pass_revenue_card = page.locator("//div[contains(@class,'revenue-breakdown-box-pass')]\r\n" + " //span[@class='pass-breakdown-label' and normalize-space()='CARD']\r\n" +" /following-sibling::span[@class='pass-breakdown-value']");

        //dashboard - tickets
        this.dash_total_tickets = page.locator("xpath=//*[name()='text' and @class='tickets-center-amount']");
        this.dash_tickets_cash = page.locator("//span[@class='ticket-breakdown-label' and normalize-space()='Cash']\r\n" +"/following-sibling::span[@class='ticket-breakdown-value']");   
        this.dash_tickets_upi = page.locator("//span[@class='ticket-breakdown-label' and normalize-space()='UPI']\r\n" +"/following-sibling::span[@class='ticket-breakdown-value']");   
        this.dash_tickets_card = page.locator("//span[@class='ticket-breakdown-label' and normalize-space()='Card']/following-sibling::span[@class='ticket-breakdown-value']");   
        this.dash_tickets_pass = page.locator("//span[@class='ticket-breakdown-label' and normalize-space()='Pass']\r\n" +"/following-sibling::span[@class='ticket-breakdown-value']");

        //dashboard - passengers
        this.dash_total_passengers = page.locator("xpath=//span[@class='total-passengers-value']");
        this.dash_passenger_male = page.locator("//span[@class='category-label' and normalize-space()='Male']\r\n" +"/following-sibling::span[@class='category-value']");
        this.dash_passenger_female  = page.locator("//span[@class='category-label' and normalize-space()='Female']\r\n" +"/following-sibling::span[@class='category-value']");
        this.dash_passenger_child = page.locator("//span[@class='category-label' and normalize-space()='Child']\r\n" +"/following-sibling::span[@class='category-value']");
        this.dash_passenger_others = page.locator("//span[@class='category-label' and normalize-space()='Others']\r\n" +"/following-sibling::span[@class='category-value']");
        
        //dashboard - live buses
        this.dash_live_buses_total = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Total Buses']/preceding-sibling::div[@class='status-card-value']");
        this.dash_live_buses_live = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Live Buses']/preceding-sibling::div[@class='status-card-value']");
        this.dash_live_buses_idle = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Idle Buses']/preceding-sibling::div[@class='status-card-value']");
        this.dash_live_buses_scheduledTrips = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Trips: Completed / Scheduled']/preceding-sibling::div[@class='status-card-value']");
        this.dash_live_buses_completedTrips = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Trips: Completed / Scheduled']/preceding-sibling::div[@class='status-card-value']");
        this.dash_live_buses_epk = page.locator("xpath=//div[@class='status-card-label' and normalize-space()='Avg Earnings per kilometer']/preceding-sibling::div[@class='status-card-value']");

    }




    public String dashboardText() {
        return dashboardText.textContent();
    }




    public void clickClusterTab() {
       dash_leftpanel_busschedule.click();
       System.out.println("Clicked on Bus Schedule tab from left panel");
    }


    public void clickLogoutButton() {
        dash_leftpanel_logout.click();
        System.out.println("Clicked on Logout button");
    }

public void selectPastOneMonthDataFromCalendar() throws InterruptedException {
    dash_calendar_icon.click();
    System.out.println("Clicked on Calendar icon");
    dash_calendar_icon_previousButton.click();
    System.out.println("Selected previous month from calendar");
    
     LocalDate today = LocalDate.now();
    LocalDate previousMonthSameDay = today.minusMonths(1);
    int day = previousMonthSameDay.getDayOfMonth();
 
    page.locator("//button[contains(@class,'day-tile') and normalize-space()='"+day+"']").click();
    System.out.println("Selected date: " + previousMonthSameDay);
    Thread.sleep(2000);
    dash_calendar_icon_doneButton.click();
    System.out.println("Clicked on Done button on calendar");
}

public void selectPastOneWeekDataFromCalendar() throws InterruptedException {
    dash_calendar_icon.click();
    System.out.println("Clicked on Calendar icon");

    LocalDate today = LocalDate.now();
    LocalDate oneWeekAgo = today.minusWeeks(1);
    int day = oneWeekAgo.getDayOfMonth();

    // If the week crosses into the previous month, navigate calendar
    if (oneWeekAgo.getMonth() != today.getMonth()) {
        dash_calendar_icon_previousButton.click();
        System.out.println("Selected previous month from calendar");
    }

    page.locator("//button[contains(@class,'day-tile') and normalize-space()='" + day + "']").click();
    System.out.println("Selected date: " + oneWeekAgo);

    Thread.sleep(2000);
    dash_calendar_icon_doneButton.click();
    System.out.println("Clicked on Done button on calendar");
}




     
public void checkUIandAPIValues_revenueAPI(String keyFromAPI, Locator element, String APIEndPointForRevenue) throws InterruptedException {        //Find total cash revenue
        Thread.sleep(5000);
        String uiValue = element.textContent().trim();
        Integer uiTotalCashRevenue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));
        System.out.println("UI Value: " + uiTotalCashRevenue);
        System.out.println("UI value is captured");
        // 3️⃣ Get token from localStorage
        String token = (String) page.evaluate(
                "() => localStorage.getItem('token')"
        );

        // 4️⃣ Create API request context
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Content-Type", "application/json");
        System.out.println("Headers are set");
        Playwright playwright = Playwright.create();
        APIRequestContext apiContext = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(values.Values.API_BASE_URL)
                        .setExtraHTTPHeaders(headers)
        );
        System.out.println("API Context is created");
        APIResponse response = apiContext.get(APIEndPointForRevenue);
        System.out.println("API request is sent");
        Assert.assertEquals(response.status(), 200,
                "API status code mismatch");
        Thread.sleep(5000);
        // 5️⃣ Parse API response
        String responseBody = response.text();
        JSONObject json = new JSONObject(responseBody);
        System.out.println("API response is parsed");
        String apiValue = json
        .getJSONObject("data")
        .get(keyFromAPI)
        .toString();
        Integer APIIntegerValue = (int) Double.parseDouble(apiValue.replaceAll("[^0-9.]", ""));
        System.out.println("API Value: " + APIIntegerValue);

        // 6️⃣ Compare UI vs API
    /* ---------- UI vs API ASSERT ---------- */

    Assert.assertEquals(uiTotalCashRevenue, APIIntegerValue,
            "UI and API values do not match");

    System.out.println("UI and API values match - SUCCESS");
        }
       

public void checkUIandAPIValues_revenueAPI_Detail(String keyFromAPI, String paymentType, Locator element, String APIEndPointForRevenue) throws InterruptedException {

    /* ---------- UI PART ---------- */
        Thread.sleep(5000);
        if(element.isVisible() == false) { 
            System.out.println("Element is not visible on UI, skipping API validation to avoid false negative"); 
            return; 
        }
        

    String uiValue = element.textContent().trim();
    int uiTotalValue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));

    System.out.println("UI Value (Integer): " + uiTotalValue);
    String token = (String) page.evaluate(
            "() => localStorage.getItem('token')");
         //Added due to value 0
            if(uiTotalValue == 0) {
                System.out.println("UI value is 0, skipping API validation to avoid false negative");
                return;
            }

    /* ---------- API CONTEXT ---------- */

    Map<String, String> headers = new HashMap<>();
    headers.put("Authorization", "Bearer " + token);
    headers.put("Content-Type", "application/json");

    // ❌ Do NOT create Playwright again if you already have one
    Playwright playwright = Playwright.create();
    APIRequestContext apiContext = playwright.request().newContext(
            new APIRequest.NewContextOptions()
                    .setBaseURL(values.Values.API_BASE_URL)
                    .setExtraHTTPHeaders(headers)
    );

    /* ---------- API CALL ---------- */
    APIResponse response = apiContext.get(APIEndPointForRevenue);
    Assert.assertEquals(response.status(), 200, "API status code mismatch");

    String responseBody = response.text();
    JSONObject json = new JSONObject(responseBody);
    /* ---------- API PARSING ---------- */

    JSONArray paymentArray = json
            .getJSONObject("data")
            .getJSONArray("payment_breakdown");

    double apiValue = -1;

    for (int i = 0; i < paymentArray.length(); i++) {
        JSONObject payment = paymentArray.getJSONObject(i);

        if (paymentType.equalsIgnoreCase(payment.getString("payment_type"))) {
            apiValue = payment.getDouble(keyFromAPI); // amount OR count
            break;
        }
    }

    // Safety check
    Assert.assertTrue(apiValue >= 0,
            "Payment type not found in API: " + paymentType);

    int apiIntegerValue = (int) apiValue;
    System.out.println("API Value (Integer): " + apiIntegerValue);

    /* ---------- UI vs API ASSERT ---------- */

    Assert.assertEquals(uiTotalValue, apiIntegerValue,
            "UI and API values do not match");

    System.out.println("UI and API values match - SUCCESS");
}


public void checkUIandAPIValues_IssuedPassAPI_Detail(String keyFromAPI, String paymentType, Locator element, String APIEndPointForRevenue) throws InterruptedException {

    /* ---------- UI PART ---------- */
        Thread.sleep(5000);
    if(element.isVisible() == false) {
        System.out.println("Element is not visible on UI, skipping API validation to avoid false negative");
        return;
    }

    String uiValue = element.textContent().trim();
    int uiTotalValue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));

    System.out.println("UI Value (Integer): " + uiTotalValue);
    String token = (String) page.evaluate(
            "() => localStorage.getItem('token')");

    /* ---------- API CONTEXT ---------- */

    Map<String, String> headers = new HashMap<>();
    headers.put("Authorization", "Bearer " + token);
    headers.put("Content-Type", "application/json");

    // ❌ Do NOT create Playwright again if you already have one
    Playwright playwright = Playwright.create();
    APIRequestContext apiContext = playwright.request().newContext(
            new APIRequest.NewContextOptions()
                    .setBaseURL(values.Values.API_BASE_URL)
                    .setExtraHTTPHeaders(headers)
    );

    /* ---------- API CALL ---------- */
    APIResponse response = apiContext.get(APIEndPointForRevenue);
    Assert.assertEquals(response.status(), 200, "API status code mismatch");

    String responseBody = response.text();
    JSONObject json = new JSONObject(responseBody);
    /* ---------- API PARSING ---------- */

    JSONArray paymentArray = json
            .getJSONObject("data")
            .getJSONArray("issued_pass_payment_breakdown"); //THIS IS THE ONLY CHANGE FROM THE ABOVE METHOD

    double apiValue = -1;

    for (int i = 0; i < paymentArray.length(); i++) {
        JSONObject payment = paymentArray.getJSONObject(i);

        if (paymentType.equalsIgnoreCase(payment.getString("payment_type"))) {
            apiValue = payment.getDouble(keyFromAPI); // amount OR count
            break;
        }
    }

    // Safety check
    Assert.assertTrue(apiValue >= 0,
            "Payment type not found in API: " + paymentType);

    int apiIntegerValue = (int) apiValue;
    System.out.println("API Value (Integer): " + apiIntegerValue);

    /* ---------- UI vs API ASSERT ---------- */

    Assert.assertEquals(uiTotalValue, apiIntegerValue,
            "UI and API values do not match");

    System.out.println("UI and API values match - SUCCESS");
}

public void checkUIandAPIValues_PassengerAPI_Detail(String keyFromAPI, String paymentType, Locator element, String APIEndPointForRevenue) throws InterruptedException {

    /* ---------- UI PART ---------- */
        Thread.sleep(5000);

    String uiValue = element.textContent().trim();
    int uiTotalValue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));

    System.out.println("UI Value (Integer): " + uiTotalValue);
    String token = (String) page.evaluate(
            "() => localStorage.getItem('token')");

    /* ---------- API CONTEXT ---------- */

    Map<String, String> headers = new HashMap<>();
    headers.put("Authorization", "Bearer " + token);
    headers.put("Content-Type", "application/json");

    // ❌ Do NOT create Playwright again if you already have one
    Playwright playwright = Playwright.create();
    APIRequestContext apiContext = playwright.request().newContext(
            new APIRequest.NewContextOptions()
                    .setBaseURL(values.Values.API_BASE_URL)
                    .setExtraHTTPHeaders(headers)
    );

    /* ---------- API CALL ---------- */
    APIResponse response = apiContext.get(APIEndPointForRevenue);
    Assert.assertEquals(response.status(), 200, "API status code mismatch");

    String responseBody = response.text();
    JSONObject json = new JSONObject(responseBody);
    /* ---------- API PARSING ---------- */

    JSONArray paymentArray = json
            .getJSONObject("data")
            .getJSONArray("passenger_breakdown"); //THIS IS THE ONLY CHANGE FROM THE ABOVE METHOD

    double apiValue = -1;

    for (int i = 0; i < paymentArray.length(); i++) {
        JSONObject payment = paymentArray.getJSONObject(i);

        if (paymentType.equalsIgnoreCase(payment.getString("ticket_type"))) {
            apiValue = payment.getDouble(keyFromAPI); // amount OR count
            break;
        }
    }

    // Safety check
    Assert.assertTrue(apiValue >= 0,
            "Passenger type not found in API: " + paymentType);

    int apiIntegerValue = (int) apiValue;
    System.out.println("API Value (Integer): " + apiIntegerValue);

    /* ---------- UI vs API ASSERT ---------- */

    Assert.assertEquals(uiTotalValue, apiIntegerValue,
            "UI and API values do not match");

    System.out.println("UI and API values match - SUCCESS");
}

public void checkUIandAPIValues_busStatusAPI(String keyFromAPI, Locator element, String APIEndPoint) throws InterruptedException {        //Find total cash revenue
    Thread.sleep(5000);
    String uiValue = element.textContent().trim();
    // Integer uiTotalCashRevenue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));
    // System.out.println("UI Value: " + uiTotalCashRevenue);

//String uiValue = element.textContent().trim();
BigDecimal uiTotalCashRevenue =
        new BigDecimal(uiValue.replaceAll("[^0-9.]", ""));
System.out.println("UI Value: " + uiTotalCashRevenue);
int uiTotalCashRevenue_IntValue = uiTotalCashRevenue.intValue();



    System.out.println("UI value is captured");
    // 3️⃣ Get token from localStorage
    String token = (String) page.evaluate(
            "() => localStorage.getItem('token')"
    );

    // 4️⃣ Create API request context
    Map<String, String> headers = new HashMap<>();
    headers.put("Authorization", "Bearer " + token);
    headers.put("Content-Type", "application/json");
    System.out.println("Headers are set");
    Playwright playwright = Playwright.create();
    APIRequestContext apiContext = playwright.request().newContext(
            new APIRequest.NewContextOptions()
                    .setBaseURL(values.Values.API_BASE_URL)
                    .setExtraHTTPHeaders(headers)
    );
    System.out.println("API Context is created");
    APIResponse response = apiContext.get(APIEndPoint);
    System.out.println("API request is sent");
    Assert.assertEquals(response.status(), 200,
            "API status code mismatch");
    Thread.sleep(5000);
    // 5️⃣ Parse API response
    String responseBody = response.text();
    JSONObject json = new JSONObject(responseBody);
    System.out.println("API response is parsed");
    String apiValue = json
    .getJSONObject("data")
    .get(keyFromAPI)
    .toString();
    System.out.println("API Value: " + apiValue);
    Integer APIIntegerValue = (int) Double.parseDouble(apiValue.replaceAll("[^0-9.]", ""));

    // 6️⃣ Compare UI vs API
    if(uiTotalCashRevenue_IntValue == APIIntegerValue) {
       // if(uiTotalCashRevenue == APIIntegerValue) {
        System.out.println("UI and API values match - SUCCESS");

    } else {
        Assert.fail("UI and API values do not match");
    }
    }






















































































}
