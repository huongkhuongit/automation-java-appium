package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_suite {
    private AppiumDriver driver;
    @Before
    public void beforeTest() throws MalformedURLException {
        driver = new  AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), setCapabilities());
    }

    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
        String appPackage = "net.citigo.kiotviet.hotel";
        String appActivity = ".kv_hotel_mobile.MainActivity";
        String udid = "R5CR12CLSCB";
        String platformName = "Android";
        flutterCapabilities.setCapability("platformName", platformName);
        flutterCapabilities.setCapability("appPackage", appPackage);
        flutterCapabilities.setCapability("appActivity", appActivity);
        flutterCapabilities.setCapability("automationName", "Xcuit");
        flutterCapabilities.setCapability("udid", udid);
        flutterCapabilities.setCapability("newCommandTimeout", 120000);
        flutterCapabilities.setCapability("autoGrantPermissions", true);
        return flutterCapabilities;
    }

    @Test
    public void testcase1() {
        System.out.println("abc");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Đăng nhập']")).click();
        String retailerXpath = "//android.widget.EditText[contains(@text,'.kiotviet.vn')]";
        MobileElement retailerElement = (MobileElement) driver.findElement(By.xpath(retailerXpath));
        retailerElement.click();
        retailerElement.sendKeys("12345");
        System.out.println("abc");
    }
}
