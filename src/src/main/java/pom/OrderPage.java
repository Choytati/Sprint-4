
package pom;

import org.openqa.selenium.*;

public class OrderPage {
    //Главная страница Яндекс.Самокат
    public final String url = "https://qa-scooter.praktikum-services.ru/";
    //Нижняя кнопка "Заказать"
    private final By downOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка закрытия Cookie
    private final By cookieButton = By.id("rcc-confirm-button");
    //Поле ввода Имени
    private final By inputName = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле ввода Фамилии
    private final By inputSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле ввода адреса
    private final By inputPlace = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Выбор станции метро
    private final By inputMetroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Поле ввода номера телефона
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка следующая страница "Далее"
    private final By nextPageButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    //Календарь
    private final By deliveryDay = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Период аренды
    private final By rentalPeriod = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    //Количество арендуемых дней
    private final By numberOfDays = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'двое суток']");
    //Цвет самоката
    private final By scooterColor = By.xpath(".//input[@id = 'black']");
    //Комментарий для курьерса
    private final By commentForCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка заказать в конце формы
    private final By finishOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    //Кнопка подтверждения "Да"
    private final By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //Всплывающее окна об успешном создании заказа
    private final By orderHasBeenSuccess = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");

    private WebDriver driver;

    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    public void scrollClickOrderButton(String button){
        if(button.equals(".//button[@class = 'Button_Button__ra12g']")){
            clickOrderButton(button);
        }else{
            WebElement element = driver.findElement(downOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            clickOrderButton(button);
        }
    }

    public void clickOrderButton(String button) {
        driver.findElement(By.xpath(button)).click();
    }

    public boolean isOrderPageDisplayed(String expected){
        return driver.findElement(By.className(expected)).isDisplayed();
    }

    public void inputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void inputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void inputFormCity(String city) {
        driver.findElement(inputPlace).sendKeys(city);
    }

    public void chooseMetro() {
        driver.findElement(inputMetroStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void inputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextPageButton).click();
    }

    public void chooseDeliveryDay(){
        driver.findElement(deliveryDay).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER);
    }

    public void chooseRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        driver.findElement(numberOfDays).click();
    }

    public void chooseScooterColor(){
        driver.findElement(scooterColor).click();
    }

    public void inputCommentForCourier(String comment){
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void clickFinishOrderButton(){
        driver.findElement(finishOrderButton).click();
        driver.findElement(yesButton).click();
    }

    public boolean orderMustBeSuccess(){
        return driver.findElement(orderHasBeenSuccess).isDisplayed();
    }

    //Метод взаимодействия с первой частью заказа
    public void fillFirstOrderPage(String name, String surname, String city, String phoneNumber){
        inputName(name);
        inputSurname(surname);
        inputFormCity(city);
        inputPhoneNumber(phoneNumber);
        chooseMetro();
        clickNextButton();
    }

    //Метод взаимодействия со второй частью заказа
    public void fillSecondOrderPage(String comment){
        chooseDeliveryDay();
        chooseRentalPeriod();
        chooseScooterColor();
        inputCommentForCourier(comment);
        clickFinishOrderButton();
    }
}