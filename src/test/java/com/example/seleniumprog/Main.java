package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        String url = "https://www.naver.com/";
        driver.get(url);
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        driver.get("https://unsplash.com/ko/t/nature");
        sleep(3000);

        List<WebElement> imgElements = driver.findElements(By.cssSelector("img"));
        List<WebElement> imgSelect = driver.findElements(By.cssSelector("[data-test=\"masonry-grid-count-three\"] img[data-test=\"photo-grid-masonry-img\"]"));

        System.out.println(imgElements.size());
        System.out.println(imgSelect.size());

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

