package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    //Task
    //Navigate to https://syntaxprojects.com/bootstrap-iframe.php
    //verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
    //verify enroll today button is enabled
    public static String url ="https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);





    }
}
