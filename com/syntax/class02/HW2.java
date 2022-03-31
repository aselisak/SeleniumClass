package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        navigate to fb.com
        click on create new account
        fill up all the textboxes
        click on sign up button
        close the pop up
        close the browser*/
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Adele");
        driver.findElement(By.name("lastname")).sendKeys("Isak");
        driver.findElement(By.name("reg_email__")).sendKeys("adeleisak2012@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("adeleisak2012@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("adele2012");
        driver.findElement(By.name("birthday_month")).sendKeys("august");
        driver.findElement(By.name("birthday_day")).sendKeys("01");
        driver.findElement(By.name("birthday_year")).sendKeys("2012");
        driver.findElement(By.name("sex")).click();
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(3000);
        driver.close();
    }
}
