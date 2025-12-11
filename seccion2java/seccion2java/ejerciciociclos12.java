import java.util.Scanner;
public class ejerciciociclos12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Declarar variables
        int numactual=0, nummayor=0;
        //Pedir la primera variable
        System.out.println("Ingrese un número menos a 1: ");
        numactual = sc.nextInt();
        //Igualar nummayor a numactual
        nummayor=numactual;
        //ciclo while
        while(numactual != 1){
            
            if(numactual>nummayor){
                nummayor=numactual;
            }
            System.out.println("Ingrese el siguiente numero menor a 1: ");
            numactual = sc.nextInt();
        }
        System.out.println("El numero mayor detectado es:"+nummayor);
    }
}