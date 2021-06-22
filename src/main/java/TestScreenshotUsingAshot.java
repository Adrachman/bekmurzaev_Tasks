import com.google.common.base.Predicate;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestScreenshotUsingAshot {
    private WebDriver driver;

    public TestScreenshotUsingAshot(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void openMainPage() {
        driver.get("https://www.avito.ru/");
    }

    @Step
    public void search(String text) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name(text)).click();
        Select genreSelect = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        genreSelect.selectByVisibleText("Оргтехника и расходники");
    }

    @Attachment
    @Step("Full screenshot")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    @Step("Screenshot of category element")
    public byte[] makeAshotScreenShot() {
        WebElement search = driver.findElement(By.xpath("//select[@id='category']"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, search);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    @Step
    public void searchPrinter(){
        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.click();
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(Keys.ENTER);
    }

    @Attachment
    @Step("Full screenshot")
    public byte[] makeScreenShotOfThePrinterList() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Step
    public void searchCity(){
        WebElement ad = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        ad.click();
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток"+Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(@class,'popup-container')]//li[contains(@data-marker,'suggest(0)')]")).click();
        driver.findElement(By.xpath("//div//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();
    }
    @Step("Full screenshot")
    public byte[] makeScreenShotCityList() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step
    public void chekBox(){
        WebElement checkBox = driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        WebElement kl = driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']"));
        kl.click();
        WebElement withPhotoOnly = driver.findElement(By.xpath("//div/label[@class='checkbox-checkbox-7igZ6 checkbox-size-s-yHrZq']"));
        withPhotoOnly.click();
    }

    @Attachment
    @Step
    public byte[] makeScreenShotChekBox() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step
    public void moreExpensive(){
        WebElement checkBox1 = driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select[@class='select-select-3CHiM']/option[@value='2']"));
        checkBox1.click();
    }
    @Attachment
    @Step
    public byte[] makeScreenShotMoreExpensive() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void quit() {
        driver.quit();
    }

}
