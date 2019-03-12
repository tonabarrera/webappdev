package controller;

import dao.CategoriaDao;
import dao.impl.CategoriaDaoImpl;
import dto.Categoria;
import util.Paginas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CategoriasServlet")
public class CategoriasServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "ver":
                listarCategorias(request, response);
                break;
            case "nuevaCategoria":
                crearCategoria(request, response);
                break;
            case "eliminarCategoria":
                eliminarCategoria(request, response);
                break;
            case "guardar":
                almacenarCategoria(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response) {
        try {
            CategoriaDao dao = new CategoriaDaoImpl();
            List<Categoria> lista = dao.readAll();
            request.setAttribute("categorias", lista);
            request.setAttribute("PAGINA", Paginas.VER_CATEGORIAS);
            request.getRequestDispatcher("listaCategorias.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(CategoriasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearCategoria(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) {
        try {
            CategoriaDao dao = new CategoriaDaoImpl();
            Categoria c = new Categoria();
            int id = Integer.parseInt(request.getParameter("id"));
            c.setId(id);
            c = dao.read(c);
            dao.delete(c);
            listarCategorias(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasServlet.class.getName()).log(Level.SEVERE,
                    "Error en eliminarCategoria", ex);
        }
    }

    private void almacenarCategoria(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
