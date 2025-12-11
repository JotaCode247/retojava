import java.util.Scanner;
public class ejerciciociclos9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Declarar las varialbles
        int num=1, sum=0;
        //Ciclo while
        while(num>0){
            System.out.println("Ingrese un numero: ");
            num = sc.nextInt();
            sum = sum+num;
        }
        System.out.println("Se a detectado un numero negativo, la suma de los numeros es: "+sum);
    }
}