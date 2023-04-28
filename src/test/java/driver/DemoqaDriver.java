package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoqaDriver {
    private static DemoqaDriver instance;
    private WebDriver driver;
    public DemoqaDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static synchronized DemoqaDriver getInstance() {
        if (instance == null) {
            instance = new DemoqaDriver();
        }
        return instance;
    }
    public WebDriver getWebDriver(){return driver;}

    public static void main(String[] args)  {
        System.out.println(DemoqaDriver.getInstance().getWebDriver().toString());
        System.out.println(DemoqaDriver.getInstance().toString());
    }
}
