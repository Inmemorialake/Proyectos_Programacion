import tkinter as tk
from tkinter import messagebox

# Funciones de cálculo
def calcular_ohm(resistencia, corriente, voltaje):
    if resistencia == 0 and corriente != 0:
        return voltaje / corriente
    elif corriente == 0 and resistencia != 0:
        return voltaje / resistencia
    elif voltaje == 0 and resistencia != 0 and corriente != 0:
        return resistencia * corriente
    else:
        return "Todos los valores están completos o no se pueden calcular."

def calcular_resistencia_equivalente(resistencias, tipo):
    if tipo == "serie":
        suma = sum(resistencias)
        return suma
    elif tipo == "paralelo":
        suma = sum(1 / r for r in resistencias if r != 0)
        if suma != 0:
            return 1 / suma
        else:
            return float('inf')  # Evita división por cero

def calcular_corriente_total(voltaje, resistencia_equivalente):
    return voltaje / resistencia_equivalente

# Funciones de manejo de datos
datos = []

def guardar_datos(id_usuario, nombre, correo, resistencia, corriente, voltaje):
    datos.append({
        "id": id_usuario,
        "nombre": nombre,
        "correo": correo,
        "resistencia": resistencia,
        "corriente": corriente,
        "voltaje": voltaje
    })

def obtener_datos():
    return datos

# Funciones de la interfaz gráfica
def calcular(event=None):
    try:
        resistencia = float(resistencia_var.get())
        corriente = float(corriente_var.get())
        voltaje = float(voltaje_var.get())
        resultado = calcular_ohm(resistencia, corriente, voltaje)
        if resistencia == 0:
            resistencia_var.set(resultado)
        elif corriente == 0:
            corriente_var.set(resultado)
        elif voltaje == 0:
            voltaje_var.set(resultado)
        messagebox.showinfo("Resultado", "Resultado: " + str(resultado))
    except ValueError:
        messagebox.showerror("Error", "Ingrese valores numéricos válidos")

def guardar():
    id_usuario = id_var.get()
    nombre = nombre_var.get()
    correo = correo_var.get()
    resistencia = resistencia_var.get()
    corriente = corriente_var.get()
    voltaje = voltaje_var.get()
    guardar_datos(id_usuario, nombre, correo, resistencia, corriente, voltaje)
    messagebox.showinfo("Guardado", "Datos guardados correctamente.")

def mostrar_datos():
    datos_guardados = obtener_datos()
    mensaje = ""
    for dato in datos_guardados:
        mensaje = mensaje + f"ID: {dato['id']}, Nombre: {dato['nombre']}, Correo: {dato['correo']}, Resistencia: {dato['resistencia']}, Corriente: {dato['corriente']}, Voltaje: {dato['voltaje']}\n"
    messagebox.showinfo("Datos Guardados", mensaje)

# Crear la ventana principal
root = tk.Tk()
root.title("Cálculos Eléctricos")
root.geometry("600x400")

# Crear variables para los campos de entrada
id_var = tk.StringVar()
nombre_var = tk.StringVar()
correo_var = tk.StringVar()
resistencia_var = tk.StringVar(value="0")
corriente_var = tk.StringVar(value="0")
voltaje_var = tk.StringVar(value="0")

# Crear etiquetas, campos de entrada y botones
tk.Label(root, text="ID").grid(row=0, column=0)
id_entry = tk.Entry(root, textvariable=id_var)
id_entry.grid(row=0, column=1)

tk.Label(root, text="Nombre").grid(row=1, column=0)
nombre_entry = tk.Entry(root, textvariable=nombre_var)
nombre_entry.grid(row=1, column=1)

tk.Label(root, text="Correo Electrónico").grid(row=2, column=0)
correo_entry = tk.Entry(root, textvariable=correo_var)
correo_entry.grid(row=2, column=1)

tk.Label(root, text="Resistencia (Ohm)").grid(row=3, column=0)
resistencia_entry = tk.Entry(root, textvariable=resistencia_var)
resistencia_entry.grid(row=3, column=1)

tk.Label(root, text="Corriente (A)").grid(row=4, column=0)
corriente_entry = tk.Entry(root, textvariable=corriente_var)
corriente_entry.grid(row=4, column=1)

tk.Label(root, text="Voltaje (V)").grid(row=5, column=0)
voltaje_entry = tk.Entry(root, textvariable=voltaje_var)
voltaje_entry.grid(row=5, column=1)

# Vincular el evento de presionar "Enter" con la función calcular
root.bind('<Return>', calcular)

tk.Button(root, text="Guardar", command=guardar).grid(row=7, column=0, columnspan=2)
tk.Button(root, text="Mostrar Datos", command=mostrar_datos).grid(row=8, column=0, columnspan=2)

# Ejecutar la aplicación
root.mainloop()