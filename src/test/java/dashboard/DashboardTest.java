package dashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardTest {
    
    private Page page;
    private Locator loginEmailid;
    private Locator loginPassword;
    private Locator loginButton;
    private Locator actualErrorToast;
    private static Locator loginErrorText;

    // public DashboardLocators(Page page) {
    //     this.page = page;
    //     this.loginEmailid = page.locator("//input[@id='username']");
    //     this.loginPassword = page.locator("//input[@id='password']");
    //     this.loginButton = page.locator("//button[@type='submit']");
    //     this.loginErrorText = page.locator("//span[contains(@class, 'text-red-700')]");
    // }
}


