import java.util.Scanner;

// 9.4: manejar 5 pilas con pares (i, j)
//   i > 0: insertar j en la pila Pi
//   i < 0: eliminar el elemento j de la pila P|i|
//   i = 0: fin
public class Problema94 {

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

        void mostrar() {
            for (int i = cantidad - 1; i >= 0; i--) {
                System.out.print(datos[i] + " ");
            }
            System.out.println();
        }
    }

    // Elimina el elemento j de una pila.
    // Se sacan elementos a una pila auxiliar hasta encontrar j,
    // y después se devuelven a la pila original.
    static void eliminar(Pila p, int j) {
        Pila aux = new Pila(100);
        int encontrado = 0;

        while (p.cantidad > 0 && encontrado == 0) {
            int x = p.pop();
            if (x == j) {
                encontrado = 1;   // lo sacamos y no lo guardamos
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

        // Crear las 5 pilas (P1 está en la posición 0 del arreglo)
        Pila[] pilas = new Pila[5];
        for (int k = 0; k < 5; k++) {
            pilas[k] = new Pila(100);
        }

        System.out.print("i (0 para terminar): ");
        int i = Integer.parseInt(sc.nextLine());

        while (i != 0) {
            if (i > 5 || i < -5) {
                System.out.println("i debe estar entre -5 y 5");
            } else {
                System.out.print("j: ");
                int j = Integer.parseInt(sc.nextLine());

                if (i > 0) {
                    pilas[i - 1].push(j);
                } else {
                    eliminar(pilas[-i - 1], j);
                }
            }
            System.out.print("i (0 para terminar): ");
            i = Integer.parseInt(sc.nextLine());
        }

        // Al terminar, escribir el contenido de las 5 pilas
        System.out.println("\nContenido de las pilas (arriba -> abajo):");
        for (int k = 0; k < 5; k++) {
            System.out.print("P" + (k + 1) + ": ");
            pilas[k].mostrar();
        }
    }
}