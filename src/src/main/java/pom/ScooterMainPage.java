package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScooterMainPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By questionsBlock = By.className("accordion");//Блок с вопросами
    private final By cookieButton = By.id("rcc-confirm-button");//Кнопка согласия с Cookie

    private WebDriver driver;
    public ScooterMainPage (WebDriver driver){
        this.driver = driver;
    }

    //Метод открытия главной страницы
    public void openMainPage(){
        driver.get(url);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsBlock));
    }

    //Метод для закрытия кнопки Cookie
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    //Метод клика на маркер для раскрытия панели
    public void clickPanel(int index){
        By locator = By.id("accordion__heading-" + index);
        driver.findElement(locator).click();
    }

    //Метод получения текста Вопроса
    public String getQuestionText(int index){
        By locator = By.id("accordion__panel-" + index);
        return driver.findElement(locator).getText();
    }

    //Метод получения текста Ответа
    public String getAnswerText(int index){
        By locator = By.id("accordion__heading-" + index);
        return driver.findElement(locator).getText();
    }

    //Метод для проверки видимости
    public boolean isBlockVisible(int index){
        By locator = By.id("accordion__panel-" + index);
        return driver.findElement(locator).isDisplayed();
    }
}