package main;

import org.testng.TestNG;

public class Main {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(
            java.util.List.of("E:\\Playwright\\FeederBusERP\\FeederBusERP\\testng.xml")
        );
        testng.run();
    }
}
