
import java.util.Scanner;

public class positivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=0;
        for (int i=0; i<10;i++){
        System.out.println("ingresa un valor: ");
        num=sc.nextInt();
        if (num>0){
        System.out.println("este numero es positivo ");
        }else if (num<0){
        System.out.println("este numero es negativo ");
        }else {
            System.out.println("el numero es neutro");
        }

        }

    }
}
