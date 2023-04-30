package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        DefaultConversionService conversionService= new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        // 사용
        Integer result = conversionService.convert("10", Integer.class);
        Assertions.assertThat(result).isEqualTo(10);
        IpPort p = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(p).isEqualTo(new IpPort("127.0.0.1", 8080));
        // 인자와 반환타입
    }
}
