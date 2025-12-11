
import java.util.Scanner;

public class cubopotencia{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double num=0, cubo=0, cuartaP=0;
        for (int i = 0; i < 10; i++) {
            System.out.println("ingrese una base: ");
            num=sc.nextDouble();
            cubo=Math.pow(num, 3);
            cuartaP=Math.pow(num, 4);
            System.out.println("el cubo de : "+num+ "es: "+ cubo + " y la cuarta potencia de "+ num + " es: "+ cuartaP);
            System.out.println("===============================================");
        }
    }
}
