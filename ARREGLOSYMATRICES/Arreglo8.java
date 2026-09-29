package ARREGLOSYMATRICES;

public class Arreglo8 {
    public static void main(String[] args) {

        //CREAR EL ARREGLO
        int []  a = new int [30];

        int max = 30;
        int min = 1;

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * (max - min + 1)) + min;
        }

        //MOSTRAR EL ARREGLO
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        //MAYOR Y EL MENOR
        int mayor = a[0];
        int menor = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor) {
                mayor = a[i];
            }
            if (a[i] < menor) {
                menor = a[i];
            }
        }

        //NUMEROS QUE SE REPITEN
        int repetidosMayor = 0;
        int repetidosMenor = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == mayor) {
                repetidosMayor++;
            }
            if (a[i] == menor) {
                repetidosMenor++;
            }
        }

        //MOSTRAR EL MAYOR Y EL MENOR
        System.out.println("El mayor es: " + mayor + " y se repite: " + repetidosMayor + " veces");
        System.out.println("El menor es: " +
    menor + " y se repite: " + repetidosMenor + " veces");

    }
}