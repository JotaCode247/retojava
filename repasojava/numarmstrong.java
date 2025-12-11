import java.util.Scanner;

public class numarmstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0, d1 = 0, d2 = 0, d3 = 0;
        int suma_potencias = 0;

        System.out.println("ingrese un numero de 3 digitos: ");
        num = sc.nextInt();

        if (num >= 100 && num <= 999) {

            d1 = num % 10;
            d2 = (num / 10) % 10;
            d3 = (num / 100);
            suma_potencias = (int) (Math.pow(d1, 3) + Math.pow(d2, 3) + Math.pow(d3, 3));
            if (suma_potencias == num) {
                System.out.println(num + " es un número de Armstrong (" + d1 + "^3 + " + d2 + "^3 + " + d3 + "^3 = "
                        + suma_potencias + ").");

            } else {
                System.out.println(num + " NO es un número de Armstrong (Suma = " + suma_potencias + ").");
            }

        } else {
            System.out.println("El numero ingresado no es un numero de 3 digitos");
        }

    }
}
