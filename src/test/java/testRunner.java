import org.testng.annotations.Test;

public class testRunner extends Base{

    @Test
    public void userRegistration(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.pl/");
        int id =(int)(Math.random()*(1000-1)+1);
        String email = "abcd"+id+"@test.com";
        String pass = "12345";
        loginPage.getNewAccount(email, pass);

    }

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
