package com.testautomation.container.test;

import com.testautomation.container.pages.GooglePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {

    private WebDriver driver;
    private GooglePage google;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.19.0.2:4444/wd/hub"), dc);
        google = new GooglePage(driver);
    }

    @Test
    public void googleTest() throws InterruptedException {
        google.goTo();
        google.searchFor("automation");
//        Assert.assertTrue(google.getResults().size() >= 10);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

}