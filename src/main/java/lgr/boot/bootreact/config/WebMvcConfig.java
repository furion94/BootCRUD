package lgr.boot.bootreact.config;

import lgr.boot.bootreact.interceptor.InterceptorTesting;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorTesting())
                .addPathPatterns("/*");
//                .excludePathPatterns("/test/**/") // 제외할 패턴
    }
    
}
