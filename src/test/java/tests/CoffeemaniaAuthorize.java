package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CoffeemaniaAuthorize {


    /*@BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
     */

    @Test
    @Tag("autorizationTest")
    void autorizationTest() {

        TimeZone zone = TimeZone.getTimeZone("GMT+3:00");
        Calendar c = Calendar.getInstance(zone);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        String newdate= "";
        newdate += Integer.toString(hour) + String.format("%02d", minute);

        open("https://develop.web-v1.coffeemania.axept.com/");
        $x("//a[@href='/login']//img[1]").click();
        $("#input-phone").setValue("9917000320");
        $("#meetphone-submit-btn").click();
        $("#otc-1").click();
        $("#otc-1").setValue(newdate);
        //$x("//div[@id='restaurantChooseWrapper']/div[2]").shouldBe(visible);
        sleep(10000);
        $(".ajaxClosePicker").click();
        $x("//a[@href='/cabinet']//img[1]").click();






    }


}
