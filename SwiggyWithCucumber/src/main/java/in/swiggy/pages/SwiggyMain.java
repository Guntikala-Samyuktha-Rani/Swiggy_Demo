package in.swiggy.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwiggyMain {
    private WebDriver driver;

    public SwiggyMain() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/");
    }

    public void enterDeliveryLocation(String location) {
        WebElement enterYourDeliveryLocation = driver.findElement(By.xpath("//input[@placeholder='Enter your delivery location']"));
        enterYourDeliveryLocation.sendKeys(location);
        try {
            Thread.sleep(2000);
            enterYourDeliveryLocation.sendKeys(Keys.ARROW_DOWN);
            enterYourDeliveryLocation.sendKeys(Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectRestaurant() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstRestaurant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@alt,'Taj Mahal-Abids')])[1]")));
        firstRestaurant.click();
    }

    public void selectFirstDish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstDish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'_1RPOp')])[1]")));
        firstDish.click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'_1RPOp')])[1]")));

        // Use JavascriptExecutor to click the "Add to Cart" button directly
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", addToCartButton);

        try {
            Thread.sleep(2000); // Wait for the cart to update
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).perform();

        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'_55uP6')]")));
        checkoutButton.click();
        try {
            Thread.sleep(2000); // Wait for the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyLoginSignUpMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verifyTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'To place your order now, log in to your existing account or sign up.')]")));
        if (verifyTextElement.isDisplayed()) {
            System.out.println("Verification successful! Text is visible on the next page.");
        } else {
            System.out.println("Verification failed! Text is not visible on the next page.");
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        SwiggyMain swiggyMain = new SwiggyMain();
        swiggyMain.enterDeliveryLocation("Hyderabad");
        swiggyMain.selectRestaurant();
        swiggyMain.selectFirstDish();
        swiggyMain.addToCart();
        swiggyMain.clickCheckout();
        swiggyMain.verifyLoginSignUpMessage();
        swiggyMain.closeBrowser();
    }
}

