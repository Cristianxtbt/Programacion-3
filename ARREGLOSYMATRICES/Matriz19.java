package ARREGLOSYMATRICES;

import java.util.Scanner;

public class Matriz19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número de filas (n): ");
        int n = sc.nextInt();
        System.out.print("Ingrese número de columnas (m): ");
        int m = sc.nextInt();
 
        int[][] matriz = new int[n][m];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    matriz[i][j] = 1; // Diagonal principal
                } else {
                    matriz[i][j] = 0; // Resto de elementos
                }
            }
        }
 
        System.out.println("\nMatriz generada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
 
        sc.close();
    }
}