package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
    TASK: NEW METHOD CREATION
    Method Name: getDriver
    Static method
    Accepts string argument : browserType --> will determine what browser opens
    return type: WebDriver
     */

public class WebDriverFactory {



    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            //System.setProperty("webdriver.chrome.driver", "path");

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Given browser does not exist. Driver = null");
            return null;
        }
    }
}