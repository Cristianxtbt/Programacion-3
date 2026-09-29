package ARREGLOSYMATRICES;

public class Arreglo13 {
    public static void main(String[] args) {
    
        //CREAR EL ARREGLO
        int [] a = new int [20];

        int max = 20;
        int min = 1;

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        //MOSTRAR AREGLO A
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        //SUMA DE LOS ELEMENTOS DEL ARREGLO A
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }

        double promedio = (double) suma / a.length;
        System.out.println("Suma de los elementos del arreglo A: " + suma);
        System.out.println("Promedio de los elementos del arreglo A: " + promedio);

        //ARREGLO PARA MAYORES Y MENORES AL PROMEDIO
        int[] mayores = new int[a.length];
        int[] menores = new int[a.length];

        int countMayores = 0;
        int countMenores = 0;

        //RECORRER EL ARREGLO A Y LLENAR LOS ARREGLOS MAYORES Y MENORES AL PROMEDIO
        for (int i = 0; i < a.length; i++) {
            if (a[i] > promedio) {
                mayores[countMayores] = a[i];
                countMayores++;
            } else if (a[i] < promedio) {
                menores[countMenores] = a[i];
                countMenores++;
        
        //MOSTRAR ARREGLO MAYORES
        for (int c = 0; c < countMayores; c++) {
            System.out.println("mayores[" + c + "]=" + mayores[c]);
        }
        
        //MOSTRAR ARREGLO MENORES
        for (int b = 0; b < countMenores; b++) {
            System.out.println("menores[" + b + "]=" + menores[b]);
        }
    }
}
    }
}