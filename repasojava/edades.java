/*  Solicita la edad de una persona y muestra un mensaje indicando si es: 
Niño (0-12) 
Adolescente (13-17) 
Adulto (18-59) 
Adulto mayor (60 o más). */

import java.util.Scanner;

public class edades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad = 0;
        System.out.println("ingrese su edad: ");
        edad = sc.nextInt();

        if (edad >= 0 && edad <= 12) {
            System.out.println("ES UN NIÑO");

        } else {
            if (edad >= 13 && edad <= 17) {
                System.out.println("ES UN ADOLECENTE ");

            } else {
                if (edad >= 18 && edad <= 59) {
                    System.out.println("ES ADULTO ");

                } else {
                    if (edad >= 60) {
                        System.out.println("ES UN ADULTO MAYOR");

                    }

                }

            }

        }

    }

}
