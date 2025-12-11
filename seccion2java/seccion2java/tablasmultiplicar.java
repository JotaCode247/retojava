import java.util.Scanner;

public class tablasmultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        System.out.println("******* TABLAS DE MULTIPLICAR *********");
        System.out.print("Ingrese un número para mostrar su tabla de multiplicar: ");
        numero = sc.nextInt();

        System.out.println("\nTABLA DE MULTIPLICAR DEL " + numero);

        for (int i = 1; i <= 10; i++) {
            int producto = numero * i;
            System.out.println("Numero: " + numero + " X: " + i + " Producto: " + producto);
        }
    }
}
