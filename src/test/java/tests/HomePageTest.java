package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestBase {


  @Test
  void shouldReturnCorrectPageTitle() {
    driver.get("http://automationpractice.com/index.php");
    assertThat(driver.getTitle()).isEqualTo("My Store");
  }

}
