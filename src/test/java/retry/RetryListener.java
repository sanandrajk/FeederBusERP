package retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

// public class RetryListener implements IRetryAnalyzer {

//     int count = 0;
//     int maxRetryCount = 1;   // Retry 2 times (Total run = 1 + 2 retries)

//     @Override
//     public boolean retry(ITestResult result) {
//         System.out.println("Retrying test " + result.getName() + " for the " + (count+1) + " time(s).");
//         if (count < maxRetryCount) {
//             count++;
//             return true;
//         }
//         return false;
//     }

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}



