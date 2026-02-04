package dashboard;

import com.microsoft.playwright.*;

import login.LoginLocators;

import org.testng.annotations.*;
import java.util.Map;
import static org.testng.Assert.assertEquals;

public class DashboardTest extends beforeMethod.SetupBrowser {
    
  //  private Page page;
    APIRequestContext apiContext;   
    Playwright playwright;
    Browser browser;

    private LoginLocators login;
    private DashboardLocators dash;

    @BeforeMethod
    public void init() {
        login = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
    }


//@Test //Sample test to verify API is working
public void verifyAPIIsWorking() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    APIResponse response = apiContext.get("dashboard/revenue?from_date=2026-01-08&to_date=2026-01-08");
    assertEquals(response.status(), 200);
}

@AfterMethod(alwaysRun = true)
public void logoutAfterTest() throws InterruptedException {
    Thread.sleep(1000);
    dash.clickLogoutButton();
    Thread.sleep(1000);
}

//--------------------------------- TODAY : REVENUE -----------------------------------------
@Test
public void checkTodayTotalRevenueFromDashboard_FB_ERP_Dash_1() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("total_revenue", dash.dash_total_revenue, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalCashRevenueFromDashboard_FB_ERP_Dash_2() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    //dash.selectPastOneMonthDataFromCalendar();
    //Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CASH", dash.dash_total_cash_revenue, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalUPIRevenueFromDashboard_FB_ERP_Dash_3() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    //dash.selectPastOneMonthDataFromCalendar();
    //Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "UPI", dash.dash_total_upi_revenue, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalCardRevenueFromDashboard_FB_ERP_Dash_4() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    //dash.selectPastOneMonthDataFromCalendar();
    //Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CARD", dash.dash_total_card_revenue, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalPassRevenueFromDashboard_FB_ERP_Dash_5() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("issued_pass_amount", dash.dash_total_pass_revenue, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalPassCashRevenueFromDashboard_FB_ERP_Dash_6() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CASH", dash.dash_pass_revenue_cash, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalPassUPIRevenueFromDashboard_FB_ERP_Dash_7() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "UPI", dash.dash_pass_revenue_upi, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalPassCardRevenueFromDashboard_FB_ERP_Dash_8() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CARD", dash.dash_pass_revenue_card, values.Values.getDashboardRevenueEndpointForToday());
}

//--------------------------------- PAST ONE WEEK : REVENUE -----------------------------------------
@Test
public void checkOneWeekRevenueFromDashboard_FB_ERP_Dash_9() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_revenue", dash.dash_total_revenue, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalCashRevenueFromDashboard_FB_ERP_Dash_10() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CASH", dash.dash_total_cash_revenue, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalUPIRevenueFromDashboard_FB_ERP_Dash_11() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "UPI", dash.dash_total_upi_revenue, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalCardRevenueFromDashboard_FB_ERP_Dash_12() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CARD", dash.dash_total_card_revenue, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalPassRevenueFromDashboard_FB_ERP_Dash_13() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("issued_pass_amount", dash.dash_total_pass_revenue, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalPassCashRevenueFromDashboard_FB_ERP_Dash_14() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CASH", dash.dash_pass_revenue_cash, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalPassUPIRevenueFromDashboard_FB_ERP_Dash_15() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "UPI", dash.dash_pass_revenue_upi, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalPassCardRevenueFromDashboard_FB_ERP_Dash_16() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CARD", dash.dash_pass_revenue_card, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

//--------------------------------- PAST ONE MONTH : REVENUE-----------------------------------------
@Test
public void checkOneMonthRevenueFromDashboard_FB_ERP_Dash_17() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_revenue", dash.dash_total_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalCashRevenueFromDashboard_FB_ERP_Dash_18() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CASH", dash.dash_total_cash_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalUPIRevenueFromDashboard_FB_ERP_Dash_19() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "UPI", dash.dash_total_upi_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalCardRevenueFromDashboard_FB_ERP_Dash_20() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CARD", dash.dash_total_card_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalPassRevenueFromDashboard_FB_ERP_Dash_21() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("issued_pass_amount", dash.dash_total_pass_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalPassCashRevenueFromDashboard_FB_ERP_Dash_22() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CASH", dash.dash_pass_revenue_cash, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalPassUPIRevenueFromDashboard_FB_ERP_Dash_23() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "UPI", dash.dash_pass_revenue_upi, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalPassCardRevenueFromDashboard_FB_ERP_Dash_24() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_IssuedPassAPI_Detail("amount", "CARD", dash.dash_pass_revenue_card, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}


//--------------------------------- TODAY : TICKETS -----------------------------------------

@Test
public void checkTodayTotalTicketsFromDashboard_FB_ERP_Dash_25() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("total_tickets", dash.dash_total_tickets, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalCashTicketsFromDashboard_FB_ERP_Dash_26() throws InterruptedException {
     login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    // dash.selectPastOneMonthDataFromCalendar();
    // Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CASH", dash.dash_tickets_cash, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalUPITicketsFromDashboard_FB_ERP_Dash_27() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "UPI", dash.dash_tickets_upi, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalCardTicketsFromDashboard_FB_ERP_Dash_28() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CARD", dash.dash_tickets_card, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalPassTicketsFromDashboard_FB_ERP_Dash_29() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "PASS", dash.dash_tickets_card, values.Values.getDashboardRevenueEndpointForToday()); 
}

//--------------------------------- PAST ONE WEEK : TICKETS -----------------------------------------

@Test
public void checkOneWeekTotalTicketsFromDashboard_FB_ERP_Dash_30() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_tickets", dash.dash_total_tickets, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalCashTicketsFromDashboard_FB_ERP_Dash_31() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CASH", dash.dash_tickets_cash, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalUPITicketsFromDashboard_FB_ERP_Dash_32() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "UPI", dash.dash_tickets_upi, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalCardTicketsFromDashboard_FB_ERP_Dash_33() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CARD", dash.dash_tickets_card, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalPassTicketsFromDashboard_FB_ERP_Dash_34() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "PASS", dash.dash_tickets_pass, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

//--------------------------------- PAST ONE MONTH : TICKETS -----------------------------------------

@Test
public void checkOneMonthTotalTicketsFromDashboard_FB_ERP_Dash_35() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_tickets", dash.dash_total_tickets, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalCashTicketsFromDashboard_FB_ERP_Dash_36() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CASH", dash.dash_tickets_cash, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalUPITicketsFromDashboard_FB_ERP_Dash_37() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "UPI", dash.dash_tickets_upi, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalCardTicketsFromDashboard_FB_ERP_Dash_38() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CARD", dash.dash_tickets_card, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalPassTicketsFromDashboard_FB_ERP_Dash_39() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "PASS", dash.dash_tickets_pass, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

//--------------------------------- TODAY : PASSENGERS -----------------------------------------
@Test
public void checkTotaytotalPassengersFromDashboard_FB_ERP_Dash_40() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("total_passengers", dash.dash_total_passengers, values.Values.getDashboardRevenueEndpointForToday());
}

@Test
public void checkTodayTotalMalePassengersFromDashboard_FB_ERP_Dash_41() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "MALE", dash.dash_passenger_male, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalFemalePassengersFromDashboard_FB_ERP_Dash_42() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "FEMALE", dash.dash_passenger_female, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalChildPassengersFromDashboard_FB_ERP_Dash_43() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "CHILD", dash.dash_passenger_child, values.Values.getDashboardRevenueEndpointForToday()); 
}

@Test
public void checkTodayTotalOthersPassengersFromDashboard_FB_ERP_Dash_44() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "OTHERS", dash.dash_passenger_others, values.Values.getDashboardRevenueEndpointForToday()); 
}

//--------------------------------- ONE WEEK : PASSENGERS -----------------------------------------
@Test
public void checkOneWeektotalPassengersFromDashboard_FB_ERP_Dash_45() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_passengers", dash.dash_total_passengers, values.Values.getDashboardRevenueEndpointForPastOneWeek());
}

@Test
public void checkOneWeekTotalMalePassengersFromDashboard_FB_ERP_Dash_46() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "MALE", dash.dash_passenger_male, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalFemalePassengersFromDashboard_FB_ERP_Dash_47() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "FEMALE", dash.dash_passenger_female, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalChildPassengersFromDashboard_FB_ERP_Dash_48() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "CHILD", dash.dash_passenger_child, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

@Test
public void checkOneWeekTotalOthersPassengersFromDashboard_FB_ERP_Dash_49() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneWeekDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "OTHERS", dash.dash_passenger_others, values.Values.getDashboardRevenueEndpointForPastOneWeek()); 
}

//--------------------------------- ONE MONTH : PASSENGERS -----------------------------------------
@Test
public void checkOneMonthTotalPassengersFromDashboard_FB_ERP_Dash_50() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI("total_passengers", dash.dash_total_passengers, values.Values.getDashboardRevenueEndpointForPastOneMonth());
}

@Test
public void checkOneMonthTotalMalePassengersFromDashboard_FB_ERP_Dash_51() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "MALE", dash.dash_passenger_male, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalFemalePassengersFromDashboard_FB_ERP_Dash_52() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "FEMALE", dash.dash_passenger_female, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalChildPassengersFromDashboard_FB_ERP_Dash_53() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "CHILD", dash.dash_passenger_child, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

@Test
public void checkOneMonthTotalOthersPassengersFromDashboard_FB_ERP_Dash_54() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_PassengerAPI_Detail("count", "OTHERS", dash.dash_passenger_others, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

//--------------------------------- LIVE BUSES -----------------------------------------

@Test
public void checkTotalBusesFromDashboard_FB_ERP_Dash_55() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("total_buses", dash.dash_live_buses_total, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

@Test
public void checkLiveBusesFromDashboard_FB_ERP_Dash_56() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("buses_in_operation", dash.dash_live_buses_live, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

@Test
public void checkIdleBusesFromDashboard_FB_ERP_Dash_57() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("buses_idle", dash.dash_live_buses_idle, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

//@Test //Disabled due to data issue
public void checkScheduledTripsFromDashboardFB_ERP_Dash_58_1() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("scheduled_trips", dash.dash_live_buses_scheduledTrips, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

//@Test //Disabled due to data issue
public void checkCompletedTripsFromDashboard_FB_ERP_Dash_58_2() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("completed_trips", dash.dash_live_buses_completedTrips, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);  
}

@Test
public void checkEPKFromDashboard_FB_ERP_Dash_59() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("estimated_performance_per_kilometre", dash.dash_live_buses_epk, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}















//@Test
public void checkTotalTicketsFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("total_tickets", dash.dash_total_tickets, values.Values.getDashboardRevenueEndpointForToday());
}

//@Test
public void checkTotalPassengersFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_revenueAPI("total_passengers", dash.dash_total_passengers, values.Values.getDashboardRevenueEndpointForToday());
}

//@Test
public void checkTotalLiveBusesFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("total_buses", dash.dash_live_buses_total, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

//@Test
public void checkLiveBusesLiveFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("buses_in_operation", dash.dash_live_buses_live, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

//@Test
public void checkIdleBusesFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.checkUIandAPIValues_busStatusAPI("buses_idle", dash.dash_live_buses_idle, values.Values.DASHBOARD_LIVE_BUSES_API_ENDPOINT);
}

//@Test // done
public void checkCashPaymentFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CASH", dash.dash_total_cash_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth()); 
}

//@Test //done
public void checkCardPaymentFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "CARD", dash.dash_total_card_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());    
}

//@Test //done
public void checkUPIPaymentFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "UPI", dash.dash_total_upi_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());    
}

//@Test //Disabled due to data issue
public void checkPassPaymentFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("amount", "PASS", dash.dash_total_pass_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());    
}


public void checkCashTicketCountFromDashboard() throws InterruptedException {
    login.enterLoginEmailid(values.Values.LOGIN_EMAIL_TEST);
    login.enterLoginPassword(values.Values.LOGIN_PASSWORD);
    login.clickLoginButton();
    Thread.sleep(3000);
    dash.selectPastOneMonthDataFromCalendar();
    Thread.sleep(2000);
    dash.checkUIandAPIValues_revenueAPI_Detail("count", "CASH", dash.dash_total_cash_revenue, values.Values.getDashboardRevenueEndpointForPastOneMonth());   

}





}