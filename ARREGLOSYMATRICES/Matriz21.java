package ARREGLOSYMATRICES;

import java.util.Scanner;

public class Matriz21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el orden M de la matriz cuadrada (M x M): ");
        int M = sc.nextInt();
 
        int[][] matriz = new int[M][M];
        int[] vectorB = new int[M];
 
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
 
        // Cada componente de B es la suma de los valores pares de esa fila
        for (int i = 0; i < M; i++) {
            int sumaPares = 0;
            for (int j = 0; j < M; j++) {
                if (matriz[i][j] % 2 == 0) {
                    sumaPares += matriz[i][j];
                }
            }
            vectorB[i] = sumaPares;
        }
 
        System.out.println("\nVector B (suma de elementos pares por fila):");
        for (int i = 0; i < M; i++) {
            System.out.println("B[" + i + "] = " + vectorB[i]);
        }
 
        sc.close();
    }
}