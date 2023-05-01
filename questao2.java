package com.mycompany.pratica3;
import java.util.Random;
/**
 *
 * @author Vitória Maria
 */
public class Questao2 {
    public static void main(String[] args) throws InterruptedException {
        Random aleatorio = new Random();
        int matriz[][] = new int[4][3];
        
        System.out.println("Matriz 3x4: \n");
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                matriz[i][j] = aleatorio.nextInt(100);
                System.out.print(matriz[i][j] + " ");
            }
        System.out.println(" ");
        }
        
        Thread[] threads = new Thread[3];
        for (int j=0;j<3;j++){
            final int col=j;
            threads[j] = new Thread(() -> {
                int top=0;
                int bottom=matriz.length-1;
                while (top<bottom) {
                    int temp=matriz[top][col];
                    matriz[top][col]=matriz[bottom][col];
                    matriz[bottom][col]=temp;
                    top++;
                    bottom--;
                }
            });
            threads[j].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("\nMatriz invertida: \n");        
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.print(matriz[i][j] + " ");
            }
        System.out.println(" ");
        }
    }  
}
