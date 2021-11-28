package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.TopMenu;

import java.time.Duration;

public class TestBase {

  private static final String BASE_URL = "http://automationpractice.com/index.php";

  public WebDriver driver;

  public HomePage loadHomePage(WebDriver driver){
    driver.get(BASE_URL);
    return new HomePage(driver);
  }

  public TopMenu loadTopMenuPage(WebDriver driver){
    driver.get(BASE_URL);
    return new TopMenu(driver);
  }

  @BeforeAll
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterEach
  void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
