package md.springboot.webservice.config.filter;

import md.springboot.business.impl.TokenAuthenticationBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by veladii on 31.08.2018
 */
@Component
public class StatelessAuthFilter extends GenericFilterBean {

    @Autowired
    private TokenAuthenticationBusiness tokenAuthenticationBusiness;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContextHolder
                .getContext()
                .setAuthentication(tokenAuthenticationBusiness.getAuthentication((HttpServletRequest) request).orElse(null));
        chain.doFilter(request, response);
    }
}
