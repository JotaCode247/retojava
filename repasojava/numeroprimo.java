import java.util.Scanner;

public class numeroprimo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=0, num2=0;
        System.out.println("Ingrese un numero de 3 digitos");
        num1 = sc.nextInt();
        if(num1>99 && num1<1000){
            num2 = num1%100;
            System.out.println("El numero de dos digitos obtenido es: "+num2);
        }else{
            System.out.println("El numero digitado no es de 3 digitos.");
        }
        
        if(num2<9){
            if(num2==2 || num2==3 || num2==5 || num2==7){
                System.out.println("El numero: "+num2+" es primo.");
            }else{
                System.out.println("El numero: "+num2+" es compuesto.");
            }
        }else{
            if(num2%2==0 || num2%3==0 || num2%5==0 || num2%7==0){
                System.out.println("El numero: "+num2+" es compuesto.");
            }else{
                System.out.println("El numero: "+num2+" es primo.");
            }
            
            if(num2==1 || num2==0 || num2==0){
                System.out.println("El numero: "+num2+" no es ni primo ni compuesto.");
            }
        }
    }}