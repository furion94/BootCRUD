package lgr.boot.bootreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BootreactApplication {

    private static final String DB_CONFIG = "spring.config.location=" + "classpath:application.yml,"
            + "classpath:db-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootreactApplication.class)
                .properties(DB_CONFIG)
                .run(args);
//        SpringApplication.run(BootreactApplication.class, args);
    }

}
