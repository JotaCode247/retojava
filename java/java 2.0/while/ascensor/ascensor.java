
import java.util.Scanner;

public class ascensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int limite=0, carga=0, peso=0;
        System.out.println("ingrese el peso limite: ");
        limite=sc.nextInt();

        while (carga<=limite) {
            System.out.println("ingrese el peso a cargar :");
            peso=sc.nextInt();
            carga+=peso;

            
        }
        if (carga >= limite){
            carga-=peso;
            System.out.println("el ascensor salio con: "+ carga+ "kilos");

        }
}
}

