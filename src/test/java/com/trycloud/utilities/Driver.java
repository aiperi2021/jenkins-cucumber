package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;


/**
 * We wanted to have a class with that only return Single object
 * no matter how many time you asked for object
 * so we are creating this class with technic we learned from Singleton pattern
 */
public class Driver {
//    // InheritableThreadLocal  --> this is like a container, bag, pool.
//    // in this pool we can have separate objects for each thread
//    // for each thread, in InheritableThreadLocal we can have separate object for that thread
//    // driver class will provide separate webdriver object per thread
//
//    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
////    private static WebDriver obj ;
//
//    private Driver(){ }
//
//    /**
//     * Return obj with only one WebDriver instance
//     * @return same WebDriver if exists , new one if null
//     */
//    public static WebDriver getDriver(){
//        //read the browser type you want to lunch from properties files
//        String browserName = ConfigReader.read("browser");
//
//        if(driverPool.get() == null){
//
//
//            //according to browser type set up driver correctly
//            switch (browserName.toLowerCase()){
////                case "headless":
////                    WebDriverManager.chromedriver().setup();
////                    obj=new ChromeOptions();
////                    obj.
//                case "chrome" :
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver() );
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver() );
//                    break;
//                case "safari":
//                    WebDriverManager.safaridriver().setup();
//                    driverPool.set(new SafariDriver() );
//                    break;
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driverPool.set(new EdgeDriver() );
//                    break;
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    driverPool.set(new OperaDriver() );
//                    // other browsers omitted
//                    break;
//                default:
//                    driverPool.set(null);
//                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
//            }
////            System.out.println("One and only created for the first time");
//            return driverPool.get();
//        }else{
////            System.out.println("You have it just use existing one");
//            return driverPool.get();
//
//        }
//
//    }
//
//    /**
//     * Quitting the browser and setting the value of
//     * WebDriver instance to null because you can re-use already quitted driver
//     */
//    public static void closeBrowser(){
//        // check if we have WebDriver instance or not
//        // basically checking if obj is null or not
//        // if not null
//        // quit the browser
//        // make it null , because once quit it can not be used
//        if( driverPool.get() != null ){
//            driverPool.get().quit();
//            // so when ask for it again , it gives us not quited fresh driver
//            driverPool.set(null);        //obj = null ;
//        }
//
//    }

    static String browser;

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigReader.read("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            switch (browser) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.235.53.73";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("failed to create remote session.");
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
