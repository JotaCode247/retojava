
import java.util.Scanner;

public class foreach00 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String [] nombres = new String [3];
        nombres[0]="juana";
        nombres[1]="leonora";
        nombres[2]="pepe";

    for (String n : nombres ) {
        n+="------";
        System.out.println(n);
        
    }
    }
    }
    
