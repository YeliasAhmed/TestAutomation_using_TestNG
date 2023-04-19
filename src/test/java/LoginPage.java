import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LoginPage {
    @FindBy(className="login")
    WebElement signIn;

    @FindBy(id="email")
    WebElement username;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(name="SubmitLogin")
    WebElement login;

    @FindBy(className = "logout")
    WebElement logout;
    @FindBy(className = "header_user_info")
   List<WebElement> user;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void  getAccount() {
        signIn.click();
    }

    public void getUsername(){
        username.sendKeys("abc@test.com");
    }
    public void getPassword(){
        password.sendKeys("12345");
    }
    public void getLogin(){
        login.click();

    }
    public void getLogout(){
        logout.isDisplayed();

    }
    public String getUser(){
       return user.get(0).getText();

    }


}
