import java.util.Scanner;

public class mediabaja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double suma = 0; 
        double nota; 
        double menor = 100;  // Valor inicial muy alto

        // Ciclo para leer 10 calificaciones
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese la calificación del alumno " + i + " (1 a 5): ");
            nota = sc.nextDouble();

            // Validación: la nota debe estar entre 1 y 5
            while (nota < 1 || nota > 5) {
                System.out.print("Error. La nota debe ser entre 1 y 5. Intente otra vez: ");
                nota = sc.nextDouble();
            }

            // Acumular para el promedio
            suma += nota;

            // Verificar si es la menor
            if (nota < menor) {
                menor = nota;
            }
        }

        double promedio = suma / 10;

        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Calificación media del grupo: " + promedio);
        System.out.println("Calificación más baja: " + menor);
    }
}
