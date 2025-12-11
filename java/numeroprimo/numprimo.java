
import java.util.Scanner;
5
public class numprimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num=0;
        System.out.println("ingrese un numero");
        num = sc.nextInt();
        if (num<9){
            if (num ==2 || num==3 || num==5 || num ==7){
            System.out.println("EL NUMERO: "+ num + " ES PRIMO");
            }else{
                System.out.println("EL NUMERO: "+ num + " NO ES PRIMO");

        }}else{
            if (num %2 == 0 || num%3 == 0 || num%5==0 || num%7==0 ){
            System.out.println("EL NUMERO: "+ num + " NO ES PRIMO");
    

        }else{
            System.out.println("EL NUMERO: "+ num + " ES PRIMO");
        }

        }



    
}}