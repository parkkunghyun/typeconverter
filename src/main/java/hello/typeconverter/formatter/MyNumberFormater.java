package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormater implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locatle={}",text,locale);
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
        // 1,00처럼 중간 쉼표를 적용하려면 넘버 포맷 사용! 각 나라마다 다르게 하기 위헤 로케일 사용!
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}",object,locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
