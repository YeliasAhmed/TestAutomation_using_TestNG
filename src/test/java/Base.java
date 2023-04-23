import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Base {
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @AfterMethod
    public void screenShot(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            try {
                Utils utils = new Utils(driver);
                utils.takeScreenshot();
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
    @AfterTest
    public void closeDriver(){
//        driver.close();
    }

}
