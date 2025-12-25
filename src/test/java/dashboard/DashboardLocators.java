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
        this.dash_leftpanel_dashboard = page.locator("//span[text()='Dashboard']");
        this.dash_leftpanel_livetracking = page.locator("//span[text()='Live Tracking']");
        this.dash_leftpanel_busmanagement = page.locator("//a[@id='leftpanel    -busmanagement']");
        this.dash_leftpanel_busschedule = page.locator("//span[text()='Bus Schedule']");
        this.dash_leftpanel_employees = page.locator("//span[text()='Employees']");
        this.dash_leftpanel_logout = page.locator("//span[text()='Logout']");
    
    }




    public String dashboardText() {
        return dashboardText.textContent();
    }




    public void clickClusterTab() {
       dash_leftpanel_busschedule.click();
       System.out.println("Clicked on Bus Schedule tab from left panel");
    }
}


