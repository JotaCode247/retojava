
import java.text.DecimalFormat;
import java.util.Scanner;

public class nota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1=0,nota2=0,nota3=0, promedio=0;
        DecimalFormat df= new DecimalFormat ("#.00");
        System.out.println("ingrese las 3 notas: ");
        nota1 =sc.nextDouble();
        nota2 =sc.nextDouble();
        nota3 =sc.nextDouble();
        promedio = (nota1+nota2+nota3)/3;
        String promedio1=df.format(promedio);
        System.out.println("su nota definitiva es igual a: "+ promedio1);


     

        
    }
}
    
