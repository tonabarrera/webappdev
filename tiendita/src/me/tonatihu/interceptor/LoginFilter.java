package me.tonatihu.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(LoginFilter.class.getName());

    private static final String[] noRequiereLogin = {
            "/static", "/login",
    };

    public void destroy() {
        LOGGER.log(Level.INFO, "Metodo destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("USUARIO_SESSION") != null);

        String url = request.getRequestURI();
        String logout = request.getParameter("logout");
        LOGGER.log(Level.INFO, "La ruta es: " + url);
        if (isLoggedIn && url.equals("/tiendita/login") && logout == null) {
            LOGGER.log(Level.INFO, "Ya inicio sesion pero quiere hacerlo otra vez");
            response.sendRedirect("home");
        }else if(isLoggedIn || url.equals("/tiendita/login") || loginRequerido(request)) {
            LOGGER.log(Level.INFO, "Quiere acceder a cualquier pagina o al login");
            chain.doFilter(req, resp);
        } else {
            LOGGER.log(Level.INFO, "No inicio sesion y se salta el login");
            response.sendRedirect("login");
        }
    }

    private boolean loginRequerido(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        for (String url : noRequiereLogin) {
            if (requestURL.contains(url))
                return true;
        }
        return false;
    }

    public void init(FilterConfig config) {
        LOGGER.log(Level.INFO, "Metodo  init");
    }

}
