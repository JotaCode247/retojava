import java.util.Scanner;

public class numeromedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = 0, n2 = 0, n3 = 0, medio = 0;

        System.out.println("ingresar el numero 1 : ");
        n1 = sc.nextInt();
        System.out.println("ingresar el numero 2 : ");
        n2 = sc.nextInt();
        System.out.println("ingresar el numero 3 : ");
        n3 = sc.nextInt();

        System.out.println("Los números son: " + n1 + ", " + n2 + ", " + n3);

        if ((n1 > n2 && n1 < n3) || (n1 < n2 && n1 > n3)) {
            medio = n1;
            System.out.println("El valor medio es: " + medio);
        } else {
            if ((n2 > n1 && n2 < n3) || (n2 < n1 && n2 > n3)) {
                medio = n2;
                System.out.println("El valor medio es: " + medio);

            } else {
                medio = n3;
                System.out.println("El valor medio es: " + medio);

            }

        }

    }
}
