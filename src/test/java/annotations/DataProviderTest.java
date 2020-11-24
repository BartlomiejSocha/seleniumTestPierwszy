package annotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class DataProviderTest {

    @Test(dataProvider = "getData")
    public void firstTest(String username, String password) {
        System.out.println("Test logowania ");
        System.out.println("Username " + username);
        System.out.println("Password " + password);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"test1","test"},{"test2","test2"}};
    }
}
