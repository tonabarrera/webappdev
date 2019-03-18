package me.tonatihu.controller;

import me.tonatihu.dao.impl.UsuarioDaoImpl;
import me.tonatihu.dto.Usuario;
import me.tonatihu.entity.UsuarioEntity;
import me.tonatihu.util.Paginas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "PerfilServlet")
public class PerfilServlet extends HttpServlet {
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
        HttpSession session = request.getSession(false);
        Usuario u = (Usuario) session.getAttribute("USUARIO_SESSION");
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        UsuarioEntity usuario = usuarioDao.findById(u.getUsername());
        request.setAttribute("usuario", usuario);
        request.setAttribute("PAGINA", Paginas.PERFIL);
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
    }
}
