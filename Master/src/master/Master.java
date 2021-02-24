/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author SAMSUNG
 */

public class Master {

    /**
     * @param args the command line arguments
     */
    
    
    public static int[] geraNumeros(int[] aux, int limite ){
        Random gerador = new Random();
        
        for(int i = 0; i < aux.length; i++){
            aux[i] = gerador.nextInt(limite * 10);
        }
        
        return aux;
        
    }
    static int[] reverse(int a[], int n) 
    { 
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
  
        return b;
    } 
    
    public static void mostraNumeros(int[] aux ){
        
        
        for(int i = 0; i < aux.length; i++){
            System.out.print(aux[i] + "-");
        }
        System.out.println();
        
        
    }
    
    private static int[] quickSort(int[] vetor, int inicio, int fim) {
             if (inicio < fim) {
                    int posicaoPivo = separar(vetor, inicio, fim);
                    quickSort(vetor, inicio, posicaoPivo - 1);
                    quickSort(vetor, posicaoPivo + 1, fim);
             }
             
             return vetor;
       }

       private static int separar(int[] vetor, int inicio, int fim) {
             int pivo = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                    if (vetor[i] <= pivo)
                           i++;
                    else if (pivo < vetor[f])
                           f--;
                    else {
                           int troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivo;
             return f;
       }
    
    public static void main(String[] args) {
        final int limite = 9000;
        
        int[] arranjo = new int[limite];
        int[] arranjoInverso = new int[limite];
        int[] arranjoCrescente = new int[limite];
        
        long nanosegundos;
        double segundos;
        
        arranjo = geraNumeros(arranjo, limite);
        long start = System.nanoTime();    
        arranjoCrescente = quickSort(arranjo, 0, limite-1);
        nanosegundos = System.nanoTime() - start;
        segundos = (double)nanosegundos/1000000000;
        
        
        arranjoInverso = reverse(arranjo, limite);
        System.out.println("demorou: " + nanosegundos + " nano segundos");
        System.out.println("Equivalente a "+ segundos+" segundos");
        System.out.println(Integer.MAX_VALUE);
        //mostraNumeros(arranjoInverso);
        
    }
    
}
