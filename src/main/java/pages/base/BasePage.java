package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariable.EXPICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementisVisible(WebElement element) {
        new WebDriverWait(driver, EXPICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
