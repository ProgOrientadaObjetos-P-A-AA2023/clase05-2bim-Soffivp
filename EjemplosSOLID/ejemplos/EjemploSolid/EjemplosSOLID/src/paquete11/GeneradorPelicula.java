/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.util.ArrayList;

public class GeneradorPelicula {

    private APIMovie llave;
    private String tipo;
    private String url;
    private String user;
    private ArrayList<GeneradorPelicula> lista;

    // agregar un user (tipo String)
    // Grupo1
    public void establecerLista(ArrayList<GeneradorPelicula> lis) {
        lista = lis;
    }

    public void establecerLlave(APIMovie l) { // APINetflix, APIAmazon
        llave = l;
    }

    public void establecerUrl() {
    
        url = String.format("http://api.movie?api=%s%s",obtenerTipo(), obtenerLlave().obtenerApiKey());
    
    }

    public void establecerUser(String us) {
        user = us;
    }

    public void establecerTipo(String t) {
        tipo = t;
    }

    public ArrayList<GeneradorPelicula> obtenerLista() {
        return lista;
    }

    public APIMovie obtenerLlave() {
        return llave;
    }

    public String obtenerUrl() {
        return url;
    }

    public String obtenerUser() {
        return user;
    }

    public String obtenerTipo() {
        return tipo;
    }

          @Override
    public String toString() {
        String cadena = "Lista Urls\n";

        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s %s\n", cadena,
                    obtenerLista().get(i).obtenerUrl());
        }

        return cadena;
    }
}
