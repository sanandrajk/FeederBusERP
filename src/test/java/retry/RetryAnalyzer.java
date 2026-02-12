package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 1;
    int maxRetryCount = 1;   // Retry 1 time (Total run = 1 + 1 retry)

    public boolean retry(ITestResult result) {
        System.out.println("Retrying test " + result.getName() + " for the " + (count+1) + " time(s).");
        if (count < maxRetryCount) {
            count++;
            return true;
        }
        return false;
    }
}