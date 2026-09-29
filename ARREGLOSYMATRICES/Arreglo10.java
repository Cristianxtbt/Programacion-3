package ARREGLOSYMATRICES;

public class Arreglo10 {
    public static void main(String[] args) {
    
        //CREAR EL ARREGLO
        int [] a = {8,5,3,10,2,8,1};

        //MOSTRAR AREGLO A
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }  

        //ARREGLO B
        int bLength = a.length / 2;

        //SI ES IMPAR, SUMAMOS 1 PARA QUE ENTRE EL ELEMENTO DEL MEDIO
        if (a.length % 2 != 0) {
            bLength = bLength + 1;
        }

        int[] b = new int[bLength];

        //SUMAMOS LAS PAREJAS DE OPUESTOS
        for (int i = 0; i < a.length / 2; i++) {
            b[i] = a[i] + a[a.length - 1 - i];
        }

        //SI ES IMPAR, EL ELEMENTO DEL MEDIO SE COPIA SOLO (NO TIENE PAREJA)
        if (a.length % 2 != 0) {
            b[b.length - 1] = a[a.length / 2];
        }

        //MOSTRAR AREGLO B
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]); 
        }
    }
}