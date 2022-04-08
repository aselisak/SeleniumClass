package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Task2 {
    //click on the link
    //get text
    //print out in the console
    public static String url ="http://www.uitestpractice.com/Students/Contact";
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement link =driver.findElement(By.xpath("//a[contains(text(), 'Ajax link')]"));
        link.click();

        WebElement textLink =driver.findElement(By.xpath("//div[@class='ContactUs']/p"));
        System.out.println(textLink.getText());


driver.quit();



    }
}
