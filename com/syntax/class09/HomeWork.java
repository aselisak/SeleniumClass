package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    public static String url ="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    //click on leave
    //click on leave list
    //choose from "From calendar"
    //choose from "To calendar"
    //click only on cancelled and rejected checkboxes
    //uncheck Pending Approval
    //select IT support from DD
    //click search
    //quit the browser
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // login actions
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Aug");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String dateText = fromDate.getText();
            if (dateText.equals("10")) {
                fromDate.click();
                break;
            }
        }


        WebElement toCalendar = driver.findElement(By.xpath("//input[@id='calToDate']"));
        toCalendar.click();
        WebElement monthDD1 = driver.findElement(By.className("ui-datepicker-month"));
        Select select1 = new Select(monthDD1);
        select1.selectByVisibleText("Sep");

        List<WebElement> toDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement toDate : toDates) {
            String dateText1 = toDate.getText();
            if (dateText1.equals("15")) {
                toDate.click();
                break;
            }
        }


        WebElement rejectButton = driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
        rejectButton.click();

        WebElement cancelButton = driver.findElement(By.id("leaveList_chkSearchFilter_0"));
        cancelButton.click();

        WebElement approvalButton = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
        approvalButton.click();

        Thread.sleep(3000);
        driver.quit();



    }
}








