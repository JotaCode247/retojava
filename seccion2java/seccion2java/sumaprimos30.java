import java.util.Scanner;

public class sumaprimos30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int sumaPrimos = 0;
        int divisores;
        String listaPrimos = "";   // aquí se guardarán los números primos

        for (int i = 1; i <= 30; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            num = sc.nextInt();

            // Contar divisores
            divisores = 0;
            for (int d = 1; d <= num; d++) {
                if (num % d == 0) {
                    divisores++;
                }
            }

            // Si el número es primo, se agrega a la lista y a la suma
            if (divisores == 2) {
                listaPrimos = listaPrimos + num + " ";
                sumaPrimos += num;
            }
        }

        System.out.println("\nLos números primos ingresados son: " + listaPrimos);
        System.out.println("La suma de los números primos es: " + sumaPrimos);
    }
}
