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
        downloadUnsplashNatureImages();
    }

    public static void print

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

