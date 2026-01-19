package beforeMethod;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SetupBrowser {
    //https://xplor-erp-dev.netlify.app/
    //https://execution-internal-dashboard-test.netlify.app/login
    //https://xplor-feeder-erp-test.netlify.app/
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    APIRequestContext apiContext;   


    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        page.navigate(values.Values.BASE_URL);
        System.out.println("Browser and URL are launched");

        // ✅ API Context creation
        apiContext = playwright.request().newContext(
            new APIRequest.NewContextOptions()
                    .setBaseURL(values.Values.API_BASE_URL)
                    .setExtraHTTPHeaders(Map.of(
                            "Content-Type", "application/json",
                            "Authorization", "Bearer " + values.Values.TOKEN
                    ))
                );
                System.out.println("API Context is created");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Driver is closing");
        browser.close();
        playwright.close();
    }
}

//Generate code using Playwright CLI - Java
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"