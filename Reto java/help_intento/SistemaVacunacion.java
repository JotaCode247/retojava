package help_intento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;

/**
 * CLASE PRINCIPAL: Contiene el método main, el menú y gestiona la colección de pacientes.
 * Debe ser la única clase 'public' si todas están en el mismo archivo.
 */
public class SistemaVacunacion {

    // Uso de colecciones (ArrayList y LinkedList) para almacenar datos
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<String> registros = new LinkedList<>(); // Ejemplo de uso de LinkedList
    private static Scanner scanner = new Scanner(System.in);

    // --- MÓDULO DE REGISTRO ---
    public static void moduloRegistro() {
        System.out.println("\n--- MÓDULO DE REGISTRO DE PACIENTES ---");
        
        System.out.print("Ingrese Primer Nombre: ");
        String primerNombre = scanner.nextLine().trim();
        System.out.print("Ingrese Primer Apellido: ");
        String primerApellido = scanner.nextLine().trim();
        System.out.print("Ingrese Número de Cédula: ");
        String cedula = scanner.nextLine().trim();

        // Ciclo for para validar la existencia (evitar duplicados de cédula)
        for (Paciente p : pacientes) {
            if (p.getCedula().equals(cedula)) {
                System.out.println("❌ Error: Esta cédula ya se encuentra registrada.");
                return;
            }
        }

        String fechaNacimientoStr;
        // Ciclo while para asegurar el formato de fecha correcto
        while (true) {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            fechaNacimientoStr = scanner.nextLine().trim();
            try {
                LocalDate fechaNac = LocalDate.parse(fechaNacimientoStr);
                if (fechaNac.isAfter(LocalDate.now())) {
                    System.out.println("La fecha de nacimiento no puede ser futura.");
                    continue;
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto o fecha inválida. Use YYYY-MM-DD (Ej: 1960-01-15).");
            }
        }
        
        System.out.print("Ingrese Sexo (M/F): ");
        String sexo = scanner.nextLine().trim();
        
        System.out.print("Ingrese Tipo de Sangre (Ej: O+, A-): ");
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

        // Generación de la Clave de Acceso (Primeras 2 letras Nombre + 2 Apellido + Cédula)
        String claveGenerada = (
            primerNombre.substring(0, Math.min(2, primerNombre.length())).toUpperCase() + 
            primerApellido.substring(0, Math.min(2, primerApellido.length())).toUpperCase() + 
            cedula
        );

        // Almacenar el paciente en el ArrayList
        Paciente nuevoPaciente = new Paciente(
            primerNombre, primerApellido, cedula, fechaNacimientoStr, 
            sexo, tipoSangre, peso, claveGenerada
        );
        pacientes.add(nuevoPaciente);
        registros.add("REGISTRO: " + cedula); // Registro de log en LinkedList

        System.out.println("\n--- REGISTRO COMPLETO ---");
        System.out.printf("Paciente %s %s registrado con éxito.\n", primerNombre, primerApellido);
        System.out.printf("Su **Clave de Acceso** para la cita es: **%s**\n", claveGenerada);
        System.out.println("-------------------------------\n");
    }

    // --- MÓDULO DE ASIGNACIÓN DE CITAS ---
    public static void moduloAsignacionCitas() {
        if (pacientes.isEmpty()) {
            System.out.println("\n⚠️ Debe haber pacientes registrados primero.");
            return;
        }

        System.out.println("\n--- MÓDULO DE ASIGNACIÓN DE CITAS ---");
        
        System.out.print("Ingrese su Cédula: ");
        String cedulaLogin = scanner.nextLine().trim();
        System.out.print("Ingrese su Clave de Acceso: ");
        String claveLogin = scanner.nextLine().trim();

        Paciente pacienteEncontrado = null;

        // Ciclo for para buscar el paciente y validar credenciales
        for (Paciente p : pacientes) {
            // Condicional de validación
            if (p.getCedula().equals(cedulaLogin) && p.getClaveGenerada().equals(claveLogin)) {
                pacienteEncontrado = p;
                break;
            }
        }
        
        if (pacienteEncontrado != null) {
            System.out.println("\n✅ Acceso validado. Calculando fecha de cita...");
            // Llamada al método estático de la lógica de negocio
            LogicaCitas.calcularFechaCita(pacienteEncontrado);
        } else {
            System.out.println("\n❌ Error de Acceso: Cédula o Clave no coinciden con un registro válido.");
            System.out.println("------------------------------------------\n");
        }
    }

    /**
     * Menú Principal (Método main).
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
                opcion = 0; // Opción no válida
            }

            // Uso de la estructura switch/case
            switch (opcion) {
                case 1:
                    moduloRegistro();
                    break;
                case 2:
                    moduloAsignacionCitas();
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


/**
 * CLASE PACIENTE: Modelo de datos.
 * No es public para coexistir con la clase principal en un solo archivo.
 */
class Paciente {
    private String primerNombre;
    private String primerApellido;
    private String cedula;
    private String fechaNacimiento; 
    private String sexo;
    private String tipoSangre;
    private double peso;
    private String claveGenerada;

    public Paciente(String primerNombre, String primerApellido, String cedula, String fechaNacimiento, String sexo, String tipoSangre, double peso, String claveGenerada) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipoSangre = tipoSangre;
        this.peso = peso;
        this.claveGenerada = claveGenerada;
    }

    // Getters
    public String getCedula() { return cedula; }
    public String getClaveGenerada() { return claveGenerada; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getSexo() { return sexo; }
    public String getTipoSangre() { return tipoSangre; }
    public double getPeso() { return peso; }
}


/**
 * CLASE LOGICACITAS: Contiene toda la lógica de negocio (métodos public static).
 * No es public para coexistir con la clase principal en un solo archivo.
 */
class LogicaCitas {

    /**
     * Calcula la edad de una persona en Años, Meses, Días y el total en días.
     * @return Array de Long: {totalDias, años, meses, dias}
     */
    public static long[] obtenerEdadCompleta(String fechaNacimientoStr) {
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        LocalDate fechaActual = LocalDate.now();

        // 1. Cálculo total en días (usado en la fórmula)
        long edadEnDias = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual);

        // 2. Cálculo desglosado (Años, Meses, Días)
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        
        long años = periodo.getYears();
        long meses = periodo.getMonths();
        long dias = periodo.getDays();

        return new long[]{edadEnDias, años, meses, dias};
    }

    /**
     * Convierte el resultado de la fechaCita (en días) a "X meses y X días".
     */
    public static String convertirDiasAMesesDias(long dias) {
        // Asumiendo 30 días por mes
        long meses = dias / 30;  
        long diasRestantes = dias % 30; 
        return String.format("%d meses y %d días", meses, diasRestantes);
    }

    /**
     * Valida si un número es primo. Usa un ciclo for.
     */
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        // Ciclo for para verificar divisibilidad
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Función principal que aplica la lógica de priorización usando if-else anidados.
     */
    public static void calcularFechaCita(Paciente paciente) {
        
        long[] edadData = obtenerEdadCompleta(paciente.getFechaNacimiento());
        long edadEnDias = edadData[0];
        long edadEnAnos = edadData[1];
        
        if (edadEnDias <= 0) {
             System.out.println("\n❌ Error: La fecha de nacimiento no es válida o es futura.");
             return;
        }

        // Preparación de variables para la lógica condicional
        String sexo = paciente.getSexo().toUpperCase();
        double peso = paciente.getPeso();
        String tipoSangre = paciente.getTipoSangre().toUpperCase();
        
        String cedulaStr = paciente.getCedula();
        int ultimosDosDigitos = 0;
        if (cedulaStr.length() >= 2) {
             ultimosDosDigitos = Integer.parseInt(cedulaStr.substring(cedulaStr.length() - 2));
        }
        boolean esPrimoCedula = esPrimo(ultimosDosDigitos);

        double divisor = 0;

        // --- LÓGICA DE PRIORIZACIÓN CON IF/ELSE ANIDADOS ---

        if (edadEnAnos < 60) {
            // Personas menores de 60 años
            divisor = 250; 
        } else {
            // Personas mayores o iguales a 60 años
            
            if (sexo.equals("F")) {
                // MUJERES >= 60 AÑOS
                
                if (peso < 70) {
                    divisor = 100; // Peso < 70 kg
                } else {
                    // Peso >= 70 kg
                    if (tipoSangre.equals("O+")) {
                        if (esPrimoCedula) {
                            divisor = 150; // O+ y Primo
                        } else {
                            divisor = 80;  // O+ y No Primo
                        }
                    } else if (tipoSangre.equals("A-")) {
                        if (esPrimoCedula) {
                            divisor = 200; // A- y Primo
                        } else {
                            divisor = 45;  // A- y No Primo
                        }
                    } else {
                        // Otros Tipos de Sangre
                        if (esPrimoCedula) {
                            divisor = 175; // Otros y Primo
                        } else {
                            divisor = 175; // Otros y No Primo
                        }
                    }
                }
            } else if (sexo.equals("M")) {
                // HOMBRES >= 60 AÑOS
                
                if (peso < 80) {
                    divisor = 105; // Peso < 80 kg
                } else {
                    // Peso >= 80 kg
                    if (tipoSangre.equals("O+")) {
                        if (esPrimoCedula) {
                            divisor = 180; // O+ y Primo
                        } else {
                            divisor = 90;  // O+ y No Primo
                        }
                    } else if (tipoSangre.equals("A-")) {
                        if (esPrimoCedula) {
                            divisor = 210; // A- y Primo
                        } else {
                            divisor = 40;  // A- y No Primo
                        }
                    } else {
                        // Otros Tipos de Sangre
                        if (esPrimoCedula) {
                            divisor = 145; // Otros y Primo
                        } else {
                            divisor = 145; // Otros y No Primo
                        }
                    }
                }
            }
        } 

        // Aplicación de la fórmula final y uso de Math.ceil (techo)
        long fechaCitaDias = (long) Math.ceil(edadEnDias / divisor);
        String fechaFormateada = convertirDiasAMesesDias(fechaCitaDias);
        
        System.out.println("\n--- ASIGNACIÓN EXITOSA ---");
        System.out.printf("Edad calculada: %d años, %d meses y %d días.\n", edadData[1], edadData[2], edadData[3]);
        System.out.printf("Edad total en días utilizada para el cálculo: %d\n", edadEnDias);
        System.out.printf("Divisor de prioridad aplicado: %.0f\n", divisor);
        System.out.printf("Días de espera calculados: %d\n", fechaCitaDias);
        System.out.printf("Su cita de vacunación será en: **%s**\n", fechaFormateada);
        System.out.println("-------------------------------\n");
    }
}