
import java.util.Scanner;

public class invertir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=0, d1=0,d2=0,d3=0,inv=0;
        System.out.println("ingrese un valor de 3 digitos");
        num=sc.nextInt();
        if (num>99 && num<1000){
            d1 = num/100;
            d2 = (num/10)%10;
            d3 = num%10;
            inv = (d3*100)+(d2*10)+d1;
            System.out.println("el numero invertido es: "+ inv);

        }else{
            System.out.println("EL VALOR INGRESADO NO ES DE 3 DIGITOS");
        }

    }

    
}
