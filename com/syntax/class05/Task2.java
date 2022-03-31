package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task2 {
    public static String url ="https://www.ebay.com/";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement category = driver.findElement(By.id("gh-cat"));
         Select select = new Select(category);
        List<WebElement> allOption=select.getOptions();
        for(WebElement option:allOption){
            String optionText =option.getText();
            System.out.println(optionText);
        }
WebElement search =driver.findElement(By.id("gh-btn"));
        select.selectByValue("58058");
        search.click();
        WebElement logo = driver.findElement(By.xpath("//span[@class='b-pageheader__text']"));
        boolean displayed=logo.isDisplayed();
        System.out.println(displayed);




    }
}
