import java.util.Scanner;

// 10.3: Supermercado con 25 carritos y 3 cajas, todo representado con colas.
//  - Si al llegar no hay carrito, el cliente espera (cola de espera).
//  - Nadie se va sin pagar.
//  - Al terminar de comprar, el cliente se forma en la caja con MENOS gente y no se cambia.
//  - Al pagar, su carrito queda disponible otra vez.
public class Problema103 {

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

        void mostrar() {
            for (int i = 0; i < cantidad; i++) {
                System.out.print(datos[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Cola con los carritos disponibles (números del 1 al 25)
        Cola carritos = new Cola(25);
        for (int i = 1; i <= 25; i++) {
            carritos.encolar(i);
        }

        Cola espera = new Cola(1000);   // clientes esperando un carrito

        // Las 3 cajas (cada una es una cola de clientes)
        Cola[] cajas = new Cola[3];
        for (int k = 0; k < 3; k++) {
            cajas[k] = new Cola(1000);
        }

        // estado de cada cliente: 1 = esperando carrito, 2 = comprando,
        //                         3 = en una caja, 4 = ya pagó
        int[] estado = new int[1000];
        int[] carritoDe = new int[1000];   // qué carrito tiene cada cliente
        int numCliente = 0;                // cuántos clientes han llegado

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== SUPERMERCADO =====");
            System.out.println("1. Llega un cliente");
            System.out.println("2. Un cliente termina de comprar (pasa a caja)");
            System.out.println("3. Una caja atiende a su primer cliente (paga)");
            System.out.println("4. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Elige: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                numCliente++;
                if (carritos.cantidad > 0) {
                    carritoDe[numCliente] = carritos.desencolar();
                    estado[numCliente] = 2;
                    System.out.println("Cliente " + numCliente + " toma el carrito "
                            + carritoDe[numCliente] + " y empieza a comprar");
                } else {
                    espera.encolar(numCliente);
                    estado[numCliente] = 1;
                    System.out.println("No hay carritos. El cliente " + numCliente + " espera");
                }
            }

            if (opcion == 2) {
                System.out.print("Número del cliente que termina de comprar: ");
                int n = Integer.parseInt(sc.nextLine());

                if (n >= 1 && n <= numCliente && estado[n] == 2) {
                    // Buscar la caja con menos gente
                    int mejor = 0;
                    for (int k = 1; k < 3; k++) {
                        if (cajas[k].cantidad < cajas[mejor].cantidad) {
                            mejor = k;
                        }
                    }
                    cajas[mejor].encolar(n);
                    estado[n] = 3;
                    System.out.println("Cliente " + n + " se forma en la caja " + (mejor + 1));
                } else {
                    System.out.println("Ese cliente no está comprando");
                }
            }

            if (opcion == 3) {
                System.out.print("¿Qué caja atiende (1 a 3)? ");
                int c = Integer.parseInt(sc.nextLine());

                if (c < 1 || c > 3) {
                    System.out.println("Esa caja no existe");
                } else if (cajas[c - 1].cantidad == 0) {
                    System.out.println("La caja " + c + " no tiene clientes");
                } else {
                    int n = cajas[c - 1].desencolar();
                    estado[n] = 4;
                    carritos.encolar(carritoDe[n]);   // el carrito queda disponible
                    System.out.println("Cliente " + n + " paga en la caja " + c
                            + ". El carrito " + carritoDe[n] + " queda disponible");

                    // Si alguien esperaba carrito, se le da este
                    if (espera.cantidad > 0) {
                        int m = espera.desencolar();
                        carritoDe[m] = carritos.desencolar();
                        estado[m] = 2;
                        System.out.println("Cliente " + m + " (que esperaba) toma el carrito "
                                + carritoDe[m] + " y empieza a comprar");
                    }
                }
            }

            if (opcion == 4) {
                System.out.println("\nCarritos disponibles (" + carritos.cantidad + "): ");
                carritos.mostrar();

                System.out.print("Clientes esperando carrito: ");
                espera.mostrar();

                System.out.print("Clientes comprando: ");
                for (int n = 1; n <= numCliente; n++) {
                    if (estado[n] == 2) {
                        System.out.print(n + " ");
                    }
                }
                System.out.println();

                for (int k = 0; k < 3; k++) {
                    System.out.print("Caja " + (k + 1) + " (frente -> final): ");
                    cajas[k].mostrar();
                }
            }
        }
    }
}