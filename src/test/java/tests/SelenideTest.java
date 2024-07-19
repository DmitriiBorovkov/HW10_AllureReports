package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {
    @Test
    @DisplayName("Простой Selenide тест")
    @Owner("Borovkov D.A.")
    @Feature("Feature №1")
    @Story("Story №2")
    public void simpleSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");

        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUE)).should(Condition.exist);
    }

}