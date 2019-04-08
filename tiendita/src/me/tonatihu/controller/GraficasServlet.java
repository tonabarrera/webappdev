package me.tonatihu.controller;

import me.tonatihu.dao.impl.ProductoDaoImpl;
import me.tonatihu.dto.Dato;
import me.tonatihu.util.Paginas;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String rutaTemplate = getServletConfig().getServletContext()
                .getRealPath("/static/templates");
        String rutaGrafica = getServletConfig().getServletContext()
                .getRealPath("/static/templates/grafica.png");
        ProductoDaoImpl dao = new ProductoDaoImpl();
        List<Dato> datos = dao.getDatos();
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(rutaTemplate, "tienditaChida.jasper"));
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ds", ds);
            parameters.put("logo", rutaGrafica);
            /*
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    new JREmptyDataSource());
            OutputStream out = new FileOutputStream(new File(rutaTemplate, "reporte.pdf"));
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            */
            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, new JREmptyDataSource());

            OutputStream outStream = response.getOutputStream();
            response.setHeader("Content-Disposition","inline, filename=reporte.pdf");
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            outStream.write(byteStream,0,byteStream.length);
        } catch (JRException | FileNotFoundException e) {
            e.printStackTrace();
        }
        //response.sendRedirect("graficas?accion=ver");
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
        String rutaTemplate = getServletConfig().getServletContext()
                .getRealPath("/static/templates");
        File fileGrafica = new File(ruta, "grafica.png");
        File graficaTemplate = new File(rutaTemplate, "grafica.png");
        JFreeChart chart = ChartFactory.createPieChart("Productos y Categorias", dpd,
                true, true, false);
        ChartUtilities.saveChartAsPNG(fileGrafica, chart, 400, 300);
        ChartUtilities.saveChartAsPNG(graficaTemplate, chart, 400, 300);
    }
}
