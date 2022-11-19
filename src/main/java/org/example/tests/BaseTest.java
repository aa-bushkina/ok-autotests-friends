package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.*;
import org.example.pages.utils.PageFactory;
import org.example.pages.utils.PageType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest
{
  static final private String LOGIN_URL = "https://ok.ru/";
  final protected String USERNAME = "technoPol5";
  final protected String PSWD = "technoPolis2022";

  protected LoginPage loginPage;
  protected NewsPage newsPage;
  protected UserPage userPage;
  protected FriendsPage friendsPage;
  protected OtherFriendsPage otherFriendsPage;

  @BeforeAll
  public static void setUp()
  {
    WebDriverManager.chromedriver().setup();
    Configuration.browser = "chrome";
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = true;
    Selenide.open(LOGIN_URL);
  }

  @BeforeEach
  public void logIn()
  {
    loginPage = (LoginPage) PageFactory.createPage(PageType.Login);
    newsPage = loginPage.logIn(USERNAME, PSWD);
  }

  @AfterEach
  public void logOut()
  {
    newsPage.getToolbar().clickActionButton().clickExit().clickExitButton();
  }
}
