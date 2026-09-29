package ARREGLOSYMATRICES;

public class Arreglo11 {
    public static void main(String[] args) {
    
        //CREAR EL ARREGLO
        int [] a = new int[7];

        int max = 7;
        int min = -7;

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        //MOSTRAR AREGLO A
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        
        }

        //ARREGLO NEGATIVO, CERO Y POSITIVO
        int[] negative = new int[7];
        int[] cero = new int[7];
        int[] positive = new int[7];

        int negCount = 0;
        int ceroCount = 0;
        int posCount = 0;

        //RECORRER EL ARREGLO A Y LLENAR LOS ARREGLOS NEGATIVO, CERO Y POSITIVO
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                negative[negCount] = a[i];
                negCount++;
            } else if (a[i] == 0) {
                cero[ceroCount] = a[i];
                ceroCount++;    
            } else {
                positive[posCount] = a[i];
                posCount++;
            }
        }

        //MOSTRAR AREGLO NEGATIVO
        System.out.println("Arreglo Negativo:");
        for (int i = 0; i < negCount; i++) {
            System.out.println("negative[" + i + "]=" + negative[i]);
        
        }

        //MOSTRAR AREGLO CERO
        System.out.println("Arreglo Cero:");
        for (int i = 0; i < ceroCount; i++) {
            System.out.println("cero[" + i + "]=" + cero[i]);

        }

        //MOSTRAR AREGLO POSITIVO
        System.out.println("Arreglo Positivo:");
        for (int i = 0; i < posCount; i++) {
            System.out.println("positive[" + i + "]=" + positive[i]);
            
        }
    }
}