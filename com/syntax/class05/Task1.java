package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task1 {
    public static String url ="https://www.facebook.com/";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewButton = driver.findElement(By.xpath("//a[@role='button'][2]"));
        createNewButton.click();
        Thread.sleep(1000);
        WebElement monthDD = driver.findElement(By.id("month"));
        WebElement dayDD = driver.findElement(By.id("day"));
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectMM = new Select(monthDD);
        Select selectDD = new Select(dayDD);
        Select selectYD = new Select(yearDD);
        List<WebElement> day = selectDD.getOptions();
        int daySize = day.size();
        List<WebElement> year =selectYD.getOptions();
        int yearSize=year.size();
        List<WebElement> month = selectMM.getOptions();
        int monthSize = month.size();
        if(monthSize==12){System.out.println(true);
        }else{ System.out.println(false);
            if(daySize==31){System.out.println(true);
            }else {
                System.out.println(false);
                if (yearSize == 115) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }

                selectMM.selectByValue("7");
                selectDD.selectByValue("14");
                selectYD.selectByValue("1989");
                driver.quit();


            }}

    }
}
