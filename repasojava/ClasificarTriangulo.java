import java.util.Scanner;

public class ClasificarTriangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double l1, l2, l3;

        System.out.print("Ingrese la longitud del lado 1: ");
        l1 = sc.nextDouble();

        System.out.print("Ingrese la longitud del lado 2: ");
        l2 = sc.nextDouble();

        System.out.print("Ingrese la longitud del lado 3: ");
        l3 = sc.nextDouble();

        if ((l1 + l2 > l3) && (l1 + l3 > l2) && (l2 + l3 > l1)) {
            System.out.println("Los lados forman un triángulo.");

            if (l1 == l2 && l2 == l3) {
                System.out.println("El triángulo es EQUILÁTERO (todos los lados iguales).");
            } else if (l1 == l2 || l1 == l3 || l2 == l3) {
                System.out.println("El triángulo es ISÓSCELES (dos lados iguales).");
            } else {
                System.out.println("El triángulo es ESCALENO (todos los lados diferentes).");
            }

        } else {
            System.out.println("ERROR: Los valores ingresados no forman un triángulo (Desigualdad Triangular).");
        }

    }
}
