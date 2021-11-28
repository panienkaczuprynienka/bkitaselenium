package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageTest extends TestBase {

  public WebDriver driver;

  @Test
  void shouldReturnCorrectPageTitle() {
    HomePage homePage = loadHomePage(driver);
    homePage.assertTitle();
  }

}
