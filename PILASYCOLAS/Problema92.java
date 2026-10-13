import java.util.Scanner;

// 9.2: ¿la cadena es de la forma X&Y, con Y = X al revés?
public class Problema92 {

    // Pila simple (guarda enteros; los caracteres también caben)
    static class Pila {
        int[] datos;
        int cantidad = 0;

        Pila(int capacidad) {
            datos = new int[capacidad];
        }

        void push(int x) {
            if (cantidad == datos.length) {
                System.out.println("Pila llena, no se puede agregar " + x);
            } else {
                datos[cantidad] = x;
                cantidad++;
            }
        }

        int pop() {
            if (cantidad == 0) {
                System.out.println("Pila vacía");
                return -1;
            }
            cantidad--;
            return datos[cantidad];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe la cadena (ej: abc&cba): ");
        String cad = sc.nextLine();

        Pila pila = new Pila(cad.length() + 1);
        int i = 0;

        // 1. Apilar todo lo que está antes del '&'
        while (i < cad.length() && cad.charAt(i) != '&') {
            pila.push(cad.charAt(i));
            i++;
        }

        int correcto = 1;   // 1 = sí, 0 = no

        if (i == cad.length()) {
            correcto = 0;   // no había '&'
        } else {
            i++;   // saltamos el '&'

            // 2. Cada carácter después del '&' debe ser igual al que sale de la pila
            while (i < cad.length() && correcto == 1) {
                if (pila.cantidad == 0) {
                    correcto = 0;   // Y es más larga que X
                } else if (pila.pop() != cad.charAt(i)) {
                    correcto = 0;   // no coinciden
                }
                i++;
            }

            // 3. Si sobraron letras en la pila, X es más larga que Y
            if (pila.cantidad > 0) {
                correcto = 0;
            }
        }

        if (correcto == 1) {
            System.out.println("SÍ es de la forma X&Y");
        } else {
            System.out.println("NO es de la forma X&Y");
        }
    }
}