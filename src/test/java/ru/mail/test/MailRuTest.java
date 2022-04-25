package ru.mail.test;


import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import ru.mail.MainPage;
import ru.mail.pages.EmailMainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MailRuTest {


    @Test
    public void pageObjectTest() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

        WebDriverManager.chromedriver().setup();

        open("https://mail.ru/");

        MainPage mainPage = new MainPage();
        mainPage.inputLogin("selenide92");
        mainPage.inputTOPassword("Y3joOey(rKR2");

        EmailMainPage emailMainPage = new EmailMainPage();


        assertTrue(emailMainPage.isEmailBtnVisible());
        assertEquals(emailMainPage.getCountEmails(), 3);
    }


}


