package ARREGLOSYMATRICES;
public class Arreglo12 {
    public static void main(String[] args) {
    
        //CREAR EL ARREGLO
        int [] a = {4,6,8,2,6,9,6,1};

        //VALOR DADO x
        int x = 6;

        //MOSTRAR ARREGLO A
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        //ARREGLO B PARA GUARDAR POSICION
        int[] b = new int[a.length];
        int count = 0;

        //RECORRER EL ARREGLO A Y GUARDAR POSICION EN B
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                b[count] = i;
                count++;
    }
}

        //MOSTRAR ARREGLO B
        System.out.println("Posiciones donde se encuentra el valor " + x + ":");
        for (int i = 0; i < count; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }
    }
}