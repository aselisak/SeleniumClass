package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    public static void main(String[] args) {
        //HW
        //navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
        //fill out the form
        //click on register
        //close the browser
        //navigate to fb.com
        //click on create new account
        //fill up all the textboxes
        //click on sign up button
        //close the pop up
        //close the browser


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Asel");
        driver.findElement(By.id("customer.lastName")).sendKeys("Isak");
        driver.findElement(By.id("customer.address.street")).sendKeys("1615 E 10th street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Brooklyn");
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("11223");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123654789");
        driver.findElement(By.id("customer.ssn")).sendKeys("123654789");
        driver.findElement(By.id("customer.username")).sendKeys("Asel007");
        driver.findElement(By.id("customer.password")).sendKeys("Asel123654789");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Asel123654789");
        driver.findElement(By.className("button")).click();
        driver.quit();




    }
}
