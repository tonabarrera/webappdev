package me.tonatihu.controller;

import me.tonatihu.dao.impl.ProductoDaoImpl;
import me.tonatihu.dto.Dato;
import me.tonatihu.util.EnvioEmail;
import me.tonatihu.util.Paginas;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
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
        switch (accion) {
            case "ver":
                ver(request, response);
                break;
            case "generar":
                generar(request, response);
                break;
            case "enviar":
                enviar(request, response);
                break;
            default:
                request.getRequestDispatcher("graficas.jsp").forward(request, response);
                break;
        }
    }

    private void enviar(HttpServletRequest request, HttpServletResponse response) {
        String template = getServletConfig().getServletContext().getRealPath("/static/templates");
        String grafica = getServletConfig().getServletContext()
                .getRealPath("/static/templates/grafica.png");
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(template,
                    "tienditaChida.jasper"));
            Map<String, Object> datos = obtenerDatos();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datos,
                    new JREmptyDataSource());
            File archivo  = new File(template, "reporte.pdf");
            LOGGER.log(Level.INFO, "Tamaño 1: " + archivo.length());
            OutputStream out = new FileOutputStream(archivo);
            LOGGER.log(Level.INFO, "Tamaño 2: " + archivo.length());
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            LOGGER.log(Level.INFO, "Tamaño 3: " + archivo.length() + " " + archivo.getAbsolutePath());

            EnvioEmail email = new EnvioEmail();
            Map<String, String> imagenesMap = new HashMap<>();
            Map<String, String> archivosMap = new HashMap<>();
            String mensaje = "<h1>Bienvenido a Tiendita</h1><br>" +
                    "<p>Te mandamos un reporte.pdf solo por los memes</p><img src=\"cid:grafica\"/>";
            imagenesMap.put("grafica", grafica);
            archivosMap.put("Reporte.pdf", archivo.getAbsolutePath());
            email.setAsunto("A tus ordenes chichona");
            email.setDestinatario("carlostonatihu@gmail.com");
            email.setMensaje(mensaje);
            email.enviar(imagenesMap, archivosMap);
            if (archivo.delete())
                LOGGER.log(Level.INFO, "Archivo eliminado");
            else
                LOGGER.log(Level.SEVERE, "Archivo no eliminado");
        } catch (JRException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Map<String, Object>  obtenerDatos() {
        ProductoDaoImpl dao = new ProductoDaoImpl();
        List<Dato> datos = dao.getDatos();
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
        String grafica = getServletConfig().getServletContext()
                .getRealPath("/static/templates/grafica.png");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ds", ds);
        parametros.put("logo", grafica);

        return parametros;
    }

    private void generar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            String template = getServletConfig().getServletContext().getRealPath("/static/templates");
            JasperReport jasperReport  = (JasperReport) JRLoader.loadObject(new File(template,
                    "tienditaChida.jasper"));
            Map<String, Object> datos = obtenerDatos();
            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, datos, new JREmptyDataSource());
            OutputStream outStream = response.getOutputStream();
            response.setHeader("Content-Disposition","inline, filename=reporte.pdf");
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            outStream.write(byteStream,0,byteStream.length);
        } catch (JRException e) {
            e.printStackTrace();
        }
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
