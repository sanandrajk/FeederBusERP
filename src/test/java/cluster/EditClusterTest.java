package cluster;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import beforeMethod.SetupBrowser;
import dashboard.DashboardLocators;
import login.LoginLocators;

public class EditClusterTest extends SetupBrowser {
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
    public void FM_ERP_EditCluster_1() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(2000);
        cluster.enterClusterSearch(values.Values.EDIT_ALREADY_EXISTING_CLUSTER_NAME);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        if (cluster.isEditClusterWindowVisible()) {
            System.out.println("Edit Cluster window is displayed");
        } else {
            Assert.fail("Edit Cluster window is NOT displayed");
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_1: " + e.getMessage());
        }
    }
    
    @Test
    public void FM_ERP_EditCluster_2() throws InterruptedException {
       try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(newClusterName+"Edited");
        cluster.clickEditClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName+"Edited");
        Thread.sleep(2000);
        if (cluster.isClusterVisible(newClusterName+"Edited")) {
            System.out.println("Cluster name edited successfully to: " + newClusterName+"Edited");
        } else {
            Assert.fail("Cluster name edit failed for: " + newClusterName+"Edited");    
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_2: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_3() throws InterruptedException  {
       try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(values.Values.INTEGER_CLUSTER_NAME);
        
        if (!cluster.editCluster_textfield.inputValue().equals(values.Values.INTEGER_CLUSTER_NAME)) {
           Assert.fail("Cluster name edited to Number: " + values.Values.INTEGER_CLUSTER_NAME);
        } else {
            System.out.println("Cluster name is not supporting numbers" + values.Values.INTEGER_CLUSTER_NAME);   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_3: " + e.getMessage());
        }
    }   

    @Test
    public void FM_ERP_EditCluster_4() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(values.Values.SPECIAL_CHAR_CLUSTER_NAME);
        
        if (!cluster.editCluster_textfield.inputValue().equals(values.Values.SPECIAL_CHAR_CLUSTER_NAME)) {
           Assert.fail("Cluster name edited to Special Characters: " + values.Values.SPECIAL_CHAR_CLUSTER_NAME);
        } else {
            System.out.println("Cluster name is not supporting Special Characters" + values.Values.SPECIAL_CHAR_CLUSTER_NAME);   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_4: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_5() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        if(cluster.isAddClusterWindowVisible()) {
            System.out.println("Pass Amount field is displayed upon enabling Pass option in Edit Cluster window");
        } else {
            Assert.fail("Pass Amount field is NOT displayed upon enabling Pass option in Edit Cluster window");
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_5: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_6() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        cluster.enterEditClusterPassAmount(values.Values.VALID_PASS_AMOUNT);
        cluster.clickEditClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        if(cluster.editCluster_passTextfield.inputValue().equals(values.Values.VALID_PASS_AMOUNT)) {
            System.out.println("Pass Amount edited successfully to: " + values.Values.VALID_PASS_AMOUNT);
        } else {
            Assert.fail("Pass Amount edit failed for: " + values.Values.VALID_PASS_AMOUNT);
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_6: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_6_1() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        cluster.enterEditClusterPassAmount(values.Values.CHAR_PASS_AMOUNT);
        if(!cluster.editCluster_passTextfield.inputValue().equals(values.Values.CHAR_PASS_AMOUNT)) {
            System.out.println("Pass Amount field is NOT accepting invalid input: " + values.Values.CHAR_PASS_AMOUNT);
        } else {
            Assert.fail("Pass Amount field is accepting invalid input: " + values.Values.CHAR_PASS_AMOUNT);  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_6_1: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_6_2() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        cluster.enterEditClusterPassAmount(values.Values.SPECIAL_CHAR_PASS_AMOUNT);
        if(!cluster.editCluster_passTextfield.inputValue().equals(values.Values.SPECIAL_CHAR_PASS_AMOUNT)) {
            System.out.println("Pass Amount field is NOT accepting invalid input: " + values.Values.SPECIAL_CHAR_PASS_AMOUNT);
        } else {
            Assert.fail("Pass Amount field is accepting invalid input: " + values.Values.SPECIAL_CHAR_PASS_AMOUNT);  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_6_1: " + e.getMessage());
        }
    }



@Test
    public void FM_ERP_EditCluster_7() throws InterruptedException {
       try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        cluster.enterEditClusterPassAmount(values.Values.VALID_PASS_AMOUNT);
        if(cluster.editCluster_passTextfield.inputValue().equals(values.Values.VALID_PASS_AMOUNT)) {
            System.out.println("Pass Amount field is  accepting valid input: " + values.Values.VALID_PASS_AMOUNT);
        } else {
            Assert.fail("Pass Amount field is not accepting valid input: " + values.Values.VALID_PASS_AMOUNT);  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_7: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_8() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        String newClusterName2 = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterEditClusterName(newClusterName2);
        cluster.clickEditClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName2);
        Thread.sleep(2000); 
        if (cluster.isClusterVisible(newClusterName2)) {
            System.out.println("Cluster name edited successfully to: " + newClusterName2);
        } else {
            Assert.fail("Cluster name edit failed for: " + newClusterName2);   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_8: " + e.getMessage());
        }
    }       

    @Test
    public void FM_ERP_EditCluster_9() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        if(cluster.editCluster_saveButton.isEnabled()) {
            System.out.println("Save button is enabled with out updated inputs");
        } else {
            Assert.fail("Save button is enabled with out updated inputs");  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_9: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_10() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.clickEditClusterCancelButton();
        Thread.sleep(2000);
        if(cluster.clusterPage_title.isVisible()) {
            System.out.println("Edit Cluster cancelled successfully, cluster details unchanged");
        } else {
            Assert.fail("Edit Cluster cancel failed, cluster details changed");  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_10: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_11() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.clickEditClusterCloseButton();
        Thread.sleep(2000);
        if(cluster.clusterPage_title.isVisible()) {
            System.out.println("Edit Cluster cancelled successfully, cluster details unchanged");
        } else {
            Assert.fail("Edit Cluster cancel failed, cluster details changed");  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_11: " + e.getMessage());
        }
    }
    

@Test
    public void FM_ERP_EditCluster_12() throws InterruptedException {
       try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(values.Values.SPACE_CLUSTER_NAME);
         if(!cluster.editCluster_saveButton.isEnabled()) {
            System.out.println("Save button is not enabled with  updated inputs");
        } else {
            Assert.fail("Save button is enabled with updated inputs");  
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_12: " + e.getMessage());
        }
    }

    @Test
    public void FM_ERP_EditCluster_13() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(values.Values.LONG_CLUSTER_NAME);
        if (cluster.isClusterVisible(values.Values.LONG_CLUSTER_NAME)) {
            System.out.println("Cluster found");    } else {
            Assert.fail("Cluster not found after adding");
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_13: " + e.getMessage());
        }
    }

@Test
    public void FM_ERP_EditCluster_14() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enterEditClusterName(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME);
        cluster.clickEditClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME);
    if (!cluster.isClusterVisible(values.Values.LEAD_AND_TRAIL_SPACE_CLUSTER_NAME)) {
       Assert.fail("Cluster found with lead and trail space");    } else {
     System.out.println("Cluster not found after adding with lead and trail space as expected");
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_14: " + e.getMessage());
        }
    }
@Test
    public void FM_ERP_EditCluster_15() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        cluster.clickEditClusterSaveButton();
        Thread.sleep(1000);
        String passError = cluster.getPassErrorText();
        if(passError.equals(values.Values.EXPECTED_PASS_ERROR)) {
            System.out.println("Pass amount error message is displayed as expected: "+passError);
        } else {
            Assert.fail("Pass amount error message is not displayed as expected, actual message: "+passError);
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_15: " + e.getMessage());
        }
    }
@Test
    public void FM_ERP_EditCluster_16() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.DECIMAL_PASS_AMOUNT);
        Thread.sleep(1000);
        cluster.clickEditClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        if(cluster.addCluster_passTextfield.inputValue().equals(values.Values.DECIMAL_PASS_AMOUNT))  {
            System.out.println("Decimal pass amount entered successfully in Edit Cluster window");
        } else {
            Assert.fail("Pass amount not entered in Edit Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_16: " + e.getMessage());
        }
    }


    @Test
    public void FM_ERP_EditCluster_17() throws InterruptedException {
        try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.NEGATIVE_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.editCluster_passTextfield.inputValue().equals(values.Values.NEGATIVE_PASS_AMOUNT))  {
            System.out.println("Negative pass amount not accepted in Edit Cluster window");
        } else {
            Assert.fail("Negative pass amount  accepted in Edit Cluster window"+cluster.editCluster_passTextfield.inputValue());   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_17: " + e.getMessage());
        }
    }

@Test
public void FM_ERP_EditCluster_18() throws InterruptedException {
          try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.SPECIAL_CHAR_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.addCluster_passTextfield.inputValue().equals(values.Values.SPECIAL_CHAR_PASS_AMOUNT))  {
            System.out.println("Special character pass amount is not entered successfully in Add Cluster window");
        } else {
            Assert.fail("Special character pass amount entered in Add Cluster window"+cluster.addCluster_passTextfield.inputValue());   
        }}catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_18: " + e.getMessage());
        }
    }
//not needed
    public void FM_ERP_EditCluster_19() throws InterruptedException {
    }
         
@Test
public void FM_ERP_EditCluster_20() throws InterruptedException {
    try{
        login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        login.clickLoginButton();   
        dash.clickClusterTab();
        Thread.sleep(1000);
        cluster.clickAddClusterButton();
        String newClusterName = values.Values.EDIT_CLUSTER_NAME;
        cluster.enterClusterName(newClusterName);
        cluster.clickAddClusterSaveButton();
        Thread.sleep(2000);
        cluster.enterClusterSearch(newClusterName);
        Thread.sleep(2000);
        cluster.clickEditClusterButton();
        Thread.sleep(1000);
        cluster.enableAddClusterPass();
        Thread.sleep(1000);
        cluster.enterAddClusterPassAmount(values.Values.EMOJI_PASS_AMOUNT);
        Thread.sleep(1000);
        if(!cluster.editCluster_passTextfield.inputValue().equals(values.Values.EMOJI_PASS_AMOUNT))  {
            System.out.println("Emoji pass amount not accepted in Edit Cluster window");
        } else {
            Assert.fail("Emoji pass amount  accepted in Edit Cluster window"+cluster.editCluster_passTextfield.inputValue());   
        }
        }catch(Exception e){
            Assert.fail("Exception in FM_ERP_EditCluster_18: " + e.getMessage());
        }
    }
    }
