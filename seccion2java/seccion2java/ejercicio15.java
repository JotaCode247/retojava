import java.util.Scanner;

public class ejercicio15 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int mayor = Integer.MIN_VALUE;   // el número más pequeño posible
        int menor = Integer.MAX_VALUE;   // el número más grande posible

        System.out.println("Ingrese números. El proceso termina con un número impar:");

        System.out.print("Ingrese un número: ");
        num = sc.nextInt();

        // ciclo mientras el número sea PAR
        while (num % 2 == 0) {

            // actualizar mayor
            if (num > mayor) {
                mayor = num;
            }

            // actualizar menor
            if (num < menor) {
                menor = num;
            }

            System.out.print("Ingrese otro número: ");
            num = sc.nextInt();
        }

        System.out.println("Se ingresó un número impar. Fin del proceso.");
        
        if (mayor == Integer.MIN_VALUE) {
            System.out.println("No se ingresaron números pares válidos.");
        } else {
            System.out.println("Mayor número par ingresado: " + mayor);
            System.out.println("Menor número par ingresado: " + menor);
        }
    }
}
