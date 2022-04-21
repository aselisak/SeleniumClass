package com.syntax.pages;

import com.syntax.Utils.CommonMethods;
import com.syntax.testbase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonMethods {
    public WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
    public WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
    public WebElement loginButton = driver.findElement(By.name("ctl00$MainContent$login_button"));


}
