import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class LoginPage {
    @FindBy(className = "login")
    WebElement signIn;
    @FindBy(id = "email")
    WebElement getEmail;
    @FindBy(id = "passwd")
    WebElement getPassword;
    @FindBy(name = "SubmitLogin")
    WebElement login;
    @FindBy(className = "logout")
    WebElement logout;
    @FindBy(className = "header_user_info")
    List<WebElement> user;


    // Create new account
    @FindBy(id = "email_create")
    WebElement newEmail;
    @FindBy(id = "SubmitCreate")
    WebElement createBtn;
    @FindBy(id = "id_gender1")
    WebElement titleRadioBtn;
    @FindBy(id = "customer_firstname")
    WebElement firstName;
    @FindBy(id = "customer_lastname")
    WebElement lastName;
    @FindBy(id = "days")
    WebElement fDate;
    @FindBy(id = "months")
    WebElement fMonth;
    @FindBy(id = "years")
    WebElement fYear;
    @FindBy(id = "submitAccount")
    WebElement register;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getAccount() {
        signIn.click();
    }

    public void getUsername(String email) {
        getEmail.sendKeys(email);
    }

    public void getPassword(String password) {
        getPassword.sendKeys(password);
    }

    public void getLogin() {
        login.click();

    }

    public void getLogout() {
        logout.click();

    }

    public String getUser() {
        return user.get(0).getText();

    }

// Create New Account

    public void getNewAccount(String email, String pass) {
        signIn.click();
        newEmail.sendKeys(email);
        createBtn.click();
        titleRadioBtn.click();
        firstName.sendKeys("Abul");
        lastName.sendKeys("Khan");
        getPassword.sendKeys(pass);
        Select date = new Select(fDate);
        date.selectByValue("3");
        Select month = new Select(fMonth);
        month.selectByValue("5");
        Select year = new Select(fYear);
        year.selectByValue("1920");
        register.click();



    }


}
