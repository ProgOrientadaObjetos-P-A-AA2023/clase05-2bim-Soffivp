/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
         String nombreArchivo = "usuarios.txt";
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.establecerLista();
        GeneradorPelicula pelicula = new GeneradorPelicula();
        // LISTA ASIGNADA
        pelicula.establecerLista(lectura.obtenerLista());
        System.out.println(pelicula);
        
    }
}
