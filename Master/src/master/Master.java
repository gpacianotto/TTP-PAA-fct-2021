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
       public static int[] quickSort2(int[] arr, int low, int high) 
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return new int[0];
        }
         
        if (low >= high){
            return new int[0];
        }
 
        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
 
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) 
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) 
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) 
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (i <= j) 
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
        return arr;
    }
     
    public static void swap (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    public static int[] bubbleSort(int[] v) {
    // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
    for(int i = 0; i < v.length - 1; i++) {
      // for utilizado para ordenar o vetor.
      for(int j = 0; j < v.length - 1 - i; j++) {
        /* Se o valor da posição atual do vetor for maior que o proximo valor,
          então troca os valores de lugar no vetor. */
        if(v[j] > v[j + 1]) {
          int aux = v[j];
          v[j] = v[j + 1];
          v[j + 1] = aux;
        }
        }
        }
    return v;
    }
    public static int[] selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }
        return arr;
    }
    public static int[] shellSort(int arrayToSort[]) {
    int n = arrayToSort.length;

    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int key = arrayToSort[i];
            int j = i;
            while (j >= gap && arrayToSort[j - gap] > key) {
                arrayToSort[j] = arrayToSort[j - gap];
                j -= gap;
            }
            arrayToSort[j] = key;
        }
    }
    return arrayToSort;
    }
    
       private static void autoCountRandom(int limite, String algorythm, int numberOfTests){
           
           for(int i = 0; i < numberOfTests; i++)
           {
               int[] arranjo = new int[limite];
           int[] arranjoDecrescente = new int[limite];
           int[] arranjoCrescente = new int[limite];
        
        
        
            arranjo = geraNumeros(arranjo, limite);
          
            arranjoCrescente = quickSort(arranjo, 0, limite-1);      

            arranjoDecrescente = reverse(arranjo, limite);
                long milisec;
                double segundos;
                int[] aux;
                
                
                switch(algorythm){
                    case "quickSort":
                        //aleatorio
                        long start = System.currentTimeMillis();
                        aux = quickSort(arranjo, 0, arranjo.length - 1);
                        milisec = System.currentTimeMillis() - start;
                        segundos = (double)milisec/1000;
                        System.out.println("Milisegundos: "+milisec+" Segundos: "+segundos);
                        break;
                    case "quickSort2":
                        start = System.currentTimeMillis();
                        aux = quickSort2(arranjo, 0, arranjo.length - 1);
                        milisec = System.currentTimeMillis() - start;
                        segundos = (double)milisec/1000;
                        System.out.println("Milisegundos: "+milisec+" Segundos: "+segundos);
                        break;
                    case "bubbleSort":
                        start = System.currentTimeMillis();
                        aux = bubbleSort(arranjo);
                        milisec = System.currentTimeMillis() - start;
                        segundos = (double)milisec/1000;
                        System.out.println("Milisegundos: "+milisec+" Segundos: "+segundos);
                        break;
                    case "selectionSort":
                        start = System.currentTimeMillis();
                        aux = selectionSort(arranjo);
                        milisec = System.currentTimeMillis() - start;
                        segundos = (double)milisec/1000;
                        System.out.println("Milisegundos: "+milisec+" Segundos: "+segundos);
                        break;
                    case "shellSort":
                        start = System.currentTimeMillis();
                        aux = shellSort(arranjo);
                        milisec = System.currentTimeMillis() - start;
                        segundos = (double)milisec/1000;
                        System.out.println("Milisegundos: "+milisec+" Segundos: "+segundos);
                        break;
                }
           }
           
       }
    
    public static void main(String[] args) {
        final int limite = 50000;
        
        //limite de quickSort maximo é 7500, se não da stack overflow
        //limite de quickSort2 maximo é 15400, se não da stack overflow
        
        autoCountRandom(limite, "shellSort", 10);
        
        //valor maximo de int
        System.out.println(Integer.MAX_VALUE);
        
    }
    
}
