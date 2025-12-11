
import java.util.Scanner;

public class dowhile1{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int a =10;
        /*while (a<10) {
            System.out.println("ingrese el valor de a: ");
            a = sc.nextInt(); 
            
        }*/
    do {
        System.out.println("ingrese el valor de a: ");
        a=sc.nextInt();
    }while (a<10);


    }
} 