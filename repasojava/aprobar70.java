import java.text.DecimalFormat;
import java.util.Scanner;

public class aprobar70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = 0, n2 = 0, n3 = 0, promedio = 0, porc_promedio = 0;
        int porc_inasistencia = 0, totalclases = 0, inasistencias = 0;

        System.out.println("ingrese su primer nota: ");
        n1 = sc.nextDouble();
        System.out.println("ingrese su segunda nota: ");
        n2 = sc.nextDouble();
        System.out.println("ingrese su tercera nota: ");
        n3 = sc.nextDouble();

        System.out.println("ingrese el total de clases: ");
        totalclases = sc.nextInt();
        System.out.println("ingrese el numero de inasistencias : ");
        inasistencias = sc.nextInt();

    

        DecimalFormat df = new DecimalFormat("0.00");
        promedio = (n1 + n2 + n3) / 3;
        porc_promedio = (promedio / 5) * 100;
        porc_inasistencia = (inasistencias/totalclases ) * 100;

        System.out.println("Porcentaje promedio: " + df.format(promedio)  );
        System.out.println("Porcentaje promedio: " + df.format(porc_promedio) + "%");
        System.out.println("Porcentaje inasistencia: " + df.format(porc_inasistencia) + "%");

                if (porc_promedio >= 70 && porc_inasistencia <= 15) {
                    System.out.println("usted aprobo el curso ¡ felicidades !");

                } else {
                    System.out.println("Usted ha reprobado el curso : ");

                }

            }

        }
