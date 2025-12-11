import java.util.Scanner;
public class ejerciciociclos11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Declarar variables
        int divisor=0, dividendo=0, cociente=0;
        //Pedir variables
        System.out.println("Ingrese el divisor: ");
        divisor = sc.nextInt();
        System.out.println("Ingrese el dividento");
        dividendo = sc.nextInt();
        //Ciclo while
        while(dividendo >= divisor){
            cociente = cociente +1;
            dividendo = dividendo-divisor;
            
        }
        //Mostrar el resultado
        System.out.println("El resultado, de la division por resta es: "+cociente);
        System.out.println("El resto de la divicion por resta es: "+dividendo);
    }
}