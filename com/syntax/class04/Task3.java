package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static sun.management.Agent.getText;

public class Task3 {
    /*HW 2
      HRMS Application Negative Login:Open chrome browser
      Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
      Enter valid username, Leave password field empty
      Click on login button, Verify error message with text "Password cannot be empty" is displayed.*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password =driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.clear();
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        WebElement displayText = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        boolean isPasswordText = displayText.isDisplayed();
        System.out.println(isPasswordText);
        driver.quit();







    }
}
