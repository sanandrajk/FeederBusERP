package sample;
import com.microsoft.playwright.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APICheck {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
        APIRequestContext apiContext; // <-- declare at class level


@BeforeClass
public void setup() {
    playwright = Playwright.create();

    // UI setup
    browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
    );
    context = browser.newContext();
    page = context.newPage();

    // API setup  ✅ THIS WAS MISSING
    apiContext = playwright.request().newContext();
}

    @Test
    public void verifyUIAndAPIData() throws InterruptedException {

        // 1️⃣ Login via UI
        page.navigate("https://xplor-feeder-erp-test.netlify.app/");
        page.fill("//input[@id='username']", "sanandautomation@mailinator.com");
        page.fill("//input[@id='password']", "Sanand@123");
        page.click("//button[@type='submit']");
        System.out.println("Login clicked");
        page.waitForURL("https://xplor-feeder-erp-test.netlify.app/dashboard");
        System.out.println("Dashboard page is loaded");
        // 2️⃣ Get data from UI
               Thread.sleep(5000);

        String uiValue = page.textContent("//*[local-name()='text' and contains(@class,'revenue-center-amount')]").trim();
        Integer uiTotalRevenue = Integer.parseInt(uiValue.replaceAll("[^0-9]", ""));
        System.out.println("UI Value: " + uiTotalRevenue);
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
        APIRequestContext apiContext = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL("https://test.metrofeeder.goxploronline.net/api/v1/metro-feeder")
                        .setExtraHTTPHeaders(headers)
        );

        APIResponse response = apiContext.get("https://test.metrofeeder.goxploronline.net/api/v1/metro-feeder/dashboard/revenue?from_date=2026-01-08&to_date=2026-01-08");
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
        .get("total_revenue")
        .toString();
        System.out.println("API Value: " + apiValue);

        // 6️⃣ Compare UI vs API
        Assert.assertEquals(uiTotalRevenue, Integer.parseInt(apiValue),
                "UI and API values do not match");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
