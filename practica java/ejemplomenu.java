import java.util.Scanner;

public class ejemplomenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    saludar();
                    break;
                case 2:
                    sumar(sc);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

            System.out.println(); // salto de línea
        } while (opcion != 3);

        sc.close();
    }

    // ===== FUNCIONES =====

    static void mostrarMenu() {
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("1. Saludar");
        System.out.println("2. Sumar dos números");
        System.out.println("3. Salir");
    }

    static void saludar() {
        System.out.println("¡Hola! Este es un mensaje desde una función.");
    }

    static void sumar(Scanner sc) {
        System.out.print("Ingresa el primer número: ");
        int a = sc.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = sc.nextInt();

        System.out.println("La suma es: " + (a + b));
    }
}

