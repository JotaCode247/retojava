import java.util.Scanner;

public class Multiplo5y3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int mayor5 = Integer.MIN_VALUE;  // para el mayor múltiplo de 5
        int menor3 = Integer.MAX_VALUE;  // para el menor múltiplo de 3

        System.out.println("Ingrese números (ingrese un número negativo para terminar):");

        System.out.print("Número: ");
        num = sc.nextInt();

        while (num >= 0) {   // termina cuando se ingresa negativo

            // Si es múltiplo de 5 y mayor
            if (num % 5 == 0 && num > mayor5) {
                mayor5 = num;
            }

            // Si es múltiplo de 3 y menor
            if (num % 3 == 0 && num < menor3) {
                menor3 = num;
            }

            System.out.print("Número: ");
            num = sc.nextInt();
        }

        // Mostrar resultados finales
        if (mayor5 == Integer.MIN_VALUE) {
            System.out.println("No se ingresaron múltiplos de 5.");
        } else {
            System.out.println("El mayor múltiplo de 5 es: " + mayor5);
        }

        if (menor3 == Integer.MAX_VALUE) {
            System.out.println("No se ingresaron múltiplos de 3.");
        } else {
            System.out.println("El menor múltiplo de 3 es: " + menor3);
        }
    }
}
