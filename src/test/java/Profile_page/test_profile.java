package Profile_page;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.profile.Stack_Profile_page;

import static constants.Constant.Urls.Stack_Overflow_page;

public class test_profile extends BaseTest {
    @Test
    public void EditProfile() throws InterruptedException {
        basePage.open(Stack_Overflow_page);
        Stack_homepage_login.Auth();
        stack_profile_page.OpenProfile();
        stack_profile_page.EditProfile();
        System.out.println("qwe");
    }

}
