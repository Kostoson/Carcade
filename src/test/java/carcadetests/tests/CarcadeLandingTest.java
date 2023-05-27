package carcadetests.tests;

import carcadetests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class CarcadeLandingTest {
    MainPage mainPage = new MainPage();


    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKED")
    })
    @DisplayName("Проверка фильтра каталога")
    void catalogFilterTest() {
        open("https://www.carcade.com/");
        mainPage.catalogFilterHeader().
                catalogTabCheck();
    }


    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKED")
    })
    @DisplayName("Проверка наличия заголовков страницы 'Лизингополучателям' и 'О каркаде' ")
    void MainHeaderPageIsVisibleTest() {
        open("https://www.carcade.com/");
        mainPage.headerPage();
    }

    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKED")
    })
    @DisplayName("Проверка, что при нажатии на заголовок страницы 'Лизингополучателям', осуществляется переход на соответствующую страницу")
    void lesseesTabTest() {
        open("https://www.carcade.com/");
        mainPage.lesseesTab();
    }

    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKED")
    })
    @DisplayName("Проверка, что при нажатии на заголовок страницы 'О каркаде', осуществляется переход на соответствующую страницу")
    void aboutCarcadeTabTest() {
        open("https://www.carcade.com/");
        mainPage.aboutCarcadeTab();
    }


}
