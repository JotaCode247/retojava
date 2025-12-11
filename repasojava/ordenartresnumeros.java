import java.util.Scanner;

public class ordenartresnumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1, n2, n3;

        System.out.print("Ingrese el primer número : ");
        n1 = sc.nextInt();

        System.out.print("Ingrese el segundo número : ");
        n2 = sc.nextInt();

        System.out.print("Ingrese el tercer número : ");
        n3 = sc.nextInt();

        if (n1 == n2 && n2 == n3) {
            System.out.println("Los tres números son IGUALES: " + n1);

        } else if (n1 == n2 || n1 == n3 || n2 == n3) {
            System.out.println("Hay al menos dos números IGUALES.");

            if (n1 <= n2 && n1 <= n3) {
                if (n2 <= n3) {
                    System.out.println("Orden ascendente: " + n1 + ", " + n2 + ", " + n3);
                } else {
                    System.out.println("Orden ascendente: " + n1 + ", " + n3 + ", " + n2);
                }
            } else if (n2 <= n1 && n2 <= n3) {
                if (n1 <= n3) {
                    System.out.println("Orden ascendente: " + n2 + ", " + n1 + ", " + n3);
                } else {
                    System.out.println("Orden ascendente: " + n2 + ", " + n3 + ", " + n1);
                }
            } else {
                if (n1 <= n2) {
                    System.out.println("Orden ascendente: " + n3 + ", " + n1 + ", " + n2);
                } else {
                    System.out.println("Orden ascendente: " + n3 + ", " + n2 + ", " + n1);
                }
            }

        } else {
            System.out.println("Los tres números son DIFERENTES.");

            if (n1 < n2 && n1 < n3) {
                if (n2 < n3) {
                    System.out.println("Orden ascendente: " + n1 + ", " + n2 + ", " + n3);
                } else {
                    System.out.println("Orden ascendente: " + n1 + ", " + n3 + ", " + n2);
                }
            } else if (n2 < n1 && n2 < n3) {
                if (n1 < n3) {
                    System.out.println("Orden ascendente: " + n2 + ", " + n1 + ", " + n3);
                } else {
                    System.out.println("Orden ascendente: " + n2 + ", " + n3 + ", " + n1);
                }
            } else { // n3 es el más pequeño
                if (n1 < n2) {
                    System.out.println("Orden ascendente: " + n3 + ", " + n1 + ", " + n2);
                } else {
                    System.out.println("Orden ascendente: " + n3 + ", " + n2 + ", " + n1);
                }
            }
        }

    }
}
