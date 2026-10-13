import java.util.Scanner;

// 9.6: frases palíndromas con una pila y una cola
// Cada letra se mete en la pila y en la cola.
// La pila entrega la última letra y la cola la primera.
// Si todas coinciden, es palíndromo.
// (La cola hace el papel de la "lista circular" del enunciado.)
public class Problema96 {

    // Pila simple de enteros
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

    // Cola simple de enteros
    static class Cola {
        int[] datos;
        int cantidad = 0;

        Cola(int capacidad) {
            datos = new int[capacidad];
        }

        void encolar(int x) {
            if (cantidad == datos.length) {
                System.out.println("Cola llena, no se puede agregar " + x);
            } else {
                datos[cantidad] = x;
                cantidad++;
            }
        }

        int desencolar() {
            if (cantidad == 0) {
                System.out.println("Cola vacía");
                return -1;
            }
            int primero = datos[0];
            for (int i = 0; i < cantidad - 1; i++) {
                datos[i] = datos[i + 1];
            }
            cantidad--;
            return primero;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe una frase (línea vacía para terminar): ");
        String frase = sc.nextLine();

        while (frase.length() > 0) {
            Pila pila = new Pila(frase.length());
            Cola cola = new Cola(frase.length());

            // Se ignoran espacios, signos y mayúsculas
            for (int i = 0; i < frase.length(); i++) {
                char c = Character.toLowerCase(frase.charAt(i));
                if (Character.isLetterOrDigit(c)) {
                    pila.push(c);
                    cola.encolar(c);
                }
            }

            // Comparar lo que sale de la pila con lo que sale de la cola
            int esPalindromo = 1;
            while (pila.cantidad > 0) {
                int dePila = pila.pop();
                int deCola = cola.desencolar();
                if (dePila != deCola) {
                    esPalindromo = 0;
                }
            }

            if (esPalindromo == 1) {
                System.out.println("  -> SÍ es palíndromo");
            } else {
                System.out.println("  -> NO es palíndromo");
            }

            System.out.print("Escribe una frase (línea vacía para terminar): ");
            frase = sc.nextLine();
        }
    }
}