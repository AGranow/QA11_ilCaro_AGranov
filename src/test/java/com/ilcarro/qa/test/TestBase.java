package com.ilcarro.qa.test;

import com.ilcarro.qa.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start test " + m.getName() + "witch data:  " + Arrays.asList(p));
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    void tearDown() {       //false- не закрывает браузер в конце
        app.stop();
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED : test method "  + result.getMethod().getMethodName());
        }else logger.error("FAILED method " + result.getMethod().getMethodName() + "\n" +
                "Screenshot" + app.getUser().takeScreenshot());

        logger.info("=======================================================================");
    }
}
