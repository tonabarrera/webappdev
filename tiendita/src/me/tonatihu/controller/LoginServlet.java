package me.tonatihu.controller;

import me.tonatihu.dao.UsuarioDao;
import me.tonatihu.dao.impl.UsuarioDaoImpl;
import me.tonatihu.dto.Usuario;
import me.tonatihu.entity.UsuarioEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("logout");
        if (accion != null)
            logout(request, response);
        else {
            if (request.getMethod().equals("POST"))
                login(request, response);
            else
                request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        UsuarioDao dao = new UsuarioDaoImpl();
        String username = request.getParameter("username");
        String contra = request.getParameter("password");
        UsuarioEntity u = (UsuarioEntity) dao.findByUsernameAndContra(username, contra);
        if (u != null) {
            HttpSession session = request.getSession();
            Usuario usuario = new Usuario();
            usuario.setUsername(u.getUsername());
            usuario.setNombreCompleto(u.getNombre() + " " + u.getApPaterno() + " " + u.getApMaterno());
            session.setAttribute("USUARIO_SESSION", usuario);
            response.sendRedirect("home");
        } else {
            LOGGER.log(Level.WARNING, "You shall not pass!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
