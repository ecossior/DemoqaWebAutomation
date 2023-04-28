package step.definitions;

import driver.DemoqaDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public static void SetupDriver(){
        DemoqaDriver.getInstance();
    }

    @After
    public static void tearDown(){
        DemoqaDriver.getInstance().getWebDriver().manage().deleteAllCookies();
        DemoqaDriver.getInstance().getWebDriver().close();
    }
}
