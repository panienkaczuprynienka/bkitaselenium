package pages;

import models.Message;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {

  public ContactUsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "submitMessage")
  WebElement submitBtn;

  @FindBy(css = ".alert-danger")
  WebElement alertDanger;

  @FindBy(css = ".alert-success")
  WebElement alertSuccess;

  @FindBy(id = "id_contact")
  WebElement selectContact;

  @FindBy(id = "id_order")
  WebElement referenceInput;

  @FindBy(id = "message")
  WebElement messageTextArea;

  @FindBy(id = "email")
  WebElement emailInput;


  public void clickSubmitBtn() {
    submitBtn.click();
  }

  public void waitForAlertDangerToOccur() {
    wait.until(ExpectedConditions.visibilityOf(alertDanger));
  }

  public void fillOutForm(Message message) {
    Select select = new Select(selectContact);
    select.selectByVisibleText(message.getSubject().getValue());
    messageTextArea.sendKeys(message.getMessage());
    referenceInput.sendKeys(message.getOrderReference());
    emailInput.sendKeys(message.getEmail());
    submitBtn.click();
    wait.until(ExpectedConditions.visibilityOf(alertSuccess));
  }
}
