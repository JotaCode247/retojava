
import java.util.Scanner;


public class notas {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double nota=0, promedio=0, notabaja=0;
        for (int i=1; i<11; i++){
            System.out.println("ingrese su nota: "+ i);
            nota=sc.nextDouble();
            promedio+=nota;
            if (i==0){
                notabaja=nota;
            }else{
                if (nota<notabaja) {
                    notabaja=nota;
                    
                }
            }
        }
        promedio=promedio/10;
        System.out.println("la nota promedio es: " + promedio);
        System.out.println("la nota mas baja es: "+ notabaja);
    }
}