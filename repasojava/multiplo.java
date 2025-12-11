import java.util.Scanner;

public class multiplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = 0, num2 = 0;

        System.out.println("ingrese el valor de numero 1");
        num1 = sc.nextInt();
        System.out.println("ingrese el valor de numro 2");
        num2 = sc.nextInt();

        if (num2 == 0) {
            System.out.println("No se puede determinar la multiplicidad, el segundo número es cero.");

        } else {
            if (num1 % num2 == 0) {
                System.out.println(num1 + " es MÚLTIPLO de " + num2);

            } else {
                System.out.println(num1 + " NO es múltiplo de " + num2);
            }

        }

    }
}
