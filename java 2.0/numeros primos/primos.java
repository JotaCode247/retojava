
import java.util.Scanner;

public class primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num=0, cont=0;
        System.out.println("ingrese un valor numerico: ");
        num=sc.nextInt();
        
        for (int i=1; i<=num;i++){
            if (num%i ==0){
                cont++;
            }
        }
        //despues del ciclo
        if(cont ==2){
            System.out.println("el numero: "+ num +" es primo");
        }else{
            System.out.println("el numero : "+ num + " no es primo");
        }
    }
}
