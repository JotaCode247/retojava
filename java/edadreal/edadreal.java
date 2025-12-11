
import java.time.LocalDate;
import java.util.Scanner;


public class edadreal{
    public static void main(String[] args) {
        LocalDate hoy=LocalDate.now();
        int aA=hoy.getYear();
        int mA=hoy.getMonthValue();
        int dA=hoy.getDayOfMonth();
        int añon=0; int mesn=0; int dian=0;
        int años=0, meses=0, dias=0;
        Scanner sc = new Scanner (System.in);
        System.out.println("ingrese su fecha de nacimiento: formato(AA/MM/DD)");
        añon = sc.nextInt(); mesn = sc.nextInt(); dian = sc.nextInt();

        if (dA>=dian){
            dias=dA-dian;
        }else{
            dias=dA+30;
            mA=mA-1;
            dias=dA-dian;
        }
        if (mA>=mesn){
            meses=mA-mesn;
        }else{
            mA=mA+12;
            aA=aA-1;
            meses=mA-mesn;
        }
        años=aA-mesn;

        System.out.println("su edad real es "+años+ " años" +meses+ " meses y"+dias+ " dias ");







    }
}