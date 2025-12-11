import java.text.DecimalFormat;
import java.util.Scanner;

public class aprobarcurso2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        double[] notas = new double[3];
        double promedio, porc_promedio;
        int totalclases, inasistencias, porc_inasistencia;

        // Ciclo para ingresar notas válidas de 1 a 5
        for (int i = 0; i < 3; i++) {
            do {
                System.out.print("Ingrese la nota " + (i + 1) + " (1 a 5): ");
                notas[i] = sc.nextDouble();

                if (notas[i] < 1 || notas[i] > 5) {
                    System.out.println("Nota inválida. Debe estar entre 1 y 5.");
                }

            } while (notas[i] < 1 || notas[i] > 5);
        }

        // Leer datos de asistencia
        System.out.print("Ingrese el total de clases: ");
        totalclases = sc.nextInt();

        System.out.print("Ingrese el número de inasistencias: ");
        inasistencias = sc.nextInt();

        // Cálculos
        promedio = (notas[0] + notas[1] + notas[2]) / 3;
        porc_promedio = (promedio / 5) * 100;
        porc_inasistencia = (inasistencias * 100) / totalclases;

        // Resultados
        System.out.println("Promedio: " + df.format(promedio));
        System.out.println("Porcentaje promedio: " + df.format(porc_promedio) + "%");
        System.out.println("Porcentaje de inasistencias: " + df.format(porc_inasistencia) + "%");

        // Condición final de aprobación
        if (porc_promedio >= 70 && porc_inasistencia <= 15) {
            System.out.println("¡Usted aprobó el curso! ¡Felicidades!");
        } else {
            System.out.println(" Usted ha reprobado el curso.");
        }
    }
}

