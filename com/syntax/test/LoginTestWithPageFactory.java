package com.syntax.test;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class LoginTestWithPageFactory {
    public static void main(String[] args) throws IOException {
        BaseClass.OpenSpecificBrowser("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginPageWithPageFactory loginPageWithPageFactory = new LoginPageWithPageFactory();
        DashboardPage dashboardPage = new DashboardPage();
        loginPageWithPageFactory.username.sendKeys("Admin");
        loginPageWithPageFactory.password.sendKeys("Hum@nhrm123");
        loginPageWithPageFactory.loginButton.click();

        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File srcFile =ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/HRMS/dashboard.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        String welcomeText = dashboardPage.welcomeAdmin.getText();
        System.out.println(welcomeText);

        BaseClass.tearDown();



    }
}
