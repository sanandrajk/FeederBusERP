package cluster;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import beforeMethod.SetupBrowser;
import dashboard.DashboardLocators;
import login.LoginLocators;

public class AddClusterTest extends SetupBrowser{
    
    private LoginLocators locate;
    private DashboardLocators dash;
    private ClusterLocators cluster;

        @BeforeMethod
    public void init() {
        locate = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
        cluster = new ClusterLocators(page);
    }

    @Test
    public void FM_ERP_AddCluster_1() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
       if(cluster.isAddClusterWindowVisible()) {
        System.out.println("Add Cluster popup is displayed");
       } else {
        Assert.fail("Add Cluster popup is not displayed");
       }
    }

    @Test
    public void FM_ERP_AddCluster_2() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(1000);
        cluster.enterClusterSearch(randomClusterName);
    if (cluster.isClusterVisible(randomClusterName)) {
        System.out.println("Cluster found");    } else {
     Assert.fail("Cluster not found after adding");
        }

    }   

    @Test
    public void FM_ERP_AddCluster_3() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enterClusterName(values.Values.INTEGER_CLUSTER_NAME);
        Thread.sleep(1000);
        if(cluster.addCluster_saveButton.isEnabled())  {
            Assert.fail("Save button is enabled for invalid cluster name");
        } else {
            System.out.println("Save button is disabled for invalid cluster name as expected"); 
        }
    }   

    @Test
    public void FM_ERP_AddCluster_4() throws InterruptedException {
       locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enterClusterName(values.Values.SPECIAL_CHAR_CLUSTER_NAME);
        Thread.sleep(1000);
        if(cluster.addCluster_saveButton.isEnabled())  {
            Assert.fail("Save button is enabled for invalid cluster name");
        } else {
            System.out.println("Save button is disabled for invalid cluster name as expected"); 
        }
    }   

    @Test
    public void FM_ERP_AddCluster_5() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_UPPERCASE_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
         if(!cluster.addCluster_passTextfield.isVisible())  {
            Assert.fail("Save button is enabled for invalid cluster name");
        } else {
            System.out.println("Save button is disabled for invalid cluster name as expected"); 
        }
    }  

      @Test
      public void FM_ERP_AddCluster_6() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.VALID_PASS_AMOUNT);
        Thread.sleep(1000);
        if(cluster.addCluster_passTextfield.inputValue().equals(values.Values.VALID_PASS_AMOUNT))  {
            System.out.println("Pass amount entered successfully in Add Cluster window");
        } else {
            Assert.fail("Pass amount not entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    }  

  @Test
      public void FM_ERP_AddCluster_6_1() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.CHAR_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.CHAR_PASS_AMOUNT))  {
            System.out.println("Pass amount is not entered successfully in Add Cluster window");
        } else {
            Assert.fail("Pass amount entered in Add Cluster window");   
        }
    }  

  @Test
    public void FM_ERP_AddCluster_6_2() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.SPECIAL_CHAR_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.SPECIAL_CHAR_PASS_AMOUNT))  {
            System.out.println("Pass amount is notentered successfully in Add Cluster window");
        } else {
            Assert.fail("Pass amount entered in Add Cluster window");   
        }
    }

@Test
    public void FM_ERP_AddCluster_7() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.VALID_PASS_AMOUNT);
        Thread.sleep(1000);
        if(cluster.addCluster_passTextfield.inputValue().equals(values.Values.VALID_PASS_AMOUNT))  {
            System.out.println("Pass amount entered successfully in Add Cluster window");
        } else {
            Assert.fail("Pass amount not entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    }  

    @Test
    public void FM_ERP_AddCluster_8() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(1000);
        cluster.enterClusterSearch(randomClusterName);
        if (cluster.isClusterVisible(randomClusterName)) {
        System.out.println("Cluster found");    } else {
     Assert.fail("Cluster not found after adding");
        }
    }  

    @Test
    public void FM_ERP_AddCluster_9() throws InterruptedException {
       locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        if(!cluster.addCluster_saveButton.isEnabled())  {
            Assert.fail("Save button is NOT enabled for invalid cluster name");
        } else {
            System.out.println("Save button enabled when empty cluster name"); 
        }
    }  

@Test
  public void FM_ERP_AddCluster_10() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.clickAddClusterCancelButton();
        Thread.sleep(1000);
        if(!cluster.isAddClusterWindowVisible()) {
            System.out.println("Add Cluster popup is closed successfully on clicking Cancel button");
           } else {
            Assert.fail("Add Cluster popup is still displayed after clicking Cancel button");
           }
    }  

    @Test
  public void FM_ERP_AddCluster_11() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.clickAddClusterCloseButton();
        Thread.sleep(1000);
        if(!cluster.isAddClusterWindowVisible()) {
            System.out.println("Add Cluster popup is closed successfully on clicking Cancel button");
           } else {
            Assert.fail("Add Cluster popup is still displayed after clicking Cancel button");
           }
    }  

    @Test
  public void FM_ERP_AddCluster_12() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enterClusterName(values.Values.SPACE_CLUSTER_NAME);
        Thread.sleep(1000);
        if(!cluster.addCluster_saveButton.isEnabled())  {
            Assert.fail("Save button is NOT enabled for empty cluster name");
        } else {
            System.out.println("Save button is enabled when empty cluster name"); 
        }
    }  

@Test
  public void FM_ERP_AddCluster_13() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enterClusterName(values.Values.LONG_CLUSTER_NAME);
        Thread.sleep(1000);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(1000);
        cluster.enterClusterSearch(values.Values.LONG_CLUSTER_NAME);
    if (cluster.isClusterVisible(values.Values.LONG_CLUSTER_NAME)) {
        System.out.println("Cluster found");    } else {
     Assert.fail("Cluster not found after adding");
        }
    }  

    @Test
  public void FM_ERP_AddCluster_14() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        cluster.enterClusterName(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME);
        Thread.sleep(1000);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(1000);
        cluster.enterClusterSearch(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME);
    if (!cluster.isClusterVisible(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME)) {
       Assert.fail("Cluster found with lead and trail space");    } else {
     System.out.println("Cluster not found after adding with lead and trail space as expected");
        }
    }  

    @Test
    public void FM_ERP_AddCluster_15() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(1000);
        String passError = cluster.getPassErrorText();
        if(passError.equals(values.Values.EXPECTED_PASS_ERROR)) {
            System.out.println("Pass amount error message is displayed as expected: "+passError);
        } else {
            Assert.fail("Pass amount error message is not displayed as expected, actual message: "+passError);
        }
    }  

    @Test
    public void FM_ERP_AddCluster_16() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.DECIMAL_PASS_AMOUNT);
        Thread.sleep(1000);
        if(cluster.addCluster_passTextfield.inputValue().equals(values.Values.DECIMAL_PASS_AMOUNT))  {
            System.out.println("Decimal pass amount entered successfully in Add Cluster window");
        } else {
            Assert.fail("Pass amount not entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    } 

    @Test
    public void FM_ERP_AddCluster_17() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.NEGATIVE_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.NEGATIVE_PASS_AMOUNT))  {
            System.out.println("Negative pass amount is not entered successfully in Add Cluster window");
        } else {
            Assert.fail("Negative pass amount entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    } 

    @Test
    public void FM_ERP_AddCluster_18() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.SPECIAL_CHAR_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.SPECIAL_CHAR_PASS_AMOUNT))  {
            System.out.println("Special character pass amount is not entered successfully in Add Cluster window");
        } else {
            Assert.fail("Special character pass amount entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    } 

    //Not needed
    public void FM_ERP_AddCluster_19() throws InterruptedException {
      
    } 

    @Test
    public void FM_ERP_AddCluster_20() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        String randomClusterName = values.Values.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.EMOJI_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.EMOJI_PASS_AMOUNT))  {
            System.out.println("Emoji pass amount is not entered successfully in Add Cluster window");
        } else {
            Assert.fail("Emoji pass amount entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
    } 

    @Test
    public void FM_ERP_AddCluster_21() throws InterruptedException {
       locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        Thread.sleep(1000);
        if(cluster.addCluster_saveButton.isEnabled())  {
            Assert.fail("Save button is NOT enabled for empty cluster name");
        } else {
            System.out.println("Save button is enabled when empty cluster name"); 
        }
    }



    
    public void FM_ERP_AddCluster_100() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        dash.clickClusterTab();
        cluster.clickAddClusterButton();
        String randomClusterName = cluster.randomClusterName();
        cluster.enterClusterName(randomClusterName);
        cluster.clickAddClusterSaveButton();
        cluster.enterClusterSearch(randomClusterName);

    if (cluster.isClusterVisible(randomClusterName)) {
        System.out.println("Cluster found");
    } else {
     Assert.fail("Cluster not found after adding");
    }

    //delete for future tests
    cluster.clickDeleteClusterButton();
    
    }

}
