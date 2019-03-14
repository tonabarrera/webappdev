package me.tonatihu.controller;

import me.tonatihu.entity.CategoriaEntity;
import me.tonatihu.service.CategoriaService;
import me.tonatihu.util.Paginas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

        CategoriaService service = new CategoriaService();
        CategoriaEntity c = service.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("categoria", c);
        request.setAttribute("PAGINA", Paginas.VER_CATEGORIAS);
        request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
    }

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaService categoriaService = new CategoriaService();
        List<CategoriaEntity> lista = categoriaService.findAll();
        request.setAttribute("categorias", lista);
        request.setAttribute("PAGINA", Paginas.VER_CATEGORIAS);
        request.getRequestDispatcher("listaCategorias.jsp").forward(request, response);
    }

    private void crearCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("PAGINA", Paginas.AGREGAR_CATEGORIA);
        request.getRequestDispatcher("formCategoria.jsp").forward(request, response);
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        CategoriaService categoriaService = new CategoriaService();
        int id = Integer.parseInt(request.getParameter("id"));
        categoriaService.delete(id);
        response.sendRedirect("categorias?accion=ver");
    }

    private void almacenarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        CategoriaEntity c = new CategoriaEntity();
        CategoriaService service = new CategoriaService();
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            c.setNombre(request.getParameter("nombre"));
            c.setDescripcion(request.getParameter("descripcion"));
            service.persist(c);
        } else {
            c.setCategoriaId(Integer.parseInt(request.getParameter("id")));
            c.setNombre(request.getParameter("nombre"));
            c.setDescripcion(request.getParameter("descripcion"));
            service.update(c);
        }
        response.sendRedirect("categorias?accion=ver");
    }
}
