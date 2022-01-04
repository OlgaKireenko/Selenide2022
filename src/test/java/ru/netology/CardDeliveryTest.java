package ru.netology;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.open;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardDeliveryTest {
    @Test
    public void shouldOrderDelivery() {
        LocalDate date = LocalDate.now();

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
       // String date1 = date.format(formatter);

        open("http://localhost:9999");
        $(".input__control").setValue("Москва");

       // $("[data-test-id='date']").doubleClick().sendKeys(Keys.BACK_SPACE);
      //$("[type='date']").setValue("10.01.2022");


        $("[name='name']").setValue("Ольга Киреенко");
        $("[name='phone']").setValue("+79640000000");
        $(".checkbox__box").click();
        $(byText("Забронировать")).click();

        String text = $(".notification__content").shouldBe(visible,Duration.ofSeconds(15)).getText();

        assertEquals("Встреча успешно забронирована на 07.01.2022",text);



        //$(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }
}
