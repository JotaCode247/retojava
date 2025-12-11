import java.util.Scanner;
public class array_ejemp {
    public static void main(String[] args) {
        int tam=4;
        String[] documentos= new String[tam];
        String[] nombres= new String[tam];
        String[] apellidos= new String[tam];
        double[] algoritmosN1= new double[tam];
        double[] algoritmosN2= new double[tam];
        double[] algoritmosN3= new double[tam];
        double[] algoritmosDef= new double[tam];
        double[] inglesN1= new double[tam];
        double[] inglesN2= new double[tam];
        double[] inglesN3= new double[tam];
        double[] inglesDef= new double[tam];
        double[] matematicasN1= new double[tam];
        double[] matematicasN2= new double[tam];
        double[] matematicasN3= new double[tam];
        double[] matematicasDef= new double[tam];
        double[] promedio= new double[tam];
        //variables para promedios mayores y menores
        double pmy = 0;
        double pmn = 5;
        String npmy="";
        String npmn="";
        //variables para promedios mayores y menores de las notas
        //MATEMATICAS
        double myM = 0;
        double mnM = 5;
        String nmmM="";
        String nmnM="";
        //INGLES
        double myI = 0;
        double mnI = 5;
        String nmmI="";
        String nmnI="";
        //ALGORITMIA
        double myA = 0;
        double mnA = 5;
        String nmmA="";
        String nmnA="";


        Scanner st= new Scanner(System.in);
        Scanner sc= new Scanner (System.in);

        //------------------Cargar todos los datos-----------------------------
        for( int i=0; i<documentos.length; i++){
            //--------------documento, nombre y apellido-----------------------
            System.out.println("digite su documento estudiante: "+(i+1)+ " por favor: ");
            documentos[i]=st.nextLine();
            System.out.println("digite su nombre estudiante: "+(i+1));
            nombres[i]= st.nextLine();
            System.out.println("digite sus apellidos estudiante: "+(i+1));
            apellidos[i]= st.nextLine();
            //-----------------notas algoritmia--------------------------------
            System.out.println("digite su nota (1) en la materia de algoritmos del estudiante: "+(i+1));
            algoritmosN1[i]= sc.nextDouble();
            System.out.println("digite su nota (2) en la materia de algoritmos del estudiante: "+(i+1));
            algoritmosN2[i]= sc.nextDouble(); 
            System.out.println("digite su nota (3) en la materia de algoritmos del estudiante: "+(i+1)); 
            algoritmosN3[i]= sc.nextDouble(); 
            //-----------------notas ingles------------------------------------
            System.out.println("digite su nota (1) en la materia de ingles del estudiante: "+(i+1));
            inglesN1[i]= sc.nextDouble();
            System.out.println("digite su nota (2) en la materia de inglesd el estudiante: "+(i+1));
            inglesN2[i]= sc.nextDouble();
            System.out.println("digite su nota (3) en la materia de ingles del estudiante: "+(i+1));
            inglesN3[i]= sc.nextDouble();
            //-----------------notas matematicas--------------------------------
            System.out.println("digite su nota (1) en la materia de matematicas del estudiante: "+(i+1));
            matematicasN1[i]= sc.nextDouble();
            System.out.println("digite su nota (2) en la materia de matematicas del estudiante: "+(i+1));
            matematicasN2[i]= sc.nextDouble();
            System.out.println("digite su nota (3) en la materia de matematicas del estudiante: "+(i+1));
            matematicasN3[i]= sc.nextDouble();
        }
        //-----------------------notas definitivas y promedio------------------------------
        for(int i=0; i < algoritmosDef.length;i++ ){
            algoritmosDef[i]=Math.round((algoritmosN1[i]+ algoritmosN2[i]+algoritmosN3[i])/3*100.0)/100.0;
            inglesDef[i]=Math.round((inglesN1[i]+inglesN2[i]+inglesN3[i])/3*100.0)/100.0;
            matematicasDef[i]=Math.round((matematicasN1[i]+matematicasN2[i]+matematicasN3[i])/3*100.0)/100.0;
            promedio[i]= Math.round((algoritmosDef[i]+inglesDef[i]+matematicasDef[i])/3*100.0)/100.0 ;
        }
        //-----------------------imprimir los promedios------------------------------------
        for(int i=0; i < promedio.length;i++ ){
            System.out.println("Definitiva algoritmos de: "+ nombres[i]+ " es: "+algoritmosDef[i]);
            System.out.println("Definitiva ingles de: "+ nombres[i]+ " es: "+inglesDef[i]);
            System.out.println("Definitiva de matematicas de: "+ nombres[i]+ " es: "+matematicasDef[i]);
            System.out.println("el promedio de "+nombres[i]+" es: "+promedio[i]);

            
        } 
        //------------------------promdeio mayor y menor-----------------------------------
        for (int i=0; i<promedio.length; i++){
            if (promedio[i]>pmy){
                pmy+=promedio[i];
                npmy= "el estudiante: "+ nombres[i];
            }
            if(promedio[i]<pmn){
                pmn=promedio[i];
                npmn= "el estudiante: "+ nombres[i];
            }
        }
        System.out.println("el promedio mayor es del estudiante: "+npmy+" con el promedio: "+ pmy);
        System.out.println("el promedio menor es del estudiante: "+npmn+" con el promedio: "+ pmn);

        //------------------------------promedio mayor de cada materia-------------------------
        /*---------------------------------INGLES--------------------------------------------- */
        for (int i=0; i<inglesDef.length; i++){
            if (inglesDef[i]>myI){
                myI+=inglesDef[i];
                nmmI= "el estudiante: "+ nombres[i];
            }
            if(inglesDef[i]<mnI){
                mnI=inglesDef[i];
                nmnI= "el estudiante: "+ nombres[i];
            }
        }
        System.out.println("la nota mayor en ingles es del estudiante: "+nmmI+" con el la definitiva: "+ myI);
        System.out.println("la nota menor en ingles es del estudiante: "+nmnI+" con el promedio: "+ mnI);

        /*---------------------------------MATEMATICAS--------------------------------------------- */
        for (int i=0; i<matematicasDef.length; i++){
            if (matematicasDef[i]>myM){
                myM+=matematicasDef[i];
                nmmM= "el estudiante: "+ nombres[i];
            }
            if(matematicasDef[i]<mnM){
                mnM=matematicasDef[i];
                nmnM= "el estudiante: "+ nombres[i];
            }
        }
        System.out.println("la nota mayor en Matematicas es del estudiante: "+nmmM+" con el la definitiva: "+ myM);
        System.out.println("la nota menor en Matematicas es del estudiante: "+nmnM+" con el promedio: "+ mnM);

        /*---------------------------------ALGORITMOS--------------------------------------------- */
        for (int i=0; i<algoritmosDef.length; i++){
            if (algoritmosDef[i]>myA){
                myA+=algoritmosDef[i];
                nmmA= "el estudiante: "+ nombres[i];
            }
            if(algoritmosDef[i]<mnA){
                mnA=algoritmosDef[i];
                nmnA= "el estudiante: "+ nombres[i];
            }
        }
        System.out.println("la nota mayor en Algoritmos es del estudiante: "+nmmA+" con el la definitiva: "+ myA);
        System.out.println("la nota menor en Algoritmos es del estudiante: "+nmnA+" con el promedio: "+ mnA);
    }
}
