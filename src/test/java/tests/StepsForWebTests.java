package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForWebTests {
    @Step("Открываем главную страницу")
    public void openMainPageTest() {
        open("");
    }

    @Step("Ищем репозиторий {rep}")
    public void searchForRepositoryTest(String rep) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(rep);
        $("#query-builder-test").pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {rep}")
    public void clickOnRepositoryLinkTest(String rep) {
        $(By.linkText(rep)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTabTest() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumberTest(String issue) {
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshotTest() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
