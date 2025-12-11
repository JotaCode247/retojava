import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate; // import trabajar con la fecha actual --

public class MiVereda {

    // --- Constantes para Acceder a Datos ---
    // para recordar qué dato está en cada posición del ArrayList.
    // uso de privte solo puede ser accedida y modificada dentro de esta misma clase
    // (MiVereda
    private static final int NOMBRE = 0;
    private static final int APELLIDO = 1;
    private static final int CEDULA = 2;
    private static final int FECHA_NAC = 3;
    private static final int SEXO = 4;
    private static final int TIPO_SANGRE = 5;
    private static final int PESO = 6;
    private static final int CLAVE = 7;

    /*
     * aqui Almacenamos cada paciente medianate un ArrayList de Strings dentro
     * de otro ArrayList principal.
     */
    private static List<ArrayList<String>> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // seccion de registro-------

    /**
     * aqui Registro de Pacientes y generación de la clave de acceso.
     */
    public static void moduloRegistro() {
        System.out.println("\n--- MÓDULO DE REGISTRO DE PACIENTES ---");

        System.out.print("Ingrese Primer Nombre: ");
        String primerNombre = scanner.nextLine().trim(); // uso trim para cortar espacion y evitar fallos de logica
        System.out.print("Ingrese Primer Apellido: ");
        String primerApellido = scanner.nextLine().trim();
        System.out.print("Ingrese Número de Cédula: ");
        String cedula = scanner.nextLine().trim();

        // Ciclo for each para validar que la cédula no estr reptida
        for (ArrayList<String> registro : pacientes) {
            if (registro.get(CEDULA).equals(cedula)) {
                System.out.println(" Error: Esta cédula ya se encuntra registrada.");
                return;
            }
        }

        String fechaNacimientoStr;
        // uso de Ciclo while y try-catch para asegurar el formato de fecha correcto
        // (string para ser mas felxible)
        while (true) {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            fechaNacimientoStr = scanner.nextLine().trim();
            try {
                // converion de string a a fecha con el import
                LocalDate fechaNac = LocalDate.parse(fechaNacimientoStr);

                // Condicional para verificar que la fecha no sea futura
                if (fechaNac.isAfter(LocalDate.now())) {
                    System.out.println("La fecha de nacimiento no puede ser futura.");
                    continue;
                }
                break; // Si todo es correcto, salimos del ciclo while
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto o fecha inválida. Use YYYY-MM-DD (Ej: 1960-01-15).");
            }
        }

        System.out.print("Ingrese Sexo (M/F): ");
        String sexo = scanner.nextLine().trim();

        System.out.print("Ingrese Tipo de Sangre (Ej: O+, A-): ");
        // Usamos .toUpperCase() para asegurar que la validación posterior sea más
        // simple
        String tipoSangre = scanner.nextLine().trim().toUpperCase();

        double peso = 0;
        while (true) {
            System.out.print("Ingrese Peso (en Kilos): ");
            try {
                peso = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número para el peso.");
            }
        }

        // --- creacion de la clave de accs ---
        // Fórmula: Primeras 2 letras Nombre + Primeras 2 letras Apellido + Cédula
        String claveGenerada = (
        // Obtenemos los primeros 2 caracteres del nombre y los convertimos a MAYÚSCULAS
        primerNombre.substring(0, Math.min(2, primerNombre.length())).toUpperCase() +
                primerApellido.substring(0, Math.min(2, primerApellido.length())).toUpperCase() +
                // Concatenamos el número de cédula
                cedula);

        // --- ALMACENAMIENTO DE DATOS ---
        // Almacenar todos los datos en un nuevo registro (ArrayList<String>)
        ArrayList<String> nuevoPaciente = new ArrayList<>();
        nuevoPaciente.add(primerNombre);
        nuevoPaciente.add(primerApellido);
        nuevoPaciente.add(cedula);
        nuevoPaciente.add(fechaNacimientoStr);
        nuevoPaciente.add(sexo);
        nuevoPaciente.add(tipoSangre);
        nuevoPaciente.add(String.valueOf(peso));
        nuevoPaciente.add(claveGenerada);

        // Agregamos el registro completo a nuestra "base de datos" principal
        pacientes.add(nuevoPaciente);

        System.out.println("\n--- REGISTRO COMPLETO ---");
        System.out.printf("Paciente %s %s registrado con éxito.\n", primerNombre, primerApellido);
        System.out.printf("Su **Clave de Acceso** para la cita es: **%s**\n", claveGenerada);
        System.out.println("-------------------------------\n");
    }

    // seccion de priorizacion y asignaconn de cita, n entiendo, pendiente )

    /**
     * (Pendiente de Lógica)
     */
    public static void moduloAsignacionCitas() {
        System.out.println("\n--- MÓDULO DE ASIGNACIÓN DE CITAS ---");
        System.out.println("Aquí debe ir tu lógica para: ");
        System.out.println("1. Pedir Cédula y Clave.");
        System.out.println("2. Buscar el registro en la lista 'pacientes'.");
        System.out.println("3. Aplicar las funciones de cálculo de edad y priorización.");
        System.out.println("4. Mostrar el resultado.");
        System.out.println("------------------------------------------\n");
    }

    // =========================================================================
    // seccion genetald del menu
    // =========================================================================

    /**
     * Método main: Punto de entrada del programa y gestión del menú.
     */
    public static void main(String[] args) {
        int opcion = 0;

        // Ciclo do-while para mantener el menú en ejecución
        do {
            System.out.println("\n==========================================");
            System.out.println("SISTEMA DE APOYO A LA VACUNACIÓN RURAL");
            System.out.println("==========================================");
            System.out.println("1. Registrar Nuevo Paciente");
            System.out.println("2. Ingresar y Asignar Cita");
            System.out.println("3. Salir del Sistema");
            System.out.println("==========================================");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            // Uso de la estructura switch para la navegación del menú
            switch (opcion) {
                case 1:
                    moduloRegistro();
                    break;
                case 2:
                    moduloAsignacionCitas(); // Lógica pendiente
                    break;
                case 3:
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}