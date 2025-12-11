

import java.util.Random;
import java.util.Scanner;

public class arregloejemplo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] sueldos= new int[100];
        Random rd = new Random(); //Funcion que nos ayuda a generar numeros aleatorios.
        int valor=0;

        /*Llenar un valor
        for (int i=0; i< sueldos.length; i++){
            System.out.println("Ingrese el valor de la posición 0: ");
            sueldos[i]= sc.nextInt(); //continua con la siguiente posición hasta que las llene todas.
        }
        */
        for(int i=0; i<sueldos.length; i++){
            valor= rd.nextInt(500);
            sueldos[i]=valor; //se necesita enviar el valor al vector para que no se generen valores vacios.
        }
        // Consultar los valores almacenados en el vector
        for(int i=0; i<sueldos.length; i++){
            System.out.println(sueldos[i]);
        }
    }
}
