package com.example.seleniumprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String url = "https://www.naver.com/";
        driver.get(url);

        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://unsplash.com/ko/t/nature");
        sleep(3000);

        List<WebElement> imgElements = driver.findElements(By.cssSelector("img"));
        List<WebElement> imgSelect = driver.findElements(By.cssSelector("[data-test=\"masonry-grid-count-three\"] img[data-test=\"photo-grid-masonry-img\"]"));

        System.out.println(imgElements.size());
        System.out.println(imgSelect.size());

        for(WebElement element : imgSelect){
            String src = element.getAttribute("src");
            System.out.println(src);
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

