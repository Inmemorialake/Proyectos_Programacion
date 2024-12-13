import tkinter as tk
from tkinter import messagebox, simpledialog

# Funciones de tu aplicación de consola
def obtener_datos_usuario():
    ID = id_entry.get()
    Nombre = nombre_entry.get()
    Correo = correo_entry.get()
    registro = {"id": ID, "nombre": Nombre, "correo": Correo, "componentes": []}
    registros.append(registro)
    messagebox.showinfo("Información", "Datos del usuario ingresados exitosamente.")
    limpiar_campos()

def limpiar_campos():
    id_entry.delete(0, tk.END)
    nombre_entry.delete(0, tk.END)
    correo_entry.delete(0, tk.END)

def añadir_componente():
    if not registros:
        messagebox.showwarning("Advertencia", "Primero debe ingresar los datos del usuario.")
        return
    resistencia = simpledialog.askfloat("Añadir Componente", "Ingrese la resistencia (Ohm):")
    voltaje = simpledialog.askfloat("Añadir Componente", "Ingrese el voltaje (V):")
    if resistencia is not None and voltaje is not None:
        registros[indice_actual]["componentes"].append({"resistencia": resistencia, "voltaje": voltaje})
        messagebox.showinfo("Información", "Componente añadido exitosamente.")

def calcular_circuito():
    if not registros:
        messagebox.showwarning("Advertencia", "Primero debe ingresar los datos del usuario.")
        return
    tipo = simpledialog.askstring("Calcular Circuito", "Ingrese el tipo de circuito (serie/paralelo):").strip().lower()
    componentes = registros[indice_actual]["componentes"]
    resistencias = [comp["resistencia"] for comp in componentes]
    voltajes = [comp["voltaje"] for comp in componentes]
    resistencia_equivalente = calcular_resistencia_equivalente(resistencias, tipo)
    voltaje_total = sum(voltajes)
    corriente_total = calcular_corriente_total(voltaje_total, resistencia_equivalente)
    messagebox.showinfo("Resultados",
                        f"Resistencia Equivalente: {resistencia_equivalente} Ohm\nVoltaje Total: {voltaje_total} V\nCorriente Total: {corriente_total} A")

def mostrar_registro():
    if not registros:
        messagebox.showwarning("Advertencia", "No hay registros para mostrar.")
        return
    registro = registros[indice_actual]
    registro_info = f"ID: {registro['id']}\nNombre: {registro['nombre']}\nCorreo: {registro['correo']}\n"
    for i, comp in enumerate(registro["componentes"], start=1):
        registro_info += f"Componente {i}: Resistencia = {comp['resistencia']} Ohm, Voltaje = {comp['voltaje']} V\n"
    messagebox.showinfo("Registro Actual", registro_info)

def buscar_registro():
    id_usuario = simpledialog.askstring("Buscar Registro", "Ingrese el ID del usuario:")
    registro = next((r for r in registros if r["id"] == id_usuario), None)
    if registro:
        global indice_actual
        indice_actual = registros.index(registro)
        mostrar_registro()
    else:
        messagebox.showwarning("Advertencia", "Registro no encontrado.")

def editar_registro():
    id_usuario = simpledialog.askstring("Editar Registro", "Ingrese el ID del usuario a editar:")
    registro = next((r for r in registros if r["id"] == id_usuario), None)
    if registro:
        nuevo_nombre = simpledialog.askstring("Editar Registro", f"Ingrese el nuevo nombre (actual: {registro['nombre']}):")
        if nuevo_nombre:
            registro["nombre"] = nuevo_nombre
        nuevo_correo = simpledialog.askstring("Editar Registro", f"Ingrese el nuevo correo (actual: {registro['correo']}):")
        if nuevo_correo:
            registro["correo"] = nuevo_correo
        for i, componente in enumerate(registro["componentes"], start=1):
            nueva_resistencia = simpledialog.askfloat("Editar Componente", f"Ingrese la nueva resistencia (Ohm) para el componente {i} (actual: {componente['resistencia']}):")
            if nueva_resistencia is not None:
                componente["resistencia"] = nueva_resistencia
            nuevo_voltaje = simpledialog.askfloat("Editar Componente", f"Ingrese el nuevo voltaje (V) para el componente {i} (actual: {componente['voltaje']}):")
            if nuevo_voltaje is not None:
                componente["voltaje"] = nuevo_voltaje
        messagebox.showinfo("Información", "Registro editado exitosamente.")
    else:
        messagebox.showwarning("Advertencia", "Registro no encontrado.")

def eliminar_registro():
    id_usuario = simpledialog.askstring("Eliminar Registro", "Ingrese el ID del usuario a eliminar:")
    registro = next((r for r in registros if r["id"] == id_usuario), None)
    if registro:
        registros.remove(registro)
        global indice_actual
        if registros:
            indice_actual = max(0, indice_actual - 1)
        else:
            indice_actual = -1
        messagebox.showinfo("Información", "Registro eliminado exitosamente.")
    else:
        messagebox.showwarning("Advertencia", "Registro no encontrado.")

def calcular_voltajes():
    if not registros:
        messagebox.showwarning("Advertencia", "No hay registros.")
        return
    voltajes_totales = [(registro, calcular_voltaje_total(registro)) for registro in registros]
    mayor_voltaje = max(voltajes_totales, key=lambda x: x[1])
    menor_voltaje = min(voltajes_totales, key=lambda x: x[1])
    messagebox.showinfo("Voltajes Totales", f"Registro con mayor voltaje total: {mayor_voltaje[0]['id']} - Voltaje Total: {mayor_voltaje[1]} V\n"
                                           f"Registro con menor voltaje total: {menor_voltaje[0]['id']} - Voltaje Total: {menor_voltaje[1]} V")

def calcular_resistencia_equivalente(resistencias, tipo):
    if tipo == "serie":
        return sum(resistencias)
    elif tipo == "paralelo":
        suma = sum(1 / r for r in resistencias if r != 0)
        return 1 / suma if suma != 0 else float('inf')

def calcular_corriente_total(voltaje, resistencia_equivalente):
    return voltaje / resistencia_equivalente

def calcular_voltaje_total(registro):
    return sum(comp["voltaje"] for comp in registro["componentes"])

def ir_primero():
    global indice_actual
    if registros:
        indice_actual = 0
        mostrar_registro()

def ir_anterior():
    global indice_actual
    if registros and indice_actual > 0:
        indice_actual -= 1
        mostrar_registro()

def ir_siguiente():
    global indice_actual
    if registros and indice_actual < len(registros) - 1:
        indice_actual += 1
        mostrar_registro()

def ir_ultimo():
    global indice_actual
    if registros:
        indice_actual = len(registros) - 1
        mostrar_registro()

# Variables
registros = []
indice_actual = -1

# Configuración de la ventana principal
root = tk.Tk()
root.title("Aplicación de Circuitos")

# Etiquetas y entradas para los datos del usuario
tk.Label(root, text="ID").grid(row=0)
tk.Label(root, text="Nombre").grid(row=1)
tk.Label(root, text="Correo").grid(row=2)

id_entry = tk.Entry(root)
nombre_entry = tk.Entry(root)
correo_entry = tk.Entry(root)

id_entry.grid(row=0, column=1)
nombre_entry.grid(row=1, column=1)
correo_entry.grid(row=2, column=1)

# Botones para las funcionalidades
tk.Button(root, text="Ingresar Datos del Usuario", command=obtener_datos_usuario).grid(row=3, columnspan=2)
tk.Button(root, text="Añadir Componente", command=añadir_componente).grid(row=4, columnspan=2)
tk.Button(root, text="Calcular Circuito", command=calcular_circuito).grid(row=5, columnspan=2)
tk.Button(root, text="Mostrar Registro Actual", command=mostrar_registro).grid(row=6, columnspan=2)
tk.Button(root, text="Buscar Registro por ID", command=buscar_registro).grid(row=7, columnspan=2)
tk.Button(root, text="Editar Registro", command=editar_registro).grid(row=8, columnspan=2)
tk.Button(root, text="Eliminar Registro", command=eliminar_registro).grid(row=9, columnspan=2)
tk.Button(root, text="Buscar Mayor y Menor Voltaje Total", command=calcular_voltajes).grid(row=10, columnspan=2)

# Botones de navegación
tk.Button(root, text="Primero", command=ir_primero).grid(row=11, column=0)
tk.Button(root, text="Anterior", command=ir_anterior).grid(row=11, column=1)
tk.Button(root, text="Siguiente", command=ir_siguiente).grid(row=12, column=0)
tk.Button(root, text="Último", command=ir_ultimo).grid(row=12, column=1)

# Bucle principal de Tkinter
root.mainloop()