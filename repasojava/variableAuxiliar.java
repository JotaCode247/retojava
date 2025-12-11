import java.util.Scanner;

//Obtener el valor de dos números e invertir su valor  A=B y B=A con una variable auxiliar
public class variableAuxiliar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;
        System.out.println("ingrese el valor de a:");
        a = sc.nextInt();
        System.out.println("ingrese el valor de b: ");
        b = sc.nextInt();

        c = a;
        a = a + b - c;
        b = a + c - b;
        System.out.println("Valores iniciales: A= " + a + ", B= " + b);

        System.out.println("luego del intercambio el valor de  a: " + a + " y el de b es: " + b);
    }
}
