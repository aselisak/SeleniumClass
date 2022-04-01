package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        Alert alert= driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        driver.findElement(By.xpath("//button[@onclick= 'myConfirmFunction()']")).click();
        alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[text() = 'Click for Prompt Box']")).click();
        alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Anton is a smart student");
        Thread.sleep(2000);
        alert.accept();
        //driver.quit();


    }
}
