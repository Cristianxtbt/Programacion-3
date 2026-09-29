package ARREGLOSYMATRICES;

public class Matriz18 {
    public static void main(String[] args) {
        // Matriz 10x10 para almacenar la tabla de multiplicar
        int[][] tabla = new int[10][10];
 
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                tabla[i - 1][j - 1] = i * j;
            }
        }
 
        System.out.println("Tabla de multiplicar del 1 al 10:\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", tabla[i][j]);
            }
            System.out.println();
        }
    }
}