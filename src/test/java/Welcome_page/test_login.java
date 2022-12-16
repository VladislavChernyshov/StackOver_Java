package Welcome_page;

import Base.BaseTest;
import org.testng.annotations.Test;

import static constants.Constant.Urls.Stack_Overflow_page;

public class test_login extends BaseTest {
    @Test
    public void Auth() {
        basePage.open(Stack_Overflow_page);
        Stack_homepage_login.Auth();
    }
    @Test
    public void IncorrectMessage() {
        basePage.open(Stack_Overflow_page);
        Stack_homepage_login.IncorrectMessage();
    }
}
