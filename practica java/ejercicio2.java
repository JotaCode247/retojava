import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int salarioH = 0, horasS = 0, total = 0;

        System.err.println("\ningrese su salario por hora : ");
        salarioH = sc.nextInt();
        System.out.println(" ingrese el total de horas trabajadas esta semana: ");
        horasS = sc.nextInt();

        total = horasS * salarioH;

        System.out.println("su salario semanal es: " + total);

    }
}
