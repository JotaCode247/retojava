import java.util.Scanner;

public class cubo4potencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declarar variables
        double num, cubo, cuarp;
        // Titulo
        System.out.println("Calculardora de cubo y cuarta potencia");
        // Ciclo for
        for (int i = 1; i <= 10; i++) {
            // pedir las variables
            System.out.println("Ingrese el numero " + i + ":");
            num = sc.nextDouble();
            // sacar cubo
            cubo = Math.pow(num, 3);
            // Sacar cuarta potencia
            cuarp = Math.pow(num, 4);
            // Arrojar los resultados
            System.out.println("El cubo de: " + num + " es: " + cubo);
            System.out.println("La cuarta potencia de: " + num + " es: " + cuarp);
        }

    }
}