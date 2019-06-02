/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 */
public class Instituto {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SQLException, IOException {
        boolean continuar = true;
        int opcion = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarreraDAO dao = new CarreraDAO();
        Carrera carrera;

        while (continuar) {
            System.out.println("1) Alta carrera");
            System.out.println("2) Baja carrera");
            System.out.println("3) Cambio carrera");
            System.out.println("4) Consultar carrera");
            System.out.println("5) Consultar todas las carrera");
            System.out.println("6) Salir");
            System.out.println("Selecciona una opcion:");
            opcion = Integer.valueOf(br.readLine());
            switch(opcion) {
                case 1: // alta
                    System.out.println("ALTA");
                    carrera = new Carrera();
                    System.out.println("Ingrese la descripcion:");
                    carrera.setDescripcion(br.readLine());
                    System.out.println("Ingrese la duracion:");
                    carrera.setDuracion(Integer.valueOf(br.readLine()));
                    System.out.println("Ingrese el nombre:");
                    carrera.setNombre(br.readLine());
                    dao.create(carrera);
                    System.out.println("Listo...");
                    break;
                case 2: // baja
                    System.out.println("BAJA");
                    carrera = new Carrera();
                    System.out.println("Ingrese el id:");
                    carrera.setId(Integer.valueOf(br.readLine()));
                    dao.delete(carrera);
                    System.out.println("Listo...");
                    break;
                case 3: // cambio
                    System.out.println("CAMBIO");
                    carrera = new Carrera();
                    System.out.println("Ingrese el id:");
                    carrera.setId(Integer.valueOf(br.readLine()));
                    System.out.println("Ingrese la descripcion:");
                    carrera.setDescripcion(br.readLine());
                    System.out.println("Ingrese la duracion:");
                    carrera.setDuracion(Integer.valueOf(br.readLine()));
                    System.out.println("Ingrese el nombre:");
                    carrera.setNombre(br.readLine());
                    System.out.println("Listo...");
                    dao.update(carrera);
                    break;
                case 4: // consulta
                    System.out.println("CONSULTA");
                    carrera = new Carrera();
                    System.out.println("Ingrese el id:");
                    carrera.setId(Integer.valueOf(br.readLine()));
                    carrera = dao.read(carrera);
                    if (carrera != null)
                        System.out.println(carrera.toString());
                    System.out.println("Listo...");
                    break;
                case 5: // consulta todos
                    System.out.println("CONSULTAR TODOS");
                    List<Carrera> carreras = dao.readAll();
                    for (Carrera c : carreras) {
                        System.out.println(c.toString());
                    }
                    System.out.println("Listo");
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
        System.out.println("See you space cowboy...");
    }
}
