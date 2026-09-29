package ARREGLOSYMATRICES;

import java.util.Scanner;

public class Matriz22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int columnas = sc.nextInt();
 
        int[][] matriz = new int[filas][columnas];
 
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
 
        System.out.println("\nMatriz completa:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
 
        System.out.println("\nElementos con su posición:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Posición [" + i + "][" + j + "] = " + matriz[i][j]);
            }
        }
 
        sc.close();
    }
}