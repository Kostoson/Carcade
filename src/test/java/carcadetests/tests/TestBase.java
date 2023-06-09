package carcadetests.tests;

import carcadetests.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = System.getProperty("remote");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserSize = System.getProperty("browserSize");
        String[] browser = System.getProperty("browser").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true, //чтобы отображалось в селенейде, что внутри просиходит
                "enableVideo", true //чтобы писалась запись видео
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy = "eager";

    }


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
