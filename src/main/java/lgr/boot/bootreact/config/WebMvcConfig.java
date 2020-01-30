package lgr.boot.bootreact.config;

import lgr.boot.bootreact.filter.FilterTesting;
import lgr.boot.bootreact.interceptor.InterceptorTesting;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorTesting())
                .addPathPatterns("/*");
//                .excludePathPatterns("/") // 제외할 패턴
    }

    @Bean
    public FilterRegistrationBean<FilterTesting> filterDo(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FilterTesting());
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
