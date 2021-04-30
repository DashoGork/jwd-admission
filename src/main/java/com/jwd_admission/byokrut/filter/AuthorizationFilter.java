package com.jwd_admission.byokrut.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/home?command=show_personal_account")
public class AuthorizationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ddd");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        final HttpSession session=((HttpServletRequest)request).getSession();

        final Object role = session.getAttribute("role");
        if(role==null){
            ((HttpServletResponse)servletResponse).sendRedirect("/WEB-INF/jsp/main.jsp");
            System.out.println(" ffff");
        }
        else{
            System.out.println(role+" ffff");
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
