import java.util.Scanner;

//segmentar un numero de 4 digitos con sus unidades,decenas, centenas, millares

public class segdigitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0, unidad = 0, decenas = 0, centena = 0, millar = 0;
        System.out.println("ingrese un numero de 4 digitos: ");
        num = sc.nextInt();

        if (num >= 1000 && num <= 9999) {
            unidad = num % 10;
            decenas = (num / 10) % 10;
            centena = (num / 100) % 10;
            millar = (num / 1000);
            System.out.println("El dígito de los millares es: " + millar);
            System.out.println("El dígito de las centenas es: " + centena);
            System.out.println("El dígito de las decenas es: " + decenas);
            System.out.println("El dígito de las uniades es: " + unidad);

        }

    }

}