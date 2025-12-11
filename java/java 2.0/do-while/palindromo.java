
import java.util.Scanner;

public class palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=0;
        String nuevo="", num1="";

        System.out.println("ingrese un numero de 3 cifras : ");
        num= sc.nextInt();
        num1= String.valueOf(num);

        for (int i = num1.length()-1;  i>=0; i--) {
            nuevo+= num1.charAt(i);
        }

    if (nuevo.equals(num1)){
            System.out.println("el numero " + num1 + " es palindromo");
    }else{
        System.out.println("el numero : " + num1 + " no es palindromo");
    }

    }
}
