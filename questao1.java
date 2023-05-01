package com.mycompany.pratica3;
import java.util.Random;
/**
 *
 * @author Vitória Maria
 */
public class Pratica3 {

    public static void main(String[] args) throws InterruptedException {
        Random aleatorio = new Random();
        int array[] = new int[1000];
        int array2[] = new int [1000];
   
        System.out.println("Array 1: 1000 numeros aleatorios: \n");
            for (int i=0;i<1000;i++) {
                array[i] = aleatorio.nextInt(1000);
                System.out.println(array[i]);
            }
        
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++) {
            final int inicio=i*100;
            final int fim=(i+1)*100;
            threads[i] = new Thread(()->{
                int index=0;
                for (int j=inicio;j<fim;j++) {
                    if (array[j]%3==0 && array[j]%7==0) {
                        array2[inicio+index++]=array[j];
                    }
                }
            });
            threads[i].start();
        }
   
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("\nArray 2: numeros do array 1 que sao multiplos de 3 e 7: \n");
            for (int i=0;i<array2.length;i++) {
                if (array2[i]!=0) {
                    System.out.println(array2[i]);
                }
            }
    }
}
