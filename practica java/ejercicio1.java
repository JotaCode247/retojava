//Hacer un programa que calcule e imprima la suma de tres calificaciones.

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1=0 , nota2=0 , nota3=0;

        System.out.println("\ningrese 3 calificaciones: ");
        nota1=sc.nextDouble();
        nota2 = sc.nextDouble();
        nota3 =sc.nextDouble();

        double suma = nota1+nota2+nota3;

        System.out.println("la suma de las 3 calificaciones es "+suma);
        
    }
}