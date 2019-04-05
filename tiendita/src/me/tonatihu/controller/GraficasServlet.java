package me.tonatihu.controller;

import me.tonatihu.dao.impl.ProductoDaoImpl;
import me.tonatihu.dto.Dato;
import me.tonatihu.util.Paginas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

// 1 2 3 4 5
public class GraficasServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(GraficasServlet.class.getName());

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        request.setAttribute("PAGINA", Paginas.GRAFICAS);
        if (accion.equals("ver"))
            ver(request, response);
        else if (accion.equals("generar"))
            enviar(request, response);
        else
            request.getRequestDispatcher("graficas.jsp").forward(request, response);
    }

    private void enviar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String ruta = getServletConfig().getServletContext()
                .getRealPath("/static/template/reporte.jaster");
        File reporte = new File(ruta, "reporte.pdf");
        try {
            JasperFillManager.fillReportToFile(reporte.getAbsolutePath(), new HashMap<>());
        } catch (JRException e) {
            e.printStackTrace();
        }

        response.sendRedirect("graficas?accion=ver");
    }

    private void ver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("PAGINA", Paginas.GRAFICAS);
        ProductoDaoImpl dao = new ProductoDaoImpl();
        List<Dato> datos = dao.getDatos();
        request.setAttribute("lista", datos);
        generarGrafica(datos);
        request.getRequestDispatcher("graficas.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void generarGrafica(List<Dato> datos) throws IOException {
        DefaultPieDataset dpd = new DefaultPieDataset();
        datos.forEach((d) -> {
            dpd.setValue(d.getNombre(), d.getCantidad());
        });

        String ruta = getServletConfig().getServletContext().getRealPath("/static/img");
        File fileGrafica = new File(ruta, "grafica.png");
        JFreeChart chart = ChartFactory.createPieChart("Productos y Categorias", dpd,
                true, true, false);
        ChartUtilities.saveChartAsPNG(fileGrafica, chart, 400, 300);
    }
}
