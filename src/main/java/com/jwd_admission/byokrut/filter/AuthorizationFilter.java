package com.jwd_admission.byokrut.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/home/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpSession session = ((HttpServletRequest) request).getSession();

        final Object role = session.getAttribute("role");
        final String command = request.getParameter("command");
        if (command.equals("show_personal_account")) {
            if (role == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("home?command=show_login");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else filterChain.doFilter(servletRequest, servletResponse);
    }
}
