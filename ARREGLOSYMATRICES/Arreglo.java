package ARREGLOSYMATRICES;

public class Arreglo {
    public static void main(String[] args) {

        //CREAR EL ARREGLO
        int [] a = new int [10];

        int max = 10;
        int min = 1;

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * (max - min + 1)) + min;
        }

        //MOSTRAR EL ARREGLO
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);

}

        //ARREGLOS
        int [] pares = new int [10];
        int [] impares = new int [10];

        int arregloPares = 0;
        int arregloImpares = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                pares[arregloPares] = a[i];
                arregloPares++;
            } else {
                impares[arregloImpares] = a[i];
                arregloImpares++;
            }
        }

        //MOSTRAR ARREGLO PARES
        System.out.println("Arreglo de pares: ");
        for (int i = 0; i < arregloPares; i++) {
            System.out.println("pares[" + i + "]=" + pares[i]);
        }

        //MOSTRAR ARREGLO IMPARES
        System.out.println("Arreglo de impares: ");
        for (int i = 0; i < arregloImpares; i++) {
            System.out.println("impares[" + i + "]=" + impares[i]);
        }
    }
}
        