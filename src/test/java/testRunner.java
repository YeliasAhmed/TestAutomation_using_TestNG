import org.testng.annotations.Test;

public class testRunner extends Base{

    @Test
    public void loginDisplay(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        loginPage.getAccount();
        loginPage.getUsername();
        loginPage.getPassword();
        loginPage.getLogin();
        loginPage.getLogout();
        System.out.println(loginPage.getUser());
    }
}
