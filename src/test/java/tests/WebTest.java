package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.StepsForTests.StepsForWebTests;

public class WebTest extends TestBase {
    @Test
    @DisplayName("Тест с аннотацией Step")
    @Owner("Borovkov D.A.")
    @Feature("Feature №1")
    @Story("Story №1")
    public void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForWebTests steps = new StepsForWebTests();

        steps.openMainPageTest();
        steps.searchForRepositoryTest(REPOSITORY);
        steps.clickOnRepositoryLinkTest(REPOSITORY);
        steps.openIssuesTabTest();
        steps.shouldSeeIssueWithNumberTest(ISSUE);
        steps.takeScreenshotTest();
    }
}
