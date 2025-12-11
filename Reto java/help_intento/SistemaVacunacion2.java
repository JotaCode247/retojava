package help_intento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate; // Única importación de fecha restante
import java.util.LinkedList;

/**
 * CLASE PRINCIPAL: Contiene el método main, el menú y gestiona la colección de pacientes.
 * Se tuvo que modificar la lógica de cálculo de edad para no usar ChronoUnit ni Period.
 */
public class SistemaVacunacion2 {

    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<String> registros = new LinkedList<>();
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

        for (Paciente p : pacientes) {
            if (p.getCedula().equals(cedula)) {
                System.out.println("❌ Error: Esta cédula ya se encuentra registrada.");
                return;
            }
        }

        String fechaNacimientoStr;
        while (true) {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            fechaNacimientoStr = scanner.nextLine().trim();
            try {
                // Validación básica de formato y fecha sin DateTimeParseException
                String[] partes = fechaNacimientoStr.split("-");
                if (partes.length != 3) throw new Exception();
                
                LocalDate fechaNac = LocalDate.parse(fechaNacimientoStr);
                
                if (fechaNac.isAfter(LocalDate.now())) {
                    System.out.println("La fecha de nacimiento no puede ser futura.");
                    continue;
                }
                break;
            } catch (Exception e) { // Se usa la excepción genérica para capturar el error de formato
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

        String claveGenerada = (
            primerNombre.substring(0, Math.min(2, primerNombre.length())).toUpperCase() + 
            primerApellido.substring(0, Math.min(2, primerApellido.length())).toUpperCase() + 
            cedula
        );

        Paciente nuevoPaciente = new Paciente(
            primerNombre, primerApellido, cedula, fechaNacimientoStr, 
            sexo, tipoSangre, peso, claveGenerada
        );
        pacientes.add(nuevoPaciente);
        registros.add("REGISTRO: " + cedula);

        System.out.println("\n--- REGISTRO COMPLETO ---");
        System.out.printf("Paciente %s %s registrado con éxito.\n", primerNombre, primerApellido);
        System.out.printf("Su **Clave de Acceso** para la cita es: **%s**\n", claveGenerada);
        System.out.println("-------------------------------\n");
    }

    // --- MÓDULO DE ASIGNACIÓN DE CITAS ---
    public static void moduloAsignacionCitas() {
        if (pacientes.isEmpty()) {
            System.out.println("\n Debe haber pacientes registrados primero.");
            return;
        }

        System.out.println("\n--- MÓDULO DE ASIGNACIÓN DE CITAS ---");
        
        System.out.print("Ingrese su Cédula: ");
        String cedulaLogin = scanner.nextLine().trim();
        System.out.print("Ingrese su Clave de Acceso: ");
        String claveLogin = scanner.nextLine().trim();

        Paciente pacienteEncontrado = null;

        for (Paciente p : pacientes) {
            if (p.getCedula().equals(cedulaLogin) && p.getClaveGenerada().equals(claveLogin)) {
                pacienteEncontrado = p;
                break;
            }
        }
        
        if (pacienteEncontrado != null) {
            System.out.println("\n Acceso validado. Calculando fecha de cita...");
            LogicaCitas.calcularFechaCita(pacienteEncontrado);
        } else {
            System.out.println("\n Error de Acceso: Cédula o Clave no coinciden con un registro válido.");
            System.out.println("------------------------------------------\n");
        }
    }

    // --- Menú Principal (Método main) ---
    public static void main(String[] args) {
        int opcion = 0;
        
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
 * CLASE LOGICACITAS: Contiene la lógica de negocio.
 * El cálculo de edad se realiza manualmente sin ChronoUnit ni Period.
 */
class LogicaCitas {

    /**
     * Calcula la edad de una persona en Días, Años, Meses y Días (residual).
     * @return Array de Long: {totalDias, años, meses, dias}
     */
    public static long[] obtenerEdadCompleta(String fechaNacimientoStr) {
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        LocalDate fechaActual = LocalDate.now();

        int añoNac = fechaNacimiento.getYear();
        int mesNac = fechaNacimiento.getMonthValue();
        int diaNac = fechaNacimiento.getDayOfMonth();
        int añoActual = fechaActual.getYear();
        int mesActual = fechaActual.getMonthValue();
        int diaActual = fechaActual.getDayOfMonth();

        // 1. Cálculo de AÑOS (Manual)
        long años = añoActual - añoNac;
        if (mesActual < mesNac || (mesActual == mesNac && diaActual < diaNac)) {
            años--;
        }

        // 2. Cálculo de MESES y DÍAS (Residual, no exacto como Period, pero suficiente para el display)
        long meses = mesActual - mesNac;
        if (meses < 0) {
            meses += 12;
        }

        long dias = diaActual - diaNac;
        if (dias < 0) {
            // Este cálculo es complejo sin Period/ChronoUnit, solo se usará la diferencia simple en el display
            dias = 0; // Se simplifica el cálculo residual de días
        }

        // 3. Cálculo total en DÍAS (Manual y aproximado)
        // Se usa un método iterativo básico para calcular los días, ya que ChronoUnit fue eliminado.
        long edadEnDias = 0;
        LocalDate fechaIterador = fechaNacimiento;
        while (fechaIterador.isBefore(fechaActual)) {
            fechaIterador = fechaIterador.plusDays(1);
            edadEnDias++;
        }
        
        return new long[]{edadEnDias, años, meses, dias};
    }

    /**
     * Convierte el resultado de la fechaCita (en días) a "X meses y X días".
     */
    public static String convertirDiasAMesesDias(long dias) {
        long meses = dias / 30;  
        long diasRestantes = dias % 30; 
        return String.format("%d meses y %d días", meses, diasRestantes);
    }

    /**
     * Valida si un número es primo.
     */
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
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
            divisor = 250; 
        } else {
            if (sexo.equals("F")) {
                // MUJERES >= 60 AÑOS
                if (peso < 70) {
                    divisor = 100;
                } else {
                    if (tipoSangre.equals("O+")) {
                        divisor = esPrimoCedula ? 150 : 80;
                    } else if (tipoSangre.equals("A-")) {
                        divisor = esPrimoCedula ? 200 : 45;
                    } else {
                        divisor = 175; // 175 tanto para primo como no primo
                    }
                }
            } else if (sexo.equals("M")) {
                // HOMBRES >= 60 AÑOS
                if (peso < 80) {
                    divisor = 105;
                } else {
                    if (tipoSangre.equals("O+")) {
                        divisor = esPrimoCedula ? 180 : 90;
                    } else if (tipoSangre.equals("A-")) {
                        divisor = esPrimoCedula ? 210 : 40;
                    } else {
                        divisor = 145; // 145 tanto para primo como no primo
                    }
                }
            }
        } 

        // Aplicación de la fórmula final
        long fechaCitaDias = (long) Math.ceil(edadEnDias / divisor);
        String fechaFormateada = convertirDiasAMesesDias(fechaCitaDias);
        
        System.out.println("\n--- ASIGNACIÓN EXITOSA ---");
        System.out.printf("Edad calculada: %d años, %d meses y %d días (Aproximado).\n", edadData[1], edadData[2], edadData[3]);
        System.out.printf("Edad total en días utilizada para el cálculo: %d\n", edadEnDias);
        System.out.printf("Divisor de prioridad aplicado: %.0f\n", divisor);
        System.out.printf("Días de espera calculados: %d\n", fechaCitaDias);
        System.out.printf("Su cita de vacunación será en: **%s**\n", fechaFormateada);
        System.out.println("-------------------------------\n");
    }
}
