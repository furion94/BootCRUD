package lgr.boot.bootreact.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:common.properties", encoding = "UTF-8")
public class TestingBean {

    @Value("${test.gg}")
    private String str;

    public void testtt(){
        System.out.println(str);
    }

}
