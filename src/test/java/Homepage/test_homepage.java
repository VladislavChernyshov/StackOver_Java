package Homepage;

import Base.BaseTest;
import org.testng.annotations.Test;

import static constants.Constant.Urls.Stack_Overflow_page;

public class test_homepage extends BaseTest {

    @Test
    public void CheckOpenPage() {

            basePage.open(Stack_Overflow_page);
            System.out.println("Page open");
    }
    }
