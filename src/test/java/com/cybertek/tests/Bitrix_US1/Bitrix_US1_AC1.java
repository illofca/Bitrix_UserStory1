package com.cybertek.tests.Bitrix_US1;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
AC#1: Given user on ""Bitrix"" login UR: https://login2.nextbasecrm.com/stream/
When the user provides valid credentials
==> username: helpdesk7@cybertekschool.com
==>password:UserUser
Then he will successfully log in and see the home page,
And see Message Tab under Activity Stream

AC#2: Given user on "Bitrix" homepage URL.
When user clicks on "Message",
Then he should be able to see Files tap
When clicking File Tab
Then user should be able to choose from 4 options:
1. Upload from local disks.
2. From external drive.
3. From Bitrix24
4.Create files to upload
 */
public class Bitrix_US1_AC1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/stream/");
    }

    @Test
    public void logIn() throws InterruptedException {

//AC#1
        WebElement login = driver.findElement(By.xpath("//input[@class='login-inp']"));
        login.sendKeys("helpdesk21@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        WebElement messageButton = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-message\"]"));
        messageButton.click();

        Assert.assertTrue(messageButton.isEnabled() , "Message button is not clicked. Verification FAILED!!");
//AC#2

        WebElement moreButton = driver.findElement(By.xpath("//span[@class='feed-add-post-more-icon']"));
        moreButton.click();
        Thread.sleep(5);

        //Everythink works perfect until here

        WebElement fileButton= driver.findElement(By.xpath("//span[.='File']"));
        fileButton.click();
        Thread.sleep(5);

        WebElement uploadFromBitrix = driver.findElement(By.xpath("//span[.='Select document from Bitrix24']"));
        uploadFromBitrix.click();
        Thread.sleep(5);

        WebElement fileToUpload = driver.findElement(By.xpath("//a[.='1.png']"));
        fileToUpload.click();
        Thread.sleep(5);


        WebElement selectDocument = driver.findElement(By.xpath("//*[@id=\"DiskFileDialog\"]/div[3]/span[1]"));
        selectDocument.click();
        Thread.sleep(5);

        WebElement sendEmail = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-save\"]"));
        sendEmail.click();
        Thread.sleep(5);

    }

}

