package parallel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    public static HashMap <String, Integer> setCucumbers = new HashMap<>();
    WebDriver driver;
    Select genreSelect;

    @И("Поиск на авито")
    public void testCuc(DataTable table){
        List<Map<String,String>> dataTable = table.asMaps();
    }


    @ParameterType(".*")
    public Technologies technologi(String technologies){
        return Technologies.valueOf(technologies);
    }

    @ParameterType(".*")
    public Price pric(String price){
        return Price.valueOf(price);
    }


    @Дано("открыт ресурс авито")
    public void  openAvito() {
        System.setProperty("webdriver.chrome.driver","D:\\drive\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
    }


    @И("в выподающем списке котегорий выбрано {technologi}")
    public void openTehnologi(Technologies technologies){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement params = driver.findElement(By.name("category_id"));
        params.click();
        genreSelect = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        genreSelect.selectByVisibleText(technologies.value);
    }

    @И("в поле поиска введено значение {string}")
    public void openPrinter(String pr){
        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.click();
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(pr);
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(Keys.ENTER);
    }

    @Тогда("кликнуть по выподающему списку региона")
    public void clickToSlot(){
        WebElement ad = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        ad.click();
    }

    @Тогда("в поле региона введено значение {string}")
    public void getRegion(String vl){
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys(vl + Keys.ENTER);
    }

    @И("нажата кнопка показать объявление")
    public void enterTheRegion(){
        driver.findElement(By.xpath("//div[contains(@class,'popup-container')]//li[contains(@data-marker,'suggest(0)')]")).click();
        driver.findElement(By.xpath("//div//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();
    }

    @Тогда("открылась страница результаты по запросу принтер")
    public void listOfThePrinter(){
        WebElement checkBox = driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        WebElement kl = driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']"));
        kl.click();

    }

    @И("активирован чекбокс только с фотографией")
    public void chekBoxActivator(){
        WebElement withPhotoOnly = driver.findElement(By.xpath("//div/label[@class='checkbox-checkbox-7igZ6 checkbox-size-s-yHrZq']"));
        withPhotoOnly.click();
    }

    @И("в выподающем списке сортировка выбрано значение {pric}")
    public void moreExpensive(Price price){
        WebElement checkBox1 = driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select[@class='select-select-3CHiM']/option[@value='2']"));
        checkBox1.click();
    }

    @И("в консоль выведено значение название и цены {int} первых товаров")
    public void res(int num){
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item']"));
        for (int i = 0; i < num; i++){
            System.out.println(webElements.get(i).findElement(By.xpath(".//div/a/h3[@itemprop='name']")).getText() + "  " +
                    webElements.get(i).findElement(By.xpath("//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
        }
    }

}
