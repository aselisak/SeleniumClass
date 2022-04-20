package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement userPassword =driver.findElement(By.id("txtPassword"));
        userPassword.sendKeys("Hum@nhrm123");
        WebElement loginButton =driver.findElement(By.id("btnLogin"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement leaveButton =driver.findElement(By.linkText("Leave"));
        leaveButton.click();
        WebElement leaveListButton =driver.findElement(By.linkText("Leave List"));
        leaveListButton.click();

        WebElement fromCalendar =driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement month =driver.findElement(By.cssSelector("select.ui-datepicker-month"));

        Select select=new Select(month);
        select.selectByVisibleText("Jul");

        WebElement year =driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select select1 =new Select(year);
        select1.selectByVisibleText("1987");

        List<WebElement> dates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement date:dates){
            String rowText = date.getText();
            if(rowText.contains("20")){
                date.click();
                break;
            }
        }
        WebElement toCalendar = driver.findElement(By.id("calToDate"));
        toCalendar.click();

        WebElement monthReturn = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select select2 = new Select(monthReturn);
        select2.selectByVisibleText("Jul");

        WebElement yearReturn =driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select select3 = new Select(yearReturn);
        select3.selectByVisibleText("2022");

        List<WebElement> dateReturn=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement d: dateReturn){
            String rowText=d.getText();
            if(rowText.contains("13")){
                d.click();
                break;
            }
        }
        List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < checkboxes.size(); i++) {
            String values = checkboxes.get(i).getAttribute("value");
            if(!checkboxes.get(i).isSelected() && (values.equals("-1") || values.equals("0"))){
                checkboxes.get(i).click();
            }
            if(checkboxes.get(i).isSelected() && values.equals("1")){
                checkboxes.get(i).click();
            }
        }
       WebElement subUnit = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select select4 = new Select(subUnit);
        select4.selectByVisibleText("IT Support");

       WebElement searchButton = driver.findElement(By.id("btnSearch"));
       searchButton.click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(src, new File("screenshots/HRM/calendar.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
