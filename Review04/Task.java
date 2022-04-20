package Review04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task {
    public static  String url="https://the-internet.herokuapp.com/dynamic_controls";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement checkbox =driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();
        WebElement text = driver.findElement(By.xpath("//p[@id='message']"));
        String textMessage = text.getText();

        System.out.println(textMessage);
        WebElement enableBtn =driver.findElement(By.xpath("//button[text()='Enable']"));

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));



    }
}
