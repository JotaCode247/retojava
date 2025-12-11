import java.util.Scanner;
public class ejerciciociclos8 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //Declarar variables
        int num=0, sum=0, prod=1;
        //Ciclo for
        for( int i=1; i<=30; i++){
            //Pedir variables.
            System.out.println("Ingrese el numero "+i+" :");
            num = sc.nextInt();
            //Acumulacion de la suma
            sum = sum +num;
            //Acumulacion de producto
            prod = prod * num;
        }
        //Presentar resultados
        System.out.print("El resultado de la suma de los 30 numeros es: "+sum);
        System.out.println("\n El producto de la multiplicacion de los 30 numeros es:"+prod);
    }
}
