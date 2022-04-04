package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CoffeemaniaAuthorize {


    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://149.154.70.38:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }


    @Test
    @Tag("autorizationTest")
    void autorizationTest() {


        open("https://develop.web-v1.coffeemania.axept.com/");
        $x("//a[@href='/login']//img[1]").click();
        $("#input-phone").setValue("9917000320");
        $("#meetphone-submit-btn").click();
        $("#otc-1").click();

        TimeZone zone = TimeZone.getTimeZone("GMT+3:00");
        Calendar c = Calendar.getInstance(zone);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        String newdate = "";
        newdate += String.format("%02d", hour) + String.format("%02d", minute);

        $("#otc-1").setValue(newdate);
        //$x("//div[@id='restaurantChooseWrapper']/div[2]").shouldBe(visible);
        sleep(10000);
        $(".ajaxClosePicker").click();
        $x("//a[@href='/cabinet']//img[1]").click();


    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
