package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {

    WebDriver driver;
    String url;

    void setDriver() {
        //This sets up the chrome browser with all options. Currently having issues with Headless in IntelliJ
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1400x1200");
        options.addArguments("--disable-extensions");

        //Sets the location of the chrome driver based on the repo as well as headless
        if(System.getProperty("user.dir").equalsIgnoreCase("/home/circleci/repo")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriverLinux");
            options.addArguments("--headless");
        }else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        }
        driver = new ChromeDriver(options);
    }

    WebDriver getDriver() {
        return driver;
    }

    String getUrl() {

        return url;
    }
    void setUrl(String website) {
        url = "https://www.google.com/" + website + "/";
    }
}
