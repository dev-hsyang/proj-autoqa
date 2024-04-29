package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CjProj {

    static String CJ_THE_MARKET = "https://www.cjthemarket.com/pc/main";
    static ChromeDriver driver;
    static WebElement webElement;
    static WebDriverWait wait;


    public static void proj(){
        init();
        login();
//        // 웹 페이지상 javascript 실행하는 부분
//        webElement = driver.findElement(By.cssSelector("#ca-menu-trigger-new"));
//        driver.executeScript("arguments[0].click()", webElement);
        selectProd();
        addCart();
        moveToCart();
        moveToOrder();
    }

    public static void init(){
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(2800, 2000));
        driver.get(CJ_THE_MARKET);
    }

    public static void login(){
        webElement = driver.findElement(By.cssSelector("#header > div.header-wrap > div > div.header-mymenu.re-pose > a.btn-mypage"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        webElement.click();

        WebElement text_box_id = driver.findElement(By.cssSelector("#loginForm1 > div.login-form > form > fieldset.login > span.input-text.lg > input"));
        text_box_id.clear();
        text_box_id.sendKeys("-");

        WebElement text_box_pw = driver.findElement(By.cssSelector("#loginForm1 > div.login-form > form > fieldset.login > span.input-password.lg > input"));
        text_box_pw.clear();
        text_box_pw.sendKeys("-");

        WebElement btn_login = driver.findElement(By.cssSelector("#loginBtn > span"));
        btn_login.click();

        Main.sleep(2000);
    }

    public static void selectProd(){
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header > div.header-wrap > div > h1 > a > img")));
        webElement = driver.findElement(By.cssSelector("#header > div.header-wrap > div > h1 > a > img"));
        webElement.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#idvdRcmMain01PrdLst > div.slick-list > div > li:nth-child(1) > div.product-list-top > a")));
//        Main.sleep(2000);
        webElement = driver.findElement(By.cssSelector("#idvdRcmMain01PrdLst > div.slick-list > div > li:nth-child(4) > div.product-list-top > a"));
        webElement.click();
    }

    public static void addCart(){
        webElement = driver.findElement(By.cssSelector("#prodDetail > div.product-detail-top > div.product-info-box.right > div.product-option.product-right-option > div > div > div.quantity > button.btn-increase"));
        for(int i=0; i<3; i++)
            webElement.click();

        webElement = driver.findElement(By.cssSelector("#cartBtn"));
        webElement.click();
    }

    public static void moveToCart(){
        webElement = driver.findElement(By.cssSelector("#header > div.header-wrap > div > div.header-mymenu.re-pose > a.btn-cart"));
        webElement.click();
//        Main.sleep(5000);
    }

    public static void moveToOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-buy")));
        webElement = driver.findElement(By.cssSelector("a.btn-buy"));
        webElement.click();
    }
}
