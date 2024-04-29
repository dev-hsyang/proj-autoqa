package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintPpomppuLatestArticles {

    public static void printLatestArticles(){
        WebDriver driver = new ChromeDriver();
        String url = "https://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard";
        driver.get(url);

        List<WebElement> latestArticles = driver.findElements(By.cssSelector("#revolution_main_table > tbody > tr:not(.baseNotice) > td:nth-child(3) > a"));

        for(WebElement element : latestArticles){
            String title = element.getText().trim();
            System.out.println(title);
        }

        driver.quit();
    }
}
