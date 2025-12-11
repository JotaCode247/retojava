import java.util.Scanner;

public class numerosposinega {
    public static void main(String[] args){
    Scanner sc = new Scanner (System.in);
    //variabkes de vectores para almacenar
    int[] positivos = new int[20];
    int [] negativos = new int [20];
    int [] neutros = new int [20];
    //se inicializa un contador para cada vector y asi podr almacenar
    int contpos= 0;
    int contneg=0;
    int contneu=0;

    System.out.println("********** NUMEROS  POSITIVOS, NEGATIVOS, Y NEUTROS **************");


//el recorrido con el for para pedir los nmeros

for (int i = 1; i <= 20; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = sc.nextInt();

// se condiciona para separar y almacenar

            if (num > 0) {
                positivos[contpos] = num; //cada numero se almacena en su vector depenndiendo la condicon
                contpos++; 
            }else{if (num < 0) {
                negativos[contneg] = num;
                contneg ++;
                
            }else{if (num == 0) {
                neutros[contneu]=num;
                contneu ++;}
        }

    }

} // se muestra cada vector para ver cuantos numeros poaitivos hay
// cuntos negativos y neutros
        System.out.println("\nNúmeros positivos ingresados:");
        for (int i =0; i < contpos; i++) {
            System.out.println(positivos[i]);

            }
        System.out.println("\nNúmeros negativos ingresados:");
        for (int i = 0; i < contneg; i++) {
            System.out.println(negativos[i]); 

        
}
    System.out.println("\nNúmeros neutros ingresados:");
        for (int i = 0; i < contneu; i++) {
            System.out.println(neutros[i]); 
}
System.out.println("\nCantidad de números positivos: " + contpos);
System.out.println("Cantidad de números negativos: " + contneg);
System.out.println("Cantidad de números neutros: " + contneu);


}}