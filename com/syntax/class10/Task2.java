package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static String url="https://www.aa.com/homePage.do";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departDate = driver.findElement(By.className("ui-datepicker-trigger"));
        departDate.click();
        WebElement departM = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        WebElement nextBtn = driver.findElement(By.xpath("//a[@data-handler='next']"));
        String departMonthText=departM.getText();

        while(!departMonthText.equals("April")){
            nextBtn.click();
            departM=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            departMonthText=departM.getText();
            nextBtn=driver.findElement(By.xpath("//a[@data-handler='next']"));
        }

        List<WebElement> departDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for(WebElement depDate:departDates){
            String departDateText=depDate.getText();
            if(departDateText.equals("25")){
                depDate.click();
                break;
            }
        }
        WebElement returnDate = driver.findElement(By.xpath("//label[@for='aa-returningFrom']/following-sibling::button"));
        returnDate.click();

        WebElement returnMonth =driver.findElement(By.xpath("(//span[@class='ui-datepicker-calendar'])[2]"));
        String returnMonthText = returnMonth.getText();
        while(!returnMonthText.equals("August")){
            nextBtn.click();
            returnMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-calendar'][2]"));
            returnMonthText=returnMonth.getText();
            nextBtn= driver.findElement(By.xpath("//a[@data-handler='next']"));
        }

        List<WebElement> returnDates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"));
        for (WebElement rtnDate:returnDates){
            String rtnDateText=rtnDate.getText();
            if(rtnDateText.equals("2")){
                rtnDate.click();
                break;
            }
        }
        WebElement destination = driver.findElement(By.xpath("//label[@for='reservationFlightSearchForm.destinationAirport']"));
        destination.sendKeys("ord", Keys.ENTER);

driver.quit();






    }

}
