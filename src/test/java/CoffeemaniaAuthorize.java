import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CoffeemaniaAuthorize {


    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void autorizationTest() {

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY) + 1;
        int minute = c.get(Calendar.MINUTE);


        String min = "";
        if (minute>=0 && minute<10) {
            min = "0" + Integer.toString(minute);
        }
        else {
            min = Integer.toString(minute);
        }

        String newdate= "";
        newdate += Integer.toString(hour) + min;


        open("https://develop.web-v1.coffeemania.axept.com/");
        $x("//a[@href='/login']//img[1]").click();
        $("#input-phone").setValue("9917000320");
        $("#meetphone-submit-btn").click();
        $("#otc-1").click();
        $("#otc-1").setValue(newdate);
        sleep(10000);
        $(".ajaxClosePicker").click();
        $x("//a[@href='/cabinet']//img[1]").click();






    }


}
