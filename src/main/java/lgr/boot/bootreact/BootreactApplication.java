package lgr.boot.bootreact;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@ServletComponentScan
public class BootreactApplication {

    private static final String CONFIG = "spring.config.location=" + "classpath:application.yml,"
            + "classpath:db-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootreactApplication.class)
                .properties(CONFIG)
                .run(args);
    }

}
