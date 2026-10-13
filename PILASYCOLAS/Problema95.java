import java.util.Scanner;

// 9.5: igual que 9.4 pero con triples (i, j, k)
//   k = -1: borrar todos los elementos de la pila P|i|
//   k =  0: hacer lo del 9.4 con i y j
//   i = 0: fin
public class Problema95 {

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

        void vaciar() {
            cantidad = 0;
        }

        void mostrar() {
            for (int i = cantidad - 1; i >= 0; i--) {
                System.out.print(datos[i] + " ");
            }
            System.out.println();
        }
    }

    // Elimina el elemento j de una pila usando una pila auxiliar
    static void eliminar(Pila p, int j) {
        Pila aux = new Pila(100);
        int encontrado = 0;

        while (p.cantidad > 0 && encontrado == 0) {
            int x = p.pop();
            if (x == j) {
                encontrado = 1;
            } else {
                aux.push(x);
            }
        }

        while (aux.cantidad > 0) {
            p.push(aux.pop());
        }

        if (encontrado == 0) {
            System.out.println("El elemento " + j + " no está en esa pila");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pila[] pilas = new Pila[5];
        for (int k = 0; k < 5; k++) {
            pilas[k] = new Pila(100);
        }

        System.out.print("i (0 para terminar): ");
        int i = Integer.parseInt(sc.nextLine());

        while (i != 0) {
            System.out.print("j: ");
            int j = Integer.parseInt(sc.nextLine());
            System.out.print("k (-1 o 0): ");
            int k = Integer.parseInt(sc.nextLine());

            if (i > 5 || i < -5) {
                System.out.println("i debe estar entre -5 y 5");
            } else if (k == -1) {
                // borrar todos los elementos de la pila |i|
                if (i > 0) {
                    pilas[i - 1].vaciar();
                } else {
                    pilas[-i - 1].vaciar();
                }
            } else if (k == 0) {
                // igual que el 9.4
                if (i > 0) {
                    pilas[i - 1].push(j);
                } else {
                    eliminar(pilas[-i - 1], j);
                }
            } else {
                System.out.println("k solo puede ser -1 o 0");
            }

            System.out.print("i (0 para terminar): ");
            i = Integer.parseInt(sc.nextLine());
        }

        System.out.println("\nContenido de las pilas (arriba -> abajo):");
        for (int p = 0; p < 5; p++) {
            System.out.print("P" + (p + 1) + ": ");
            pilas[p].mostrar();
        }
    }
}