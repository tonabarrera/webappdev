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

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "ver":
                listarCategorias(request, response);
                break;
            case "agregar":
                crearCategoria(request, response);
                break;
            case "eliminar":
                eliminarCategoria(request, response);
                break;
            case "guardar":
                almacenarCategoria(request, response);
                break;
            case "editar":
                editarCategoria(request, response);
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

    private void editarCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Categoria c = new Categoria();
        CategoriaDao d = new CategoriaDaoImpl();
        c.setId(Integer.parseInt(request.getParameter("id")));
        try {
            c = d.read(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("categoria", c);
        request.setAttribute("PAGINA", Paginas.VER_CATEGORIAS);
        request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
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

    private void crearCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("PAGINA", Paginas.AGREGAR_CATEGORIA);
        request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
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

    private void almacenarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Categoria c = new Categoria();
        CategoriaDao dao = new CategoriaDaoImpl();
        try {
            if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                c.setNombre(request.getParameter("nombre"));
                c.setDescripcion(request.getParameter("descripcion"));
                dao.create(c);
            } else {
                c.setId(Integer.parseInt(request.getParameter("id")));
                c.setNombre(request.getParameter("nombre"));
                c.setDescripcion(request.getParameter("descripcion"));
                dao.update(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listarCategorias(request, response);
    }
}
