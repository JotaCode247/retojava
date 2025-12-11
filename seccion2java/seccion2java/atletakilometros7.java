import java.util.Scanner;

public class atletakilometros7 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double tiempo;
        int contadorFallos = 0;  // Cuenta los días con tiempo mayor a 16

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el tiempo del día " + i + " (en minutos): ");
            tiempo = sc.nextDouble();

            if (tiempo > 16) {
                contadorFallos = contadorFallos + 1;  // Aumenta si falló ese día
            }
        }

        System.out.println("\n===== RESULTADO =====");
        if (contadorFallos == 0) {
            System.out.println("El atleta ES APTO para la prueba de 5 kilómetros.");
        } else {
            System.out.println("El atleta NO es apto para la prueba de 5 kilómetros.");
        }
    }
}

