package pages.stack_homepage.login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constant.Credantial.*;
import static org.testng.AssertJUnit.assertTrue;

public class Stack_Homepage_login extends BasePage {

    public Stack_Homepage_login(WebDriver driver) {
        super(driver);
    }

    private final By LogInBtn = By.linkText("Log in");
    private final By Email = By.id("email");
    private final By Password = By.id("password");
    private final By EnterButton = By.id("submit-button");


    public Stack_Homepage_login Auth() {

        driver.findElement(LogInBtn).click();
        String Title = driver.getTitle();
        String ExpTitleLogin = "Log In - Stack Overflow";
        Assert.assertEquals(ExpTitleLogin, Title);
        driver.findElement(Email).sendKeys(emailStack);
        driver.findElement(Password).sendKeys(passStack);
        driver.findElement(EnterButton).click();
        String AfterLogin = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/h1")).getText();
        assertTrue(AfterLogin.contains("Top Questions"));
        return this;
    }

    public Stack_Homepage_login IncorrectMessage() {
        driver.findElement(LogInBtn).click();
        String Title = driver.getTitle();
        String ExpTitleLogin = "Log In - Stack Overflow";
        Assert.assertEquals(ExpTitleLogin, Title);
        driver.findElement(Email).sendKeys(emailStack);
        driver.findElement(Password).sendKeys("123123123");
        driver.findElement(EnterButton).click();
        String AfterLoginMessage = driver.findElement(By.cssSelector("p[class='flex--item s-input-message js-error-message ' i]")).getText();
        String EXP = "The email or password is incorrect.";
        Assert.assertEquals(EXP, AfterLoginMessage);
        return this;
    }
}
