import java.util.Scanner;

public class imprimirpositivos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] positivos = new int[10]; // guardará solo los números positivos
        int cont = 0; // cuántos positivos se encontraron

        System.out.println("********* Ingresar 10 números *********");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = sc.nextInt();

            if (num > 0) {
                positivos[cont] = num; // guardar el número positivo
                cont++; // aumentar el contador
            }
        }

        System.out.println("\nNúmeros positivos ingresados:");
        for (int i = 0; i < cont; i++) {
            System.out.println(positivos[i]);
        }
    }
}
