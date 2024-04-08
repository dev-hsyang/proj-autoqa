package com.example.seleniumprog;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //downloadUnsplashNatureImages();
        //printPpomppuLatestArticles();
        blindBestTopics();
    }

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

        //driver.quit();
    }

    public static void printPpomppuLatestArticles(){
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

    public static void downloadUnsplashNatureImages(){
        WebDriver driver = new ChromeDriver();
        String url = "https://unsplash.com/ko/t/nature";
        driver.get(url);

        List<WebElement> imgSelect = driver.findElements(By.cssSelector("[data-test=\"masonry-grid-count-three\"] img[data-test=\"photo-grid-masonry-img\"]"));

        for(WebElement element : imgSelect){
            String src = element.getAttribute("src");
            System.out.println(src);
            BufferedImage saveImage = null;

            try {
                saveImage = ImageIO.read(new URL(src));
                if(saveImage != null){
                    String fileName = src.substring(src.lastIndexOf("/") + 1);
                    fileName = fileName.split("\\?")[0];
                    ImageIO.write(saveImage, "jpg", new File("/Users/hyunseungy/Downloads/" + fileName + ".jpg"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}