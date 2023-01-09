package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScooterMainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Переменные для вопросов.
    private final By questionsBlock = By.className("accordion");

    private final By howMuch = By.xpath(".//div[contains(text(), 'Сколько это стоит? И как оплатить?')]");
    private final By fewScooters = By.xpath(".//div[contains(text(), 'Хочу сразу несколько самокатов! Так можно?')]");
    private final By rentTime = By.xpath(".//div[contains(text(), 'Как рассчитывается время аренды?')]");
    private final By orderToday = By.xpath(".//div[contains(text(), 'Можно ли заказать самокат прямо на сегодня?')]");
    private final By extendOrReturnOrder = By.xpath(".//div[contains(text(), 'Можно ли продлить заказ или вернуть самокат раньше?')]");
    private final By chargingWithScooter = By.xpath(".//div[contains(text(), 'Вы привозите зарядку вместе с самокатом?')]");
    private final By cancelOrder = By.xpath(".//div[contains(text(), 'Можно ли отменить заказ?')]");
    private final By behindMkad = By.xpath(".//div[contains(text(), 'Я жизу за МКАДом, привезёте?')]");

    //Блок с Ответами
    private final By howMuchAnswer = By.id("accordion__panel-0"); //Вопрос: Сколько это стоит? И как это оплатить?
    private final By fewScootersAnswer = By.id("accordion__panel-1"); //Вопрос: Как заказать несколько самокатов?
    private final By rentTimeAnswer = By.id("accordion__panel-2"); //Вопрос: Как расчитывается время аренды?
    private final By orderTodayAnswer = By.id("accordion__panel-3"); //Вопрос: Можно ли заказать самокат на сегодня?
    private final By extendOrReturnOrderAnswer = By.id("accordion__panel-4"); //Вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    private final By chargingWithScooterAnswer = By.id("accordion__panel-5"); //Вопрос: Вы привозите зарядку вместе с самокатом?
    private final By cancelOrderAnswer = By.id("accordion__panel-6"); //Вопрос: Можно ли отменить заказ?
    private final By behindMkadAnswer = By.id("accordion__panel-7"); //Вопрос: Я живу за МКДОом. Привезете?

    private WebDriver driver;

    public ScooterMainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage(){
        driver.get(url);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsBlock));
    }


    public void clickHowMuchQuestion () {
        driver.findElement(howMuch).click();
        driver.findElement(howMuchAnswer).getText();
    }

    public void clickFewScooterQuestion () {
        driver.findElement(fewScooters).click();
        driver.findElement(fewScootersAnswer).getText();
    }

    public void clickRentTimeQuestion () {
        driver.findElement(rentTime).click();
        driver.findElement(rentTimeAnswer).getText();
    }

    public void clickOrderTodayQuestion () {
        driver.findElement(orderToday).click();
        driver.findElement(orderTodayAnswer).getText();
    }

    public void clickReturnOrderQuestion () {
        driver.findElement(extendOrReturnOrder).click();
        driver.findElement(extendOrReturnOrderAnswer).getText();
    }

    public void clickChargingQuestion () {
        driver.findElement(chargingWithScooter).click();
        driver.findElement(chargingWithScooterAnswer).getText();
    }

    public void clickCancelOrderQuestion () {
        driver.findElement(cancelOrder).click();
        driver.findElement(cancelOrderAnswer).getText();
    }

    public void clickMkadQuestion () {
        driver.findElement(behindMkad).click();
        driver.findElement(behindMkadAnswer).getText();
    }

}