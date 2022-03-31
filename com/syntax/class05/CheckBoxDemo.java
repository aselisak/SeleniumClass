package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo {
    public static String url="https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //locating checkboxes and storing them in the list
        List<WebElement> optionCheckBox = driver.findElements(By.cssSelector("input[class ='cb1-element']"));
        int size = optionCheckBox.size();
        System.out.println(size);
//lopping through each element from the List line 19
        for (WebElement option:optionCheckBox){
           String checkBoxValue = option.getAttribute("value");
           if(checkBoxValue.equals("Option-2")){
               option.click();
                  break;
           }
        }





    }

}
