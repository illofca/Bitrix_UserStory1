package com.cybertek.tests.Bitrix_US1;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/stream/");
    }

    @Test
    public void logIn() throws InterruptedException {

//AC#1
        //1- go to login page and enter username: helpdesk21@cybertekschool.com
        WebElement login = driver.findElement(By.xpath("//input[@class='login-inp']"));
        login.sendKeys("helpdesk21@cybertekschool.com");

        //2- go to login page and enter password: UserUser
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        //3- Click on 'Log In' button
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        //4-Go to Message tab and click
        WebElement messageButton = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-message\"]"));
        messageButton.click();

        //5-Assert Message Box is open
        Assert.assertTrue(messageButton.isEnabled() , "Message button is not clicked. Verification FAILED!!");

//AC#2
        //Following two lines solved problem that moreButton was not getting clicked, however hovering with moveToElement seems another solution, NOTE: if 'File' is not displayed, remove actions and activate those lines
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("feed-add-post-form-link-more")));

        //1-Go (hover) to 'MORE' button and click it for dropdown menu to reach 'File' button
        WebElement moreButton = driver.findElement(By.xpath("//span[@class='feed-add-post-more-icon']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(moreButton).perform();
        moreButton.click();

        //2-Click to 'File' button to select from 4 attachment options
        WebElement fileButton= driver.findElement(By.xpath("//span[.='File']"));
        fileButton.click();

        //3- Select 'Select document from Bitrix24' and click
        WebElement uploadFromBitrix = driver.findElement(By.xpath("//span[.='Select document from Bitrix24']"));
        uploadFromBitrix.click();

        //4- Select an image (1.png --> In every computer that is different so look for yours) and click
        WebElement fileToUpload = driver.findElement(By.xpath("//a[.='1.png']"));
        fileToUpload.click();

        //5- Select 'Download from external drive', see "SELECT DOCUMENT' and click
        WebElement selectDocument = driver.findElement(By.xpath("//*[@id=\"DiskFileDialog\"]/div[3]/span[1]"));
        selectDocument.click(); //since we didnot add any document it will not add a document from here

        //5- Select 'SEND' and click to send email with attachment - only 1.png will be attache to email
        WebElement sendEmail = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-save\"]"));
        sendEmail.click();
        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html




    }

}