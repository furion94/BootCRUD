package lgr.boot.bootreact.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@Slf4j
public class FilterTesting implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("Filter : ").append(request.getRemoteAddr()).append(" : ").append(request.getRequestURL().toString());

        log.info(sBuffer.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
