import java.util.Scanner;

public class contadores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        int menores15 = 0;
        int mayores50 = 0;
        int entre25y45 = 0;
        int mayoresCero = 0;

        int sumaPositivos = 0;
        int cantidadPositivos = 0;

        // Leer 20 números
        for (int i = 1; i <= 20; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            num = sc.nextInt();

            // a) menores de 15
            if (num < 15) {
                menores15++;
            }

            // b) mayores de 50
            if (num > 50) {
                mayores50++;
            }

            // c) entre 25 y 45 (incluye 25 y 45)
            if (num >= 25 && num <= 45) {
                entre25y45++;
            }

            // d) mayores que cero
            if (num > 0) {
                mayoresCero++;

                // e) acumular los positivos para el promedio
                sumaPositivos += num;
                cantidadPositivos++;
            }
        }

        // Calcular promedio (solo si hubo positivos)
        double promedio = 0;
        if (cantidadPositivos > 0) {
            promedio = (double) sumaPositivos / cantidadPositivos;
        }

        System.out.println("\nRESULTADOS:");
        System.out.println("a) Menores de 15: " + menores15);
        System.out.println("b) Mayores de 50: " + mayores50);
        System.out.println("c) Entre 25 y 45: " + entre25y45);
        System.out.println("d) Mayores que cero: " + mayoresCero);
        System.out.println("e) Promedio de positivos: " + promedio);
    }
}
