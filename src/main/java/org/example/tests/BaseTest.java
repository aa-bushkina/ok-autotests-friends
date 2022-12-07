package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.NewsPage;
import org.example.pages.UserPage;
import org.example.pages.OtherFriendsPage;
import org.example.pages.FriendsPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;

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
}
