package Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CalculatorTest {

    static AppiumDriver driver;

    public static void main(String[] args) {

        try {
            openCalculator();
        } catch (Exception e) {
            //System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void openCalculator() throws Exception {

        //Setting mobile capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Redmi 6 Pro");
        cap.setCapability("udid", "0986fbcd0805");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9 PKQ1.180917.001");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.miui.calculator");
        cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        //Setting Url
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        //setting driver
        driver = new AppiumDriver(url, cap);
        WebElement privacyAcceptance = driver.findElement(By.id("android:id/button1"));
        if (privacyAcceptance.isDisplayed()) {
            driver.findElement(By.id("android:id/button1")).click();
        }
        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        String result = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
        System.out.println("Sum of 2 numbers is " + result);
    }
}
