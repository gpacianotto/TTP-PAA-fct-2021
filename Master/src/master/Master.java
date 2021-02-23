/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.util.Random;

/**
 *
 * @author SAMSUNG
 */

public class Master {

    /**
     * @param args the command line arguments
     */
    
    
    public static int[] geraNumeros(int[] aux ){
        Random gerador = new Random();
        
        for(int i = 0; i < aux.length; i++){
            aux[i] = gerador.nextInt(1000);
        }
        
        return aux;
        
    }
    public static void mostraNumeros(int[] aux ){
        
        
        for(int i = 0; i < aux.length; i++){
            System.out.print(aux[i] + "-");
        }
        
        
        
    }
    public static void main(String[] args) {
        final int limite = 100;
        
        int[] arranjo = new int[limite];
        
        arranjo = geraNumeros(arranjo);
        
        mostraNumeros(arranjo);
        
    }
    
}
