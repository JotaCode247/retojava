import java.util.Scanner;
public class ejerciciociclos10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Declarar variables
        int num1 = 0, num2 = 0, prod=0;
        //Pedir las variables
        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2 = sc.nextInt();
        //Ciclo for
        for(int i=0; i<num2; i++){
            //Iniciar operacion
            prod = prod + num1;
        }
        System.out.println("El producto de la multiplicación de: "+num1+" y "+num2+" es:"+prod);
    }
}