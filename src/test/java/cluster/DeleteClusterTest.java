package cluster;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import beforeMethod.SetupBrowser;
import dashboard.DashboardLocators;
import login.LoginLocators;

public class DeleteClusterTest extends SetupBrowser {
    
     private LoginLocators login;
    private DashboardLocators dash;
    private ClusterLocators cluster;

    @BeforeMethod
    public void init() {
        login = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
        cluster = new ClusterLocators(page);
    }

    @Test
    public void FM_ERP_DeleteCluster_01() throws InterruptedException {
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        cluster.enterClusterSearch("abc");
        Thread.sleep(2000);
        cluster.clickDeleteClusterButton();
        Thread.sleep(2000);
        cluster.clickCanceldeleteAltert();
    }




}
