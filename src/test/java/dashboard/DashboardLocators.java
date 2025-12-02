package dashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardLocators {
    
    private Page page;
    private Locator dashboardText;

    //left panel locators
    private Locator dash_leftpanel_dashboard;
    private Locator dash_leftpanel_livetracking;
    private Locator dash_leftpanel_busmanagement;
    private Locator dash_leftpanel_busschedule;
    private Locator dash_leftpanel_employees;
    private Locator dash_leftpanel_logout;

    //dashboard page locators
    private Locator loginButton;
    private Locator actualErrorToast;

    private static Locator loginErrorText;

    public DashboardLocators(Page page) {
        this.page = page;
        this.dashboardText = page.locator("//span[text()=\"Metro Connect\"]");
      //  this.loginPassword = page.locator("//input[@id='password']");
        //this.loginButton = page.locator("//button[@type='submit']");
        //this.loginErrorText = page.locator("//span[contains(@class, 'text-red-700')]");
    
    }




    public String dashboardText() {
        return dashboardText.textContent();
    }
}


