package cluster;

import java.util.Random;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ClusterLocators {
     
    private Page page;

    //cluster page locators
    Locator clusterPage_title;
    private Locator clusterPage_searchbar;
    private Locator clusterPage_addClusterButton;
    private Locator clusterPage_editClusterButton;
    private static Locator clusterPage_deleteClusterButton;

    //bus scheduler page locators
    private Locator busSchedulePage_ClusterTab;
    private Locator busSchedulePage_RouteTab; 
    private Locator busSchedulePage_VehicleTab;
    
    //add cluster locators
    private static Locator addCluster_title;
    private static Locator addCluster_textfield;
    static Locator addCluster_saveButton;
    private static Locator addCluster_closeButton;
    private static Locator addCluster_cancelButton;
    private static Locator addCluster_enablePassCheckbox;
    static Locator addCluster_passTextfield;
    private static Locator passErrorText;

   //edit cluster locators
    private static Locator editCluster_title;
    static Locator editCluster_textfield;
    static Locator editCluster_saveButton;
    private static Locator editCluster_closeButton;
    private static Locator editCluster_cancelButton;
    private static Locator editCluster_enablePassCheckbox;
    static Locator editCluster_passTextfield;

    //delete
    private static Locator deleteClusterButton;


    public ClusterLocators(Page page) {
        this.page = page;

        //tabs
        this.busSchedulePage_ClusterTab = page.locator("//button[text()='Cluster']");
        this.busSchedulePage_RouteTab = page.locator("//button[text()='Route']");
        this.busSchedulePage_VehicleTab = page.locator("//button[text()='Vehicle']");

        //cluster page locators
        this.clusterPage_title = page.locator("//h2[@class='cluster-title']");
        this.clusterPage_searchbar = page.locator("//input[@class='cluster-search-input']");
        this.clusterPage_addClusterButton = page.locator("//button[@class='cluster-create-button']");
        this.clusterPage_editClusterButton = page.locator("//button[@title='Edit cluster']");
        this.clusterPage_deleteClusterButton = page.locator("//button[@title='Delete cluster']/*[name()='svg']");
   
        //add cluster locators
        this.addCluster_title = page.locator("//h2[text()='Create Cluster']");
        this.addCluster_textfield = page.locator("//input[@placeholder='Enter cluster name']");
        this.addCluster_saveButton = page.locator("//button[text()='Create']");
        this.addCluster_closeButton = page.locator("//button[@class='popup-close-btn']");
        this.addCluster_cancelButton = page.locator("//button[text()='Cancel']");
        this.addCluster_enablePassCheckbox = page.locator("//input[@type='checkbox']");    
        this.addCluster_passTextfield = page.locator("//input[@placeholder='Enter Pass Price']");
        this.passErrorText = page.locator("//div[@class='popup-error']");

      //edit cluster locators
        this.editCluster_title = page.locator("//h2[text()='Edit Cluster']");
        this.editCluster_textfield = page.locator("//input[@placeholder='Enter cluster name']");
        this.editCluster_saveButton = page.locator("//button[contains(@class,'popup-create-btn') and text()='Update']");
        this.editCluster_closeButton = page.locator("//button[contains(@class,'popup-close-btn')]");
        this.editCluster_cancelButton = page.locator("//button[contains(@class,'popup-cancel-btn') and text()='Cancel']");
        this.editCluster_enablePassCheckbox = page.locator("//input[@type='checkbox' and contains(@class,'popup-checkbox')]");    
        this.editCluster_passTextfield = page.locator("//input[@placeholder='Enter Pass Price']");
    
        //delete cluster locators
        this.deleteClusterButton = page.locator("//button[@title='Delete cluster']"); //
                //  : //button[.//svg//*[contains(@d,'M2 4H14')]] : //svg/path[contains(@d,'M2 4H14')]/ancestor::button
    
    }


//tabs methods
    public void clickClusterTab()  throws InterruptedException{
        busSchedulePage_ClusterTab.click();
        System.out.println("Clicked on Cluster tab in Bus Schedule page");
        Thread.sleep(1000);
    }
    public void clickRouteTab()  throws InterruptedException{
        busSchedulePage_RouteTab.click();
        System.out.println("Clicked on Route tab in Bus Schedule page");
        Thread.sleep(1000);
    }
    public void clickVehicleTab()  throws InterruptedException{
        busSchedulePage_VehicleTab.click();
        System.out.println("Clicked on Vehicle tab in Bus Schedule page");
        Thread.sleep(1000);
    }


//search cluster
    public void enterClusterSearch(String clusterName) throws InterruptedException {
        clusterPage_searchbar.fill(clusterName);
        System.out.println("Entered cluster name in search bar: " + clusterName);
        Thread.sleep(1000);
    }

    public boolean isClusterVisible(String clusterName) {
        String xpath = "//span[text()='" + clusterName + "']";
        return page.locator(xpath).isVisible();
    }


















    //Add cluster methods
    public void clickAddClusterButton() {
        clusterPage_addClusterButton.click();
        System.out.println("Clicked on Add Cluster button");
    }   

    public boolean isAddClusterWindowVisible() {
        return addCluster_title.isVisible();
    }


    public void enterClusterName(String clusterName) throws InterruptedException {
        addCluster_textfield.click();
        addCluster_textfield.clear();
        addCluster_textfield.fill(clusterName);
        System.out.println("Entered cluster name: " + clusterName);
        Thread.sleep(1000);
    }
    public void clickAddClusterSaveButton()  throws InterruptedException{
        addCluster_saveButton.click();
        System.out.println("Clicked on Save button in Add Cluster window");
        Thread.sleep(1000);
    }
    public void clickAddClusterCloseButton()  throws InterruptedException{
        addCluster_closeButton.click();
        System.out.println("Clicked on Close button in Add Cluster window");
        Thread.sleep(1000);
    }
    public void clickAddClusterCancelButton()  throws InterruptedException{
        addCluster_cancelButton.click();
        System.out.println("Clicked on Cancel button in Add Cluster window");
        Thread.sleep(1000);
    }
    public void enableAddClusterPass()  throws InterruptedException{
        addCluster_enablePassCheckbox.check();
        System.out.println("Enabled Pass option field in Add Cluster window");
        Thread.sleep(1000);
    }
    public void enterAddClusterPassAmount(String passAmount) throws InterruptedException {
        addCluster_passTextfield.fill(passAmount);
        System.out.println("Entered pass amount in Add Cluster window");
        Thread.sleep(1000);
    }
    public String getPassErrorText() {
        return passErrorText.textContent();
    }

//Edit cluster methods
public void clickEditClusterButton() throws InterruptedException {
    clusterPage_editClusterButton.click();
    System.out.println("Clicked on Edit Cluster button");
        Thread.sleep(1000);
}

public boolean isEditClusterWindowVisible() {
    return editCluster_title.isVisible();
}

public void enterEditClusterName(String clusterName) throws InterruptedException {
    editCluster_textfield.click();
    editCluster_textfield.clear();
    editCluster_textfield.fill(clusterName);
    System.out.println("Entered cluster name in Edit Cluster window: " + clusterName);
    Thread.sleep(1000);
}

public void clickEditClusterSaveButton()  throws InterruptedException{
    editCluster_saveButton.click();
    System.out.println("Clicked on Save button in Edit Cluster window");
    Thread.sleep(1000);
}

public void clickEditClusterCloseButton()  throws InterruptedException{
    editCluster_closeButton.click();
    System.out.println("Clicked on Close button in Edit Cluster window");
    Thread.sleep(1000);
}

public void clickEditClusterCancelButton()  throws InterruptedException{
    editCluster_closeButton.click();
    System.out.println("Clicked on Close button in Edit Cluster window");
    Thread.sleep(1000);
    }

public void enterEditClusterPassAmount(String passAmount) throws InterruptedException {
        editCluster_passTextfield.click();
        editCluster_passTextfield.clear();
        editCluster_passTextfield.fill(passAmount);
        System.out.println("Entered pass amount in Edit Cluster window");
        Thread.sleep(1000);
    }


    //delete cluster methods
    public void clickDeleteClusterButton() throws InterruptedException {
        Thread.sleep(1000);
        clusterPage_deleteClusterButton.click();
        System.out.println("Clicked on Delete Cluster button");
        Thread.sleep(2000);
    }

    public void clickOKdeleteAltert() throws InterruptedException {
        Thread.sleep(1000);
        page.onDialog(dialog -> {
        System.out.println(dialog.message());
        dialog.accept();
    });
        System.out.println("Clicked OK on delete alert");
        Thread.sleep(1000);
    }

    public void clickCanceldeleteAltert() throws InterruptedException {
   page.onceDialog(dialog -> {
        System.out.println("Alert dismissed: " + dialog.message());
        dialog.dismiss();
    });
        System.out.println("Clicked Cancel on delete alert");
        Thread.sleep(1000);
    }


    // Generate random cluster name
public static String randomClusterName() {
    String prefix = "cluster";
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder result = new StringBuilder(prefix);
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
        result.append(characters.charAt(random.nextInt(characters.length())));
    }
    return result.toString();
}



}