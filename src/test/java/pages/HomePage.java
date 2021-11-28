package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage  extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }


  public void assertTitle(){

    assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
  }}
