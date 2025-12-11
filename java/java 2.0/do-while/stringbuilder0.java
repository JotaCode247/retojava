import java.util.Scanner;

public class stringbuilder0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=0;
        String nuevo="", num1="";

        System.out.println("ingrese un numero de 3 cifras : ");
        num= sc.nextInt();
        num1= String.valueOf(num);
        nuevo= new StringBuilder(num1).reverse().toString();

    if (nuevo.equals(num1)){
            System.out.println("el numero " + num1 + " es palindromo");
    }else{
        System.out.println("el numero : " + num1 + " no es palindromo");
    }

    }
}
