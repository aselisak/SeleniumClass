package com.syntax.Review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownReview {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement accountCreate=driver.findElement(By.linkText("Create new account"));
        accountCreate.click();
        Thread.sleep(1000);
        WebElement daysOption = driver.findElement(By.cssSelector("select#day"));
        Select days = new Select(daysOption);
        days.selectByValue("5");
        Thread.sleep(2000);
        days.selectByIndex(0);
        Thread.sleep(2000);
        days.selectByVisibleText("25");
        List<WebElement> options = days.getOptions();

         for (WebElement option:options){
             System.out.println(option.getText());
             //option.getAttribute("value");
         }


    }

}
