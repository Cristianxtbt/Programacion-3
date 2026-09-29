package ARREGLOSYMATRICES;

import java.util.Scanner;

public class Matriz {
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
 
        // Suma de cada fila
        int[] sumaFilas = new int[filas];
        for (int i = 0; i < filas; i++) {
            int suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
            sumaFilas[i] = suma;
        }
 
        // Suma de cada columna
        int[] sumaColumnas = new int[columnas];
        for (int j = 0; j < columnas; j++) {
            int suma = 0;
            for (int i = 0; i < filas; i++) {
                suma += matriz[i][j];
            }
            sumaColumnas[j] = suma;
        }
 
        System.out.println("\nSuma de cada fila:");
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + i + ": " + sumaFilas[i]);
        }
 
        System.out.println("\nSuma de cada columna:");
        for (int j = 0; j < columnas; j++) {
            System.out.println("Columna " + j + ": " + sumaColumnas[j]);
        }
 
        sc.close();
    }
}