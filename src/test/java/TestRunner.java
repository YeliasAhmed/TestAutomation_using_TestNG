import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner extends Base {

    @Test(priority = 1)
    public void userRegistration() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        int id = Utils.randomGenerator(1,1000);
        String email = "abcd" + id + "@test.com";
        String pass = "123" + id;
        loginPage.getNewAccount(email, pass);
        loginPage.getLogout();
        Utils utils = new Utils(driver);
        utils.jsonData(email, pass);

    }

    @Test(priority = 2)
    public void loginDisplay() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        Utils utils = new Utils(driver);
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
    @Test(priority = 3)
    public void invalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        String err=loginPage.getLoginInvalidPassword("abcd448@test.com", "1234");
        Assert.assertTrue(err.contains("Invalid password."));

    }
    @Test(priority = 4)
    public void invalidEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        String err=loginPage.getLoginInvalidEmail("abc@tst.com", "12345");
        Assert.assertTrue(err.contains("Authentication failed."));


    }
}
