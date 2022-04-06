import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;


class DeliveryCardTest {

    @Test
    void shouldDeliveryCArd() {
        holdBrowserOpen = true;
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").val("Краснодар");
        $x("//input[@placeholder='Дата встречи']").click();
        $x("//input[@placeholder='Дата встречи']").doubleClick();
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $x("//input[@placeholder='Дата встречи']").val("22.04.2022");
        $x("//input[@name='name']").val("Ленин Владимир");
        $x("//input[@name='phone']").val("+79180000001");
        $x("//*[@class='checkbox__box']").click();
        $(withText("Забронировать")).click();
        $x("//*[contains(text(),'Успешно!')]").should(Condition.appear, Duration.ofSeconds(15));
    }

}