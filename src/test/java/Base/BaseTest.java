package Base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.profile.Stack_Profile_page;
import pages.stack_homepage.homepage.Stack_Homepage_Search;
import pages.stack_homepage.login.Stack_Homepage_login;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OFF;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected Stack_Homepage_Search Stack_Homepage_Search = new Stack_Homepage_Search(driver);
    protected Stack_Homepage_login Stack_homepage_login = new Stack_Homepage_login(driver);
    protected Stack_Profile_page stack_profile_page = new Stack_Profile_page(driver);

    @AfterTest
    public void clearcookiesandlocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE)
        {
            System.out.println("Start AutoTest, open browser");
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterSuite (alwaysRun = true)
    public void close() {
        if(HOLD_BROWSER_OFF) {
            System.out.println("Stop AutoTest, close browser");
            driver.close();
        }
    }
}
