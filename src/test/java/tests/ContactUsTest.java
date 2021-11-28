package tests;

import enums.MessageSubject;
import models.Message;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TopMenu;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactUsTest extends TestBase {

  @Test
  @Order(2)
  public void shouldNotAllowToSendEmptyContactUsForm() {
    TopMenu topMenu = loadTopMenuPage(driver);
    ContactUsPage contactUsPage = topMenu.clickContactUs();
    contactUsPage.clickSubmitBtn();
    contactUsPage.waitForAlertDangerToOccur();
  }

  @Test
  @Order(1)
  public void shouldNotAllowToSendContactUsFormWithOnlyEmailPassed() {
    HomePage homePage = loadHomePage(driver);
    driver.findElement(By.id("contact-link")).click();
    WebElement emailInput = driver.findElement(By.id("email"));
    emailInput.sendKeys("patka@wp.pl");
    driver.findElement(By.id("submitMessage")).click();
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
  }

  @Test
  @Order(3)
  public void shouldSendContactUsFormWithValidData(){
    TopMenu topMenu = new TopMenu(driver);
    ContactUsPage contactUsPage = topMenu.clickContactUs();
    Message message = new Message();
    message.setMessage("Heheh");
    message.setEmail("patkasratka@wp.pl");
    message.setSubject(MessageSubject.WEBMASTER);
    message.setOrderReference("Nie wiem reference");
    contactUsPage.fillOutForm(message);
  }
}
