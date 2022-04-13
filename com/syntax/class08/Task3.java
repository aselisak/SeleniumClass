package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task3 {
    //go to https://the-internet.herokuapp.com/dynamic_controls
    //click on checkbox and click on remove
    //verify the text
    //click on enable verify the textbox is enabled
    //enter text and click disable
    //verify the textbox is disabled
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement checkBox = driver.findElement(By.xpath("//input[@type ='checkbox']"));
        WebElement addRemoveButton = driver.findElement(By.xpath("//button[@onclick = 'swapCheckbox()']"));

        WebElement enabledDisabledButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        WebElement textB = driver.findElement(By.xpath("//input[@type='text']"));

        checkBox.click();
        addRemoveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        WebElement message = driver.findElement(By.cssSelector("p#message"));

        if (message.getText().equals("It's gone!")) {
            System.out.println("Element is removed");
        } else System.out.println("failed");

         enabledDisabledButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        if (textB.isEnabled()) {
            System.out.println("Text is enabled");
            textB.sendKeys("Homework");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
            WebElement messageText =driver.findElement(By.xpath("//p[@id='message']"));
            if(messageText.getText().equals("It's disabled!")) {
           System.out.println("Textbox disabled");
               } else System.out.println("Test fail");

        }
        driver.quit();
    }
}
