package ru.mail.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EmailMainPage {

    public boolean isEmailBtnVisible() {
        SelenideElement emailBtn = $x("//*[@id=\"ph-whiteline\"]/div/div[1]/a[2]");
        emailBtn.should(visible);
        return emailBtn.isDisplayed();
    }

    public int getCountEmails() {

        ElementsCollection elements = $$x("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/a");
        elements.shouldHave(CollectionCondition.size(3));
        return elements.size();
    }
}
