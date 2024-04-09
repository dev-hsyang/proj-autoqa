package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Blind {

    public static void blindBestTopics(){
        WebDriver driver = new ChromeDriver();
        String url = "https://www.teamblind.com/kr/";
        driver.get(url);

        List<WebElement> bestTopics = driver.findElements(By.cssSelector("#wrap > section > div > div.contents > div.home-list > div.topic-list.best > div.article"));

        for(WebElement element : bestTopics){
            String category = element.findElement(By.className("topic")).getText().trim();
            String title = element.findElement(By.className("tit")).getText().trim();
            String likes = element.findElement(By.cssSelector("div.wrap-info > a.like")).getText().trim();
            String comments = element.findElement(By.cssSelector("div.wrap-info > a.cmt")).getText().trim();
            int numOfLikes = Integer.parseInt(likes.split("\n")[1]);
            int numOfCmnts = Integer.parseInt(comments.split("\n")[1]);

            BlindBestTopicDto blindBestTopicDto = new BlindBestTopicDto(category, title, numOfLikes, numOfCmnts);
            System.out.println(blindBestTopicDto);
        }
        driver.quit();
    }
}
