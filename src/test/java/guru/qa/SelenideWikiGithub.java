package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiGithub {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void wiki() {
        //открыть страницу Selenide в Github
        open("/selenide/selenide");
        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        //Открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
