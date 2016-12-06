package soselab.easylearn.client;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import soselab.easylearn.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver CreateDriverAndLogin() throws IOException {
        String url = System.getenv("SELENIUM_URL");
        WebDriver driver;
        try {
            if (url == null) {
                System.setProperty("webdriver.chrome.driver", "/home/bernie/pf/chromedriver");
                driver = new ChromeDriver();
            } else {
                driver = new RemoteWebDriver(new URL(url), DesiredCapabilities.chrome());
            }
            driver.manage().window().setSize(new Dimension(1920, 1000));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            new LoginPage(driver).login("kezwpeccse_1480223702@tfbnw.net", "easylearntest");
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
