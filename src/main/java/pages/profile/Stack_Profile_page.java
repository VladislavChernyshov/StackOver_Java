package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class Stack_Profile_page extends BasePage {

    public Stack_Profile_page(WebDriver driver) {
        super(driver);
    }

    private final By PROFILE_AVATAR = By.xpath("/html/body/header/div/nav/ol/li[2]/a/div[1]/img");
    private final By EDIT_PROFILE_BTN = (By.xpath("//*[@id=\"mainbar-full\"]/div[1]/div[2]/a"));
    private final By PROFILE_DISPLAY_NAME = (By.id("displayName"));
    private final By PROFILE_LOCATION = (By.id("location"));
    private final By PROFILE_TITLE = (By.id("Title"));
    private final By PROFILE_ABOUT_ME = (By.id("wmd-input"));
    private final By PROFILE_WEB_SITE_LINK = (By.id("WebsiteUrl"));
    private final By PROFILE_TWITTER_LINK = (By.id("TwitterUrl"));
    private final By PROFILE_GIT_HUB = (By.id("GitHubUrl"));
    private final By PROFILE_FULL_NAME = (By.id("RealName"));
    private final By PROFILE_SAVE_BUTTON = (By.xpath("//*[@id=\"form-submit\"]/div/button"));
    private final By PROFILE_CANCEL_BUTTON = (By.id("cancel"));

    Random random = new Random(); // добавление рандомных чисел
    int n = random.nextInt(1000) +3; // +3 в конец


    public Stack_Profile_page OpenProfile() {
        driver.findElement(PROFILE_AVATAR).click();
        return this;
    }

    public Stack_Profile_page EditProfile() throws InterruptedException {
        driver.findElement(EDIT_PROFILE_BTN).click();
        driver.findElement(PROFILE_LOCATION).sendKeys((Keys.COMMAND + "a" + Keys.DELETE));
        driver.findElement(PROFILE_LOCATION).sendKeys("Selenium" +n);
        driver.findElement(PROFILE_TITLE).sendKeys((Keys.COMMAND + "a" + Keys.DELETE));
        driver.findElement(PROFILE_TITLE).sendKeys("Write Selenium test" +n);
        driver.findElement(PROFILE_ABOUT_ME).sendKeys((Keys.COMMAND + "a" + Keys.DELETE));
        driver.findElement(PROFILE_ABOUT_ME).sendKeys("About me testcase" +n);
        driver.findElement(PROFILE_WEB_SITE_LINK).sendKeys((Keys.COMMAND + "a" + Keys.DELETE));
        driver.findElement(PROFILE_WEB_SITE_LINK).sendKeys("google.com");
        driver.findElement(PROFILE_FULL_NAME).sendKeys((Keys.COMMAND + "a" + Keys.DELETE));
        driver.findElement(PROFILE_FULL_NAME).sendKeys("Auto Test Selenium Java" +n);
        driver.findElement(PROFILE_SAVE_BUTTON).click();
        Thread.sleep(5000);
        driver.findElement(PROFILE_SAVE_BUTTON).click();
        String title = driver.findElement(By.xpath("//*[@id=\"mainbar-full\"]/div[1]/div[1]/div/div[2]")).getText();
        assertTrue(title.contains("Write Selenium test" +n));
        System.out.println(title);


        return this;
    }
}
