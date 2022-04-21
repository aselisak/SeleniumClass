package com.syntax.Utils;

import com.syntax.testbase.BaseClass;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass {
    /**
     * this method will send text to a given element
     * @param element
     * @param text
     */
    public void sendText(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }

    /**
     * this method will switch to a frame by index
     * @param index
     */
    public void switchToFrame(int index){
        try {
            driver.switchTo().frame(index);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }

    }
}
