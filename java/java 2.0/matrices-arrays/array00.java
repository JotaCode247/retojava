public class array00{
    public static void main(String[] args) {
        int[] numeros= new int [5];
        System.out.println(numeros[0]);
        System.out.println(numeros[1]);
        System.out.println(numeros[2]);
        System.out.println(numeros[3]);
        System.out.println(numeros[4]);
        //almacenar valores especificos en ubicaciones especificas;

        numeros[4]=89;
        numeros[0]=-9;
        numeros[3]=7;
        numeros[2]=10;
        numeros[1]=56465465;

        System.out.println(numeros[0]+","+ numeros[1]+","+ numeros[2]+","+ numeros[3]+","+ numeros[4]);
        System.out.println(numeros[2]+","+ numeros[1]+","+ numeros[4]+","+ numeros[0]+","+ numeros[3]);


    }
}