package lgr.boot.bootreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BootreactApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootreactApplication.class, args);
    }

}
