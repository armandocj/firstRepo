package framework;

import framework.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected Log LOG;

    public void setupDriver(){
        LOG.info("Setting up chrome driver");
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    protected void launchWebPage(String url){
        LOG.info("Open url: " + url);
        driver.get(url);
        driver.manage().window().maximize();
    }

}
