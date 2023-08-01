package in.swiggy.teststeps;

import org.openqa.selenium.chrome.ChromeDriver;
import in.swiggy.pages.SwiggyMain;

public class Driver {
    protected static ChromeDriver driver;
    protected static SwiggyMain swiggyMain;

    public static void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com");
        swiggyMain = new SwiggyMain();
    }

    public static void closeDriver() {
        driver.quit();
    }
}










