import math 
from datetime import date # Importar módulo datetime para manejar fechas

# --- 💾 ESTRUCTURA DE DATOS GLOBAL ---
# Lista para almacenar los datos de los pacientes registrados
pacientes = []

# --- ⚙️ FUNCIONES AUXILIARES DE LÓGICA DE NEGOCIO ---

def es_primo(n):
    """
    Valida si un número entero es primo.
    Un número primo es aquel mayor que 1 que solo es divisible por 1 y por sí mismo.
    """
    if n <= 1:
        return False
    # Itera desde 2 hasta la raíz cuadrada de n
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def obtener_edad_completa(fecha_nacimiento_str):
    """
    Calcula la edad de una persona en Años, Meses y Días, y el total en días.
    
    Parámetros:
    - fecha_nacimiento_str: Fecha de nacimiento en formato 'YYYY-MM-DD'.
    
    Retorna:
    - Tuple (edad_en_dias, edad_años, edad_meses, edad_dias)
    """
    try:
        # Convertir la cadena de fecha a objeto date
        año_nac, mes_nac, dia_nac = map(int, fecha_nacimiento_str.split('-'))
        fecha_nacimiento = date(año_nac, mes_nac, dia_nac)
    except ValueError:
        # Manejo de error si el formato es incorrecto
        return 0, 0, 0, 0 

    fecha_actual = date.today()
    
    # 1. Cálculo de la diferencia total en días
    diferencia = fecha_actual - fecha_nacimiento
    edad_en_dias = diferencia.days
    
    # 2. Cálculo desglosado (Años, Meses, Días)
    
    # Edad en años completos (necesario para la clasificación < 60 vs >= 60)
    edad_años = fecha_actual.year - fecha_nacimiento.year
    # Ajustar si el cumpleaños aún no ha pasado este año
    if (fecha_actual.month, fecha_actual.day) < (fecha_nacimiento.month, fecha_nacimiento.day):
        edad_años -= 1
        
    # Calcular meses
    edad_meses = fecha_actual.month - fecha_nacimiento.month
    if fecha_actual.day < fecha_nacimiento.day:
        edad_meses -= 1
        
    # Ajustar si el mes es negativo
    if edad_meses < 0:
        edad_meses += 12

    # Calcular días
    edad_dias = fecha_actual.day - fecha_nacimiento.day
    if edad_dias < 0:
        # Tomamos el último día del mes anterior (de la fecha actual)
        # Esto es un cálculo de edad estándar, que usa 30 o 31 días según el mes anterior
        import calendar
        dias_mes_anterior = calendar.monthrange(fecha_actual.year, fecha_actual.month - 1)[1] if fecha_actual.month > 1 else 31
        edad_dias += dias_mes_anterior

    return edad_en_dias, edad_años, edad_meses, edad_dias

def convertir_dias_a_meses_dias(dias):
    """
    Convierte el resultado de la fechaCita (en días) a "X meses y X días".
    (Aplica la regla de salida del sistema).
    """
    # Se usa 30 días por mes para la conversión final, según el contexto del reto
    meses = dias // 30  # División entera para obtener el número de meses completos
    dias_restantes = dias % 30 # Módulo para obtener los días restantes
    return f"{meses} meses y {dias_restantes} días"

def calcular_fecha_cita(datos_paciente):
    """
    Función principal para calcular la fecha de la cita basada en los parámetros de priorización.
    """
    # 1. Obtener y preparar datos
    
    # Calcular la edad real en días, años, meses y días a partir de la fecha de nacimiento
    edad_en_dias, edad_en_años, edad_en_meses_parciales, edad_en_dias_parciales = obtener_edad_completa(datos_paciente['fecha_nacimiento'])
    
    if edad_en_dias <= 0:
         print("\n❌ Error: La fecha de nacimiento no es válida o es futura.")
         return

    # Tomar los dos últimos dígitos de la cédula para la validación de primo
    cedula_str = str(datos_paciente['cedula'])
    ultimos_dos_digitos = int(cedula_str[-2:]) # Asume que la cédula tiene al menos 2 dígitos
    es_primo_cedula = es_primo(ultimos_dos_digitos)

    sexo = datos_paciente['sexo']
    peso = datos_paciente['peso']
    tipo_sangre = datos_paciente['tipo_sangre'] # Ya está normalizado a mayúsculas

    # Variable para almacenar el divisor de la fórmula
    divisor = None

    # --- LÓGICA DE PRIORIZACIÓN ---

    # 1. Clasificación por Edad (< 60 vs >= 60)
    if edad_en_años < 60:
        # A todas las personas menores de 60
        divisor = 250 # fechaCita=(edad persona en días/250)

    else: # Persona mayor o igual a 60 años
        # Se asume que el sexo se ingresa como 'F' o 'M'

        if sexo.upper() == 'F': # --- Clasificación para MUJERES (> 60 años) ---
            # 1.1. Evaluación por Peso (< 70 kg vs > 70 kg)
            if peso < 70:
                # Todas las mujeres mayores de 60 años que tengan un peso menor a 70 kilos
                divisor = 100 # fechaCita=(edad persona en días/100)
            
            else: # Peso mayor o igual a 70 kg
                # 1.2. Evaluación por Tipo de Sangre y Primo/No Primo (Peso >= 70 kg)
                
                if tipo_sangre == 'O+':
                    if es_primo_cedula:
                        # Mujeres > 60, O+, peso >= 70, primo
                        divisor = 150 
                    else:
                        # Mujeres > 60, O+, peso >= 70, no primo
                        divisor = 80 
                        
                elif tipo_sangre == 'A-':
                    if es_primo_cedula:
                        # Mujeres > 60, A-, peso >= 70, primo
                        divisor = 200 
                    else:
                        # Mujeres > 60, A-, peso >= 70, no primo
                        divisor = 45 

                else: # Tipo de sangre diferente a O+ y A-
                    if es_primo_cedula:
                        # Mujeres > 60, dif O+/A-, peso >= 70, primo
                        divisor = 175 
                    else:
                         # Caso "dif O+/A-, peso >= 70, no primo" no especificado. Se usa el mismo divisor.
                         divisor = 175 

        elif sexo.upper() == 'M': # --- Clasificación para HOMBRES (> 60 años) ---
            # 2.1. Evaluación por Peso (< 80 kg vs > 80 kg)
            if peso < 80:
                # Todos los hombres mayores de 60 años que tengan un peso menor a 80 kilos
                divisor = 105 
            
            else: # Peso mayor o igual a 80 kg
                # 2.2. Evaluación por Tipo de Sangre y Primo/No Primo (Peso >= 80 kg)

                if tipo_sangre == 'O+':
                    if es_primo_cedula:
                        # Hombres > 60, O+, peso >= 80, primo
                        divisor = 180 
                    else:
                        # Hombres > 60, O+, peso >= 80, no primo
                        divisor = 90 
                        
                elif tipo_sangre == 'A-':
                    if es_primo_cedula:
                        # Hombres > 60, A-, peso >= 80, primo
                        divisor = 210 
                    else:
                        # Hombres > 60, A-, peso >= 80, no primo
                        divisor = 40 

                else: # Tipo de sangre diferente a O+ y A-
                    if es_primo_cedula:
                        # Hombres > 60, dif O+/A-, peso >= 80, primo
                        divisor = 145 
                    else:
                        # Caso "dif O+/A-, peso >= 80, no primo" no especificado. Se usa el mismo divisor.
                        divisor = 145 

    # 2. Aplicación de la fórmula final
    if divisor is not None:
        # fechaCita = (edad persona en días / divisor)
        # Se usa math.ceil para asegurar que el resultado sea un número entero de días (techo)
        fecha_cita_dias = math.ceil(edad_en_dias / divisor) 
        
        # Convertir el resultado a "X meses y X días"
        fecha_formateada = convertir_dias_a_meses_dias(fecha_cita_dias)
        
        print("\n--- ASIGNACIÓN EXITOSA ---")
        print(f"Edad calculada: {edad_en_años} años, {edad_en_meses_parciales} meses y {edad_en_dias_parciales} días.")
        print(f"Edad total en días utilizada para el cálculo: {edad_en_dias}")
        print(f"Divisor de prioridad aplicado: {divisor}")
        print(f"Días de espera calculados: {fecha_cita_dias}")
        print(f"Su cita de vacunación será en: **{fecha_formateada}**")
        print("-------------------------------\n")
    else:
        print("\n❌ Error: No se pudo asignar una cita. Verifique los datos ingresados.")


# --- 1. MÓDULO DE REGISTRO ---

def modulo_registro():
    """
    Solicita los datos del paciente (incluyendo Fecha de Nacimiento) y genera la clave de acceso.
    """
    print("\n--- MÓDULO DE REGISTRO DE PACIENTES ---")
    
    # 1. Captura de datos básicos
    primer_nombre = input("Ingrese Primer Nombre: ").strip()
    primer_apellido = input("Ingrese Primer Apellido: ").strip()
    cedula = input("Ingrese Número de Cédula: ").strip()

    # Validación de existencia para evitar duplicados
    if any(p['cedula'] == cedula for p in pacientes):
        print("❌ Error: Esta cédula ya se encuentra registrada.")
        return

    # Captura de Fecha de Nacimiento
    while True:
        fecha_nacimiento_str = input("Fecha de Nacimiento (YYYY-MM-DD): ").strip()
        try:
            # Validación de formato de fecha
            año, mes, dia = map(int, fecha_nacimiento_str.split('-'))
            fecha_nac = date(año, mes, dia) 
            
            # Verificación de que la fecha no sea futura
            if fecha_nac > date.today():
                print("La fecha de nacimiento no puede ser futura.")
                continue
            
            break
        except ValueError:
            print("Formato de fecha incorrecto o fecha inválida. Use YYYY-MM-DD (Ej: 1960-01-15).")
            continue
    
    sexo = input("Ingrese Sexo (M/F): ").strip()
    
    # Validar y normalizar el tipo de sangre a mayúsculas
    tipo_sangre = input("Ingrese Tipo de Sangre (Ej: O+, A-): ").strip().upper() 

    while True:
        try:
            peso = float(input("Ingrese Peso (en Kilos): "))
            break
        except ValueError:
            print("Entrada inválida. Ingrese un número para el peso.")

    # 2. Generación de la Clave de Acceso
    # Clave: primeras 2 letras del nombre + primeras 2 letras del apellido + cédula
    clave_generada = (
        primer_nombre[:2].upper() + 
        primer_apellido[:2].upper() + 
        cedula
    )

    # 3. Almacenar los datos
    nuevo_paciente = {
        'primer_nombre': primer_nombre,
        'primer_apellido': primer_apellido,
        'cedula': cedula,
        'fecha_nacimiento': fecha_nacimiento_str, # Se almacena la fecha de nacimiento
        'sexo': sexo,
        'tipo_sangre': tipo_sangre,
        'peso': peso,
        'clave_generada': clave_generada
    }
    pacientes.append(nuevo_paciente)

    print("\n--- REGISTRO COMPLETO ---")
    print(f"Paciente {primer_nombre} {primer_apellido} registrado con éxito.")
    print(f"Su **Clave de Acceso** para la cita es: **{clave_generada}**")
    print("-------------------------------\n")


# --- 2. MÓDULO DE INICIO DE SESIÓN Y ASIGNACIÓN DE CITA ---

def modulo_asignacion_citas():
    """
    Valida las credenciales de acceso y calcula la fecha de la cita.
    """
    if not pacientes:
        print("\n⚠️ Debe haber pacientes registrados primero.")
        return

    print("\n--- MÓDULO DE ASIGNACIÓN DE CITAS ---")
    
    cedula_login = input("Ingrese su Cédula: ").strip()
    clave_login = input("Ingrese su Clave de Acceso: ").strip()

    paciente_encontrado = None

    # 1. Búsqueda y Validación de Acceso
    for p in pacientes:
        # El acceso es válido SÓLO si la cédula Y la clave coinciden
        if p['cedula'] == cedula_login and p['clave_generada'] == clave_login:
            paciente_encontrado = p
            break
    
    if paciente_encontrado:
        print("\n✅ Acceso validado. Calculando fecha de cita...")
        # 2. Llamar a la función que contiene la lógica compleja de cálculo
        calcular_fecha_cita(paciente_encontrado)
    else:
        print("\n❌ Error de Acceso: Cédula o Clave no coinciden con un registro válido.")
        print("------------------------------------------\n")


# --- MENÚ PRINCIPAL DEL SISTEMA ---

def menu_principal():
    """
    Muestra el menú principal y maneja la navegación del sistema.
    """
    while True:
        print("\n==========================================")
        print("SISTEMA DE APOYO A LA VACUNACIÓN RURAL")
        print("==========================================")
        print("1. Registrar Nuevo Paciente")
        print("2. Ingresar y Asignar Cita")
        print("3. Salir del Sistema")
        print("==========================================")
        
        opcion = input("Seleccione una opción: ").strip()

        # Uso de estructura condicional (simulando un switch/case)
        if opcion == '1':
            modulo_registro()
        elif opcion == '2':
            modulo_asignacion_citas()
        elif opcion == '3':
            print("Saliendo del sistema. ¡Gracias!")
            break
        else:
            print("Opción no válida. Intente de nuevo.")

# --- INICIO DEL PROGRAMA ---
if __name__ == "__main__":
    menu_principal()