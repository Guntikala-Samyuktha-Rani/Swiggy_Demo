package in.swiggy.teststeps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeAfter {
    protected static ChromeDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver before each scenario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // Quit WebDriver after each scenario
        if (driver != null) {
            driver.quit();
        }
    }
}


