package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NaverLatestNews {

    public static void printLatestNews(){
        WebDriver driver = new ChromeDriver();
        String url = "https://news.naver.com/section/105";
        driver.get(url);

        List<WebElement> latestTopics = driver.findElements(By.cssSelector("#newsct > div.section_component.as_section_headline._PERSIST_CONTENT > ul.sa_list > li.sa_item._SECTION_HEADLINE"));

        for(WebElement element : latestTopics){
            String title = element.findElement(By.className("sa_text_title")).getText().trim();
            String text = element.findElement(By.className("sa_text_lede")).getText().trim();

            System.out.println("title: " + title);
            System.out.println("text: " + text);

        }
        //driver.quit();
    }
}
