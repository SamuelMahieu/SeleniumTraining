package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //Setting the options of Chrome since the version 111 have an issue
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Variables containing the different url or value in order to check the currentUrl
        String url = "https://www.amazon.es/";
        String urlCart = new String();
        Boolean goodLink = false;
        String urlKeyboard = "https://www.amazon.es/Apple-Keyboard-Touch-ID-Teclado-num%C3%A9rico/dp/B09BV5WQ8V/ref=sr_1_6?crid=2LTQKSLCLJBD2&keywords=teclado+apple&qid=1678802296&sprefix=%2Caps%2C96&sr=8-6";

        //Navigating to the Amazon page
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
        //Getting the Search box on the main page and type the search ww want
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("teclado apple");
        WebElement buttonSearch = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        buttonSearch.click();
        //Getting rid of the Cookie banner by accepting it
        WebElement buttonAcceptCookies = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        buttonAcceptCookies.click();
        //Choosing one result, navigate to it and clicking on it
        WebElement linkProduct = driver.findElement(By.partialLinkText("Apple Magic Keyboard con Touch ID"));
        Actions displayElement = new Actions(driver);
        displayElement.moveToElement(linkProduct);
        Thread.sleep(2000);
        linkProduct.click();
        //Adding the product to the cart
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCart.click();

        // Getting the url and print it

        urlCart = driver.getCurrentUrl();
        System.out.println(urlCart);

        driver.close();
    }
}