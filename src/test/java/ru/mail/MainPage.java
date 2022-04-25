package ru.mail;

import com.codeborne.selenide.SelenideElement;
import ru.mail.pages.EmailMainPage;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public void inputLogin(String login) {
        clickOnButtonLogin();
        SelenideElement inputLoginLine = $("#root > div > div > div > div.wrapper-0-2-5 > div > div > form > div:nth-child(2) > div:nth-child(2) > div.login-row.username > div > div > div > div > div > div.base-0-2-58.first-0-2-64 > div > input");
        inputLoginLine.sendKeys(login);
        inputLoginLine.pressEnter();
    }


    public void inputTOPassword(String password) {
        SelenideElement inputPasswordLine = $x("//*[@id='root']/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input");
        inputPasswordLine.setValue(password).pressEnter();

    }

    public EmailMainPage clickOnButtonLogin() {
        $("#ph-whiteline > div > div.ph-auth.svelte-1hiqrvn > button")
                .click();
        switchTo().frame($("body > div.ag_js-popup-frame.ag-popup__frame.ag-popup__frame_onoverlay.ag-popup__frame_show > div > iframe"));
        return page(EmailMainPage.class);
    }
}
