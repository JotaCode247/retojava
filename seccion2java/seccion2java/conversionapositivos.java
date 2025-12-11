import java.util.Scanner;
import java.util.ArrayList; // libreria para almacenar sin tener que definir el valor del vector
public class conversionapositivos {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num=0;
    ArrayList<Integer> conversion= new ArrayList<>();
    int pos =0;

// for recorre y pide los numeros al usuario- 15 numeros

    for (int i = 0; i < 15; i++) {
            System.out.print("Ingrese el número " + (i+1) + ": ");
            num = sc.nextInt();
    // solo si es negativo ejecuta la operacion de conversion a positivo
        if (num<0) {  
            pos= num*-1;
            conversion.add(pos);
        }else{  // si no es positivo anuncia al usuario sin interrumpir el for
            System.out.println("el numero no es negativo");
        }
    } 
    // for each variable rer para recorrer y guardar en la arraylist de conversion
    //ymostar 
    for(int rer : conversion){
        System.out.println("los numeros convertidos a positivos quedan: "+rer);
    }
}}
