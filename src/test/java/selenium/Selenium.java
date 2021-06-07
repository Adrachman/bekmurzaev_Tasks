package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\drive\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement params = driver.findElement(By.name("category_id"));
        params.click();
        Select genreSelect = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        genreSelect.selectByVisibleText("Оргтехника и расходники");

        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.click();

        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(Keys.ENTER);
//
        WebElement ad = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        ad.click();
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток"+Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(@class,'popup-container')]//li[contains(@data-marker,'suggest(0)')]")).click();
        driver.findElement(By.xpath("//div//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();


        WebElement checkBox = driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        WebElement kl = driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']"));
        kl.click();


        WebElement withPhotoOnly = driver.findElement(By.xpath("//div/label[@class='checkbox-checkbox-7igZ6 checkbox-size-s-yHrZq']"));
        withPhotoOnly.click();

        WebElement checkBox1 = driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select[@class='select-select-3CHiM']/option[@value='2']"));
        checkBox1.click();

        List<WebElement> webElements = driver.findElements(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item']"));
        for (int i = 0; i < 3; i++){
            System.out.println(webElements.get(i).findElement(By.xpath(".//div/a/h3[@itemprop='name']")).getText()+webElements.get(i).findElement(By.xpath("//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
        }

    }
}
