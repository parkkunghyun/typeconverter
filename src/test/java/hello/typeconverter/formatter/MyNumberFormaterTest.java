package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormaterTest {
    MyNumberFormater formater = new MyNumberFormater();
    @Test
    void parse() throws ParseException {
        Number result = formater.parse("1,000", Locale.KOREA);
        Assertions.assertThat(result).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result =formater.print(1000, Locale.KOREA);
        Assertions.assertThat(result).isEqualTo("1,000");

    }
}