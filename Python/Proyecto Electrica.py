import tkinter as tk
from tkinter import messagebox

def calcular_ohm():
    v = float(voltaje.get())
    r = float(resistencia.get())
    i = v / r
    corriente.set(i)

# Crear la ventana principal
ventana = tk.Tk()
ventana.title("Calculadora de Circuitos Eléctricos")

# Crear etiquetas y campos de entrada
tk.Label(ventana, text="Voltaje (V):").grid(row=0, column=0)
voltaje = tk.Entry(ventana)
voltaje.grid(row=0, column=1)

tk.Label(ventana, text="Resistencia (Ω):").grid(row=1, column=0)
resistencia = tk.Entry(ventana)
resistencia.grid(row=1, column=1)

tk.Label(ventana, text="Corriente (I):").grid(row=2, column=0)
corriente = tk.StringVar(value="0")
tk.Entry(ventana, textvariable=corriente).grid(row=2, column=1)

# Botón para calcular
tk.Button(ventana, text="Calcular", command=calcular_ohm).grid(row=3, column=0, columnspan=2)

ventana.mainloop()