
import java.util.Scanner;

public class resta{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num1=0, num2=0, cont=0;
        System.out.println("ingrese el dividendo");
        num1=sc.nextInt();
        System.out.println("ingrese el divisor ");
        num2=sc.nextInt();

        while (num1>=num2) {
            num1-=num2; //num1=num1 - num2
            cont++;
            
        }
        System.out.println("el cociente es: "+ cont);
        System.out.println("el residuo es:" +num1);
    }
    }
