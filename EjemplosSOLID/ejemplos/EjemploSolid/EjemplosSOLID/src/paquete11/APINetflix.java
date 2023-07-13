/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.util.Random;


public class APINetflix implements APIMovie{
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(){ 
        Random r = new Random();
        String random = String.format("%d",  r.nextInt(15121644));
        apiKey = random;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }

    
}
