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

    public void quit() {
        driver.quit();
    }

}
