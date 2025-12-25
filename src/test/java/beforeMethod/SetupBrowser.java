package beforeMethod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(values.Values.BASE_URL);
        System.out.println("Browser and URL are launched");
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