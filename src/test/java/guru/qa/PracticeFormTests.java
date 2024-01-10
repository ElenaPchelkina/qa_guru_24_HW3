package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll

    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//      Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("irina@ivanova.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9001112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("February")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("123.jpg");
        $("#currentAddress").setValue("Moscow, Leninsky Prospekt, 56-67");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Irina"));
        $(".modal-body").shouldHave(text("Ivanova"));
        $(".modal-body").shouldHave(text("irina@ivanova.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9001112233"));
        $(".modal-body").shouldHave(text("08 February,2000"));
        $(".modal-body").shouldHave(text("history"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("123.jpg"));
        $(".modal-body").shouldHave(text("Moscow, Leninsky Prospekt, 56-67"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
    }
}
