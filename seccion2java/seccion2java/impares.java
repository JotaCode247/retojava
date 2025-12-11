import java.util.Scanner;

public class impares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, suma = 0;

        System.out.print("\nIngrese un número N: ");
        N = sc.nextInt();

        System.out.println("Números impares entre 1 y " + N + ":");

        for(int i = 1; i <= N; i++){
            if(i % 2 != 0){   // si es impar
                System.out.print(i + " ");
                suma += i;   // acumular la suma
            }
        }

        System.out.println("\nLa suma de los números impares es: " + suma);
    }
}

