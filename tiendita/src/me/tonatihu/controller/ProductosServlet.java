package me.tonatihu.controller;

import me.tonatihu.dao.impl.ProductoDaoImpl;
import me.tonatihu.entity.CategoriaEntity;
import me.tonatihu.entity.ProductoEntity;
import me.tonatihu.service.CategoriaService;
import me.tonatihu.util.Paginas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

//@WebServlet(name = "ProductosServlet")
public class ProductosServlet extends HttpServlet {
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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "ver":
                listar(request, response);
                break;
            case "agregar":
                crear(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
        }
    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaService service = new CategoriaService();
        request.setAttribute("PAGINA", Paginas.AGREGAR_PRODUCTO);
        request.setAttribute("categorias", service.findAll());
        request.getRequestDispatcher("formProducto.jsp").forward(request, response);
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductoEntity producto = new ProductoEntity();
        ProductoDaoImpl productoDao = new ProductoDaoImpl();
        CategoriaEntity c = new CategoriaEntity();

        c.setCategoriaId(Integer.parseInt(request.getParameter("categoria")));

        producto.setNombre(request.getParameter("nombre"));
        producto.setDescripcion(request.getParameter("descripcion"));
        producto.setExistencia(Integer.parseInt(request.getParameter("existencia")));
        producto.setPrecio(BigDecimal.valueOf(Double.valueOf(request.getParameter("precio"))));
        producto.setCategoria(c);
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            productoDao.create(producto);
        } else {
            producto.setProductoId(Integer.parseInt(request.getParameter("id")));
            productoDao.update(producto);
        }
        response.sendRedirect("productos?accion=ver");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductoDaoImpl dao = new ProductoDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        ProductoEntity p = dao.findById(id);
        dao.delete(p);
        response.sendRedirect("productos?accion=ver");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDaoImpl dao = new ProductoDaoImpl();
        CategoriaService service = new CategoriaService();
        ProductoEntity p= dao.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("producto", p);
        request.setAttribute("categorias", service.findAll());
        request.setAttribute("PAGINA", Paginas.VER_PRODUCTOS);
        request.getRequestDispatcher("formProducto.jsp").forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("PAGINA", Paginas.VER_PRODUCTOS);
        ProductoDaoImpl dao = new ProductoDaoImpl();
        List<ProductoEntity> lista = ((ProductoDaoImpl) dao).findAll();
        request.setAttribute("productos", lista);
        request.getRequestDispatcher("listaProductos.jsp").forward(request, response);
    }

}
