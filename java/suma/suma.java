import java.util.Scanner;

public class suma {
    public static void main (String[] args){
        //declarar las varibles
        int n1=0;
        int n2=0;
        int res=0;
        Scanner sc=new Scanner (System.in);
        System.out.println("INGRESE EL PRIMERO NUMERO");
        n1=sc.nextInt();
        System.out.println("INGRESE EL SEGUNDO NUMERO");
        n2=sc.nextInt();
        res=n1+n2;
        System.out.println(res);
    }
}