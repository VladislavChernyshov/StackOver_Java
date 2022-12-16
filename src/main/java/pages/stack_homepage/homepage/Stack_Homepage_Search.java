package pages.stack_homepage.homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;


import static constants.Constant.Credantial.*;
import static org.testng.AssertJUnit.assertTrue;

public class Stack_Homepage_Search extends BasePage {

    public Stack_Homepage_Search(WebDriver driver) {
        super(driver);
    }

    private final By Search = By.name("q");
    private final By Captcha = By.cssSelector(".recaptcha-checkbox-border");
    private final By FirstField = By.xpath("//*[@id=\"question-summary-10596417\"]/div[2]/h3/a");
    private final By Checkbox = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private final By Cookies = By.xpath("/html/body/div[4]/div/button[1]");

    public Stack_Homepage_Search Stack_Search() {

        driver.findElement(Search).sendKeys(searchrequest);
        driver.findElement(Search).sendKeys(Keys.ENTER);
        driver.findElement(Cookies).click();
        var wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt
                (By.xpath("//iframe[@title='reCAPTCHA']")));
        wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
        driver.findElement(Checkbox).click();
        String SearchResult = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/h1")).getText();
        assertTrue(SearchResult.contains("Search Results"));
        System.out.println(SearchResult + "View");
        return this;
        }
    }

