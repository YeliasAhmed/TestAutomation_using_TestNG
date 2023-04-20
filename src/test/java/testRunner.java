import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class testRunner extends Base {

    @Test(priority = 1)
    public void userRegistration() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        int id = (int) (Math.random() * (1000 - 1) + 1);
        String email = "abcd" + id + "@test.com";
        String pass = "123" + id;
        loginPage.getNewAccount(email, pass);
        loginPage.getLogout();
        Utils utils = new Utils();
        utils.jsonData(email, pass);

    }

    @Test(priority = 2)
    public void loginDisplay() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        Utils utils = new Utils();
        utils.readData(utils.getLastUser()-1);
        loginPage.getAccount();
        loginPage.getUsername(utils.getEmail());
        Thread.sleep(2000);
        loginPage.getPassword(utils.getPassword());
        Thread.sleep(2000);
        loginPage.getLogin();
        Assert.assertTrue(loginPage.getUser().contains("Abul Khan"));
        loginPage.getLogout();


    }
}
