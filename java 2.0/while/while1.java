
import java.util.Scanner;

public class while1{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int a=1, b=0;
        while (a>b){
            System.out.println("ingrese un valor ");
            a=sc.nextInt();

        }
        System.out.println("valor final de a " + a);
    }
}
