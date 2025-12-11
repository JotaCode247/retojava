import java.util.Scanner;

public class segundosHoras {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, horas, minutos, segundos, resto;

        System.out.print("Ingrese un número entero de segundos (debe ser mayor a 4251): ");
        n = sc.nextInt();

        if (n <= 4251) {
            System.out.println("Error: el valor debe ser mayor a 4251.");
        } else {
            horas = n / 3600;

            resto = n % 3600;

            minutos = resto / 60;

            segundos = resto % 60;

            System.out.println("En " + n + " segundos hay:");
            System.out.println(horas + " hors, " + minutos + " minutos y " + segundos + " segundos");
        }

    }
}
