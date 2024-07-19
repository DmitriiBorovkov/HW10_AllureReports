package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final String ISSUE = "#87";
}
