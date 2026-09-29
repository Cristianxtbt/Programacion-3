package ARREGLOSYMATRICES;

public class Matriz20 {
    public static void main(String[] args) {
        int n = 10;
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 1;
                }
            }
        }
 
        System.out.println("Matriz 10x10 con ceros en la diagonal principal hacia arriba:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}