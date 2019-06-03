/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiendita;

import dao.impl.CategoriaDAOImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import tiendita.entity.CategoriaEntity;

/**
 *
 * @author tonatihu
 * Created on 02-Jun-2019
 */
public class Tiendita {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
   public static void main(String[] args) throws IOException {
        boolean continuar = true;
        int opcion = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
        CategoriaEntity categoria;

        while (continuar) {
            System.out.println("1) Alta categoria");
            System.out.println("2) Baja categoria");
            System.out.println("3) Cambio categoria");
            System.out.println("4) Consultar categoria");
            System.out.println("5) Consultar todas las categorias");
            System.out.println("6) Salir");
            System.out.println("Selecciona una opcion:");
            opcion = Integer.valueOf(br.readLine());
            switch(opcion) {
                case 1: // alta
                    System.out.println("ALTA");
                    categoria = new CategoriaEntity();
                    System.out.println("Ingrese el nombre:");
                    categoria.setNombre(br.readLine());
                    System.out.println("Ingrese la descripcion:");
                    categoria.setDescripcion(br.readLine());
                    dao.create(categoria);
                    System.out.println("Listo...");
                    break;
                case 2: // baja
                    System.out.println("BAJA");
                    categoria = new CategoriaEntity();
                    System.out.println("Ingrese el id:");
                    categoria.setCategoriaId(Integer.valueOf(br.readLine()));
                    categoria = dao.findById(categoria.getCategoriaId());
                    dao.delete(categoria);
                    System.out.println("Listo...");
                    break;
                case 3: // cambio
                    System.out.println("CAMBIO");
                    categoria = new CategoriaEntity();
                    System.out.println("Ingrese el id:");
                    categoria.setCategoriaId(Integer.valueOf(br.readLine()));
                    System.out.println("Ingrese la descripcion:");
                    categoria.setDescripcion(br.readLine());
                    System.out.println("Ingrese el nombre:");
                    categoria.setNombre(br.readLine());
                    System.out.println("Listo...");
                    dao.update(categoria);
                    break;
                case 4: // consulta
                    System.out.println("CONSULTA");
                    categoria = new CategoriaEntity();
                    System.out.println("Ingrese el id:");
                    categoria.setCategoriaId(Integer.valueOf(br.readLine()));
                    categoria = dao.findById(categoria.getCategoriaId());
                    if (categoria != null)
                        System.out.println(categoria.toString());
                    System.out.println("Listo...");
                    break;
                case 5: // consulta todos
                    System.out.println("CONSULTAR TODOS");
                    List<CategoriaEntity> categorias = dao.findAll();
                    for (CategoriaEntity c : categorias) {
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
