package com.testautomation.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "input.lsb")
    private WebElement searchButton;

    @FindBy(className = "rc")
    private List<WebElement> searchResults;

    @FindBy(id = "foot")
    private WebElement footer;

    public GooglePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        this.driver.get("https://www.google.com");
    }

    public void searchFor(String text) throws InterruptedException {
        this.searchBox.sendKeys(text);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Recherche Google\"]")));
        driver.findElement(By.cssSelector("input[value=\"Recherche Google\"]")).click();
        System.out.println("DONE");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));
    }

    public List<WebElement> getResults() {
        return this.searchResults;
    }

}