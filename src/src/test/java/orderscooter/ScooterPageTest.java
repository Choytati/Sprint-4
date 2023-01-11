package orderscooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterPageTest {

//        public WebDriver driver = new FirefoxDriver();
        public WebDriver driver = new ChromeDriver();

    private final String button;
    private final String expected;
    public ScooterPageTest(String button, String expected) {
        this.button = button;
        this.expected = expected;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameterized.Parameters(name = "Order Button: {0}, Get Page: {1}")
    public static Object[][] dataButton(){
        return new Object[][]{
                {".//button[@class = 'Button_Button__ra12g']", "Order_Content__bmtHS"},
                {".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']", "Order_Content__bmtHS"},
        };
    }

    @Test
    public void createOrderTest() {
        OrderPage orderPage = new OrderPage(driver);

        orderPage.open();
        orderPage.clickCookieButton();
        orderPage.scrollClickOrderButton(button);
        //Проверка что страница мы видим страницу с полями на экране
        Assert.assertTrue(orderPage.isOrderPageDisplayed(expected));
        orderPage.fillFirstOrderPage("Николай",
                                    "Иванов",
                                        "Москва, ул. Строителей, д.18",
                                    "+79992145818");
        orderPage.fillSecondOrderPage("Как приедете позвоните по телефону");
        //Проверка что заказ создан успешно
        assertTrue(orderPage.orderMustBeSuccess());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}