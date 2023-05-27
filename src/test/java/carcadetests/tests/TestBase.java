package carcadetests.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = System.getProperty("remote");
        Configuration.baseUrl = System.getProperty("baseUrl");
        String[] browser = System.getProperty("browser").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];

    }


}
