/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public final class LecturaArchivo {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<GeneradorPelicula> lista;

    public LecturaArchivo(String n) {
        nombreArchivo = n;

        rutaArchivo = String.format("datos/%s", obtenerNombreArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("datos/%s.txt",
                obtenerNombreArchivo());
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

   public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));

                GeneradorPelicula p = new GeneradorPelicula();

                if (linea_partes.get(2).equals("Netflix")) {
                    APINetflix api = new APINetflix();
                   
                    api.establecerApiKey();
                    p.establecerTipo(linea_partes.get(2));
                    p.establecerLlave(api);
                   
                    p.establecerUrl();
                    lista.add(p);
                }

                if (linea_partes.get(2).equals("Disney")) {
                    APIDisney api = new APIDisney();
                  
                    api.establecerApiKey();
                    p.establecerTipo(linea_partes.get(2));

                    p.establecerLlave(api);
                    
                    p.establecerUrl();
                    lista.add(p);
                }

                if (linea_partes.get(2).equals("Amazon")) {
                    APIAmazonMovie api = new APIAmazonMovie();
                   
                    api.establecerApiKey();
                    p.establecerTipo(linea_partes.get(2));

                    p.establecerLlave(api);
                   
                    p.establecerUrl();
                    lista.add(p);
                }

                if (linea_partes.get(2).equals("Startplus")) {
                    APIStarPlus api = new APIStarPlus();
                  
                    api.establecerApiKey();
                    p.establecerTipo(linea_partes.get(2));

                    p.establecerLlave(api);
                   
                    p.establecerUrl();
                    lista.add(p);
                }

            }
        }
    }

    public ArrayList<GeneradorPelicula> obtenerLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo

    }


}
