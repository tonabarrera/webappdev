/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tonatihu
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    
    private static final boolean DEBUG = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthenticationFilter() {
    }
    private static final String[] NO_REQUIERE_LOGIN = {
            "/static", "/login", "/signup", "forgotPassword",
    };
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (DEBUG) {
            log("AuthenticationFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (DEBUG) {
            log("AuthenticationFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param req The servlet request we are processing
     * @param resp The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, 
            FilterChain chain) throws IOException, ServletException {
        if (DEBUG) {
            log("AuthenticationFilter:doFilter()");
        }
        doBeforeProcessing(req, resp);
        
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("USUARIO_SESSION") != null);

        String url = request.getRequestURI();
        String logout = request.getParameter("logout");
        if (isLoggedIn && url.equals("/instituto/login") && logout == null) {
            if (DEBUG)
                log("Ya inicio sesion pero quiere hacerlo otra vez");
            response.sendRedirect("home");
        }else if(isLoggedIn || url.equals("/instituto/login") || loginRequerido(request)) {
            if (DEBUG)
                log("Quiere acceder a cualquier pagina o al login");
            chain.doFilter(req, resp);
        } else {
            if (DEBUG)
                log("No inicio sesion y se salta el login");
            response.sendRedirect("login");
        }
        
        doAfterProcessing(req, resp);
    }
    
    private boolean loginRequerido(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        for (String url : NO_REQUIERE_LOGIN) {
            if (requestURL.contains(url))
                return true;
        }
        return false;
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (DEBUG) {                
                log("AuthenticationFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     * @return 
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthenticationFilter()");
        }
        StringBuilder sb = new StringBuilder("AuthenticationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
