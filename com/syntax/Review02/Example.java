package com.syntax.Review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");

        WebElement femaleBTN = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        System.out.println("the female radio btn is enabled "+femaleBTN.isEnabled());
        System.out.println("the female radio btn us displayed "+femaleBTN.isDisplayed());
             if(!femaleBTN.isSelected()){
                 femaleBTN.click();
}
        System.out.println("the female btn is selected "+femaleBTN.isSelected());
             List<WebElement> links = driver.findElements(By.tagName("a"));
           for (WebElement link:links){
               String name = link.getText();
               if(!name.isEmpty()){
                   System.out.println(name);
               }
           }



    }
}
