package ru.mail.test;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MailRuTest {

    @Test
    public void testMailRuLoginTest() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration configuration = new Configuration();


        WebDriverManager.chromedriver().setup();

        open("https://mail.ru/");
        $("#ph-whiteline > div > div.ph-auth.svelte-1hiqrvn > button")
                .click();
        ;
        switchTo().frame($("body > div.ag_js-popup-frame.ag-popup__frame.ag-popup__frame_onoverlay.ag-popup__frame_show > div > iframe"));

        SelenideElement inputLoginLine = $("#root > div > div > div > div.wrapper-0-2-5 > div > div > form > div:nth-child(2) > div:nth-child(2) > div.login-row.username > div > div > div > div > div > div.base-0-2-58.first-0-2-64 > div > input");

        inputLoginLine.sendKeys("selenide92");
        inputLoginLine.pressEnter();
        SelenideElement inputPasswordLine = $x("//*[@id='root']/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input");
        inputPasswordLine.setValue("Y3joOey(rKR2").pressEnter();

        SelenideElement mailCounterImage = $x("//*[@id='ph-whiteline']/div/div[1]/a[2]");
        mailCounterImage.should(visible);
        mailCounterImage.click();

        $$x("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/a")
                .shouldHave(CollectionCondition.size(3));


    }

}


