package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu extends BasePage {

  WebDriver driver;

  public TopMenu(WebDriver driver) {
    super(driver);
  }

  @FindBy(id="contact-link")
  WebElement contactUsBtn;

  public ContactUsPage clickContactUs(){
//    contactUsBtn.click();
    driver.findElement(By.id("contact-link")).click();
    return new ContactUsPage(driver);
  }
}
