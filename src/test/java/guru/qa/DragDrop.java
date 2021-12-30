package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDrop {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}
