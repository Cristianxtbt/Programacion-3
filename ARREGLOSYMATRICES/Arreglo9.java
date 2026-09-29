package ARREGLOSYMATRICES;

public class Arreglo9 {
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

        //NUMERO ENTERO RANDOM
        int random = (int)(Math.random() * (max - min + 1)) + min;

        //NUMERO DE VECES QUE SE REPITE EL NUMERO RANDOM
        int repetidosRandom = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == random) {
                repetidosRandom++;
            }
        }
        //MOSTRAR EL NUMERO RANDOM Y EL NUMERO DE VECES QUE SE REPITEN
        System.out.println("El numero random es: " + random + " y se repite: " + repetidosRandom + " veces");
    }

    }