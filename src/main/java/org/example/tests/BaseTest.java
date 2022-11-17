package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.BeforeClass;

public class BaseTest
{
  @NotNull
  static final private String LOGIN_URL = "https://ok.ru/";

  @BeforeClass
  public static void setUp()
  {
    WebDriverManager.chromedriver().setup();
    Configuration.browser = "chrome";
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = true;
    Selenide.open(LOGIN_URL);
  }
}
