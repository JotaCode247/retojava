//Contador de vocales: Crea una función que cuente las vocales de una palabra. Este
//reto refuerza tu dominio de la lógica de bucles y las estructuras condicionales.
import java.util.Scanner;
public class ejercicio_1 {


    
    public static void main(String[] args) {
        //List<String> lista = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        System.out.println("ingresa la palabra: ");
        String word= sc.nextLine();
        int number=0;
        number= contar(word);
        System.out.println("la cantidad de vocales es: "+ number);
             
}

    public static int contar(String word){
        int contador=0;

        for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        c = Character.toLowerCase(c);// para que java reconosca todas las letras en minuscula
        if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
            contador+=1;
        }
            
        }
        return contador;
     }

    
     
}