import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Issue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    private TestScreenshotUsingAshot steps;

    @BeforeClass
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver","D:\\drive\\chromedriver.exe");
        steps = new TestScreenshotUsingAshot(new ChromeDriver());
    }
    @Test
    @Issue("ISSUE-1")
    public void searchTest() throws Exception {
        steps.openMainPage();
        steps.search("category_id");
        steps.makeScreenShot();
        steps.makeAshotScreenShot();
        steps.searchPrinter();
        steps.makeScreenShotOfThePrinterList();
        steps.searchCity();
        steps.makeScreenShotCityList();
        steps.chekBox();
        steps.makeScreenShotChekBox();
        steps.moreExpensive();
        steps.makeScreenShotMoreExpensive();
        steps.quit();
    }
}
