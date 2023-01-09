package orderscooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.OrderPage;
import pom.ScooterMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
public class ScooterPageTest {

        public WebDriver driver = new FirefoxDriver();
//    public WebDriver driver = new ChromeDriver();

    @Before
    public void startUp() {
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void createOrderTest() {
        OrderPage orderPage = new OrderPage(driver);

        orderPage.open();
        orderPage.clickOrderButton();
        orderPage.inputName("Иван");
        orderPage.inputSurname("Васильев");
        orderPage.inputFormCity("Москва, ул. Строителей, д.18");
        orderPage.chooseMetro();
        orderPage.inputPhoneNumber("+79992145818");
        orderPage.clickNextButton();
        orderPage.chooseDeliveryDay();
        orderPage.chooseRentalPeriod();
        orderPage.chooseScooterColor();
        orderPage.inputCommentForCourier("Как приедете позвоните по телефону");
        orderPage.clickFinishOrderButton();

        boolean isDisplayed = orderPage.orderMustBeSuccess();
        assertTrue("Что-то пошло не так", isDisplayed);

    }


    @Test
    public void questionAndAnswerTest(){
        ScooterMainPage scooterMainPage = new ScooterMainPage(driver);

        scooterMainPage.openMainPage();
        scooterMainPage.clickHowMuchQuestion();
        scooterMainPage.clickFewScooterQuestion();
        scooterMainPage.clickRentTimeQuestion();
        scooterMainPage.clickOrderTodayQuestion();
        scooterMainPage.clickReturnOrderQuestion();
        scooterMainPage.clickChargingQuestion();
        scooterMainPage.clickCancelOrderQuestion();
        scooterMainPage.clickMkadQuestion();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}