package com.syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class RightAndDoubleClick {
   public static String url ="https://demo.guru99.com/test/simple_context_menu.html";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement rightClickButton=driver.findElement(By.xpath("//span[text() ='right click me']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).perform();

        WebElement editOption = driver.findElement(By.xpath("//span[text()='Edit']"));
        //editOption.click();
        action.click(editOption).perform();
        Thread.sleep(2000);
        Alert alert =  driver.switchTo().alert();
        alert.accept();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        action.doubleClick(doubleClickButton).perform();
        System.out.println(alert.getText());
        alert.accept();
driver.quit();
    }
}
