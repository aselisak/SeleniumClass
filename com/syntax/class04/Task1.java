package com.syntax.class04;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*Task
    Open Chrome browser Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    Enter valid username and password (username - Admin, password - Hum@nhrm123)
    Click on login button Then verify Syntax Logo is displayed.*/

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
        WebElement imageText = driver.findElement(By.cssSelector("img[src$='syntax.png']"));
        imageText.isDisplayed();
        boolean isImageTextDisplayed = imageText.isDisplayed();
        System.out.println(isImageTextDisplayed);
        driver.quit();

    }
}
