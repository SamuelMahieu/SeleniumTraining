import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");
        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
        driver.close();
    }
}