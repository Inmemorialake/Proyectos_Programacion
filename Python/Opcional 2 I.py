import tkinter as tk
from tkinter import messagebox

class Formulario(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Gestión de Empleados")
        self.geometry("400x400")
        self.configure(padx=10, pady=10)
        
        # Listas para almacenar los datos de los empleados
        self.nombres = []
        self.salarios = []
        self.edades = []

        # Crear el contenedor principal
        vbox = tk.Frame(self, padx=5, pady=5)
        vbox.pack(fill=tk.BOTH, expand=True)
        
        # Campos de entrada
        self.lbl_nombre = tk.Label(vbox, text="Nombre:")
        self.lbl_nombre.pack()
        self.txt_nombre = tk.Entry(vbox)
        self.txt_nombre.pack()
        
        self.lbl_salario = tk.Label(vbox, text="Salario:")
        self.lbl_salario.pack()
        self.txt_salario = tk.Entry(vbox)
        self.txt_salario.pack()
        
        self.lbl_edad = tk.Label(vbox, text="Edad:")
        self.lbl_edad.pack()
        self.txt_edad = tk.Entry(vbox)
        self.txt_edad.pack()

        # Botones
        self.btn_agregar = tk.Button(vbox, text="Agregar empleado", command=self.agregar_empleado)
        self.btn_agregar.pack(fill=tk.BOTH)
        
        self.btn_salario_mayor = tk.Button(vbox, text="Salario mayor", command=self.salario_mayor)
        self.btn_salario_mayor.pack(fill=tk.BOTH)
        
        self.btn_salario_menor = tk.Button(vbox, text="Salario menor", command=self.salario_menor)
        self.btn_salario_menor.pack(fill=tk.BOTH)
        
        self.btn_sumatoria = tk.Button(vbox, text="Sumatoria de salarios", command=self.sumatoria_salarios)
        self.btn_sumatoria.pack(fill=tk.BOTH)
        
        self.btn_promedio = tk.Button(vbox, text="Promedio de salarios", command=self.promedio_salarios)
        self.btn_promedio.pack(fill=tk.BOTH)
        
        self.btn_limpiar = tk.Button(vbox, text="Limpiar", command=self.limpiar)
        self.btn_limpiar.pack(fill=tk.BOTH)
        
        self.lbl_resultado = tk.Label(vbox, text="", pady=10)
        self.lbl_resultado.pack()
    
    def agregar_empleado(self):
        nombre = self.txt_nombre.get()
        salario = self.txt_salario.get()
        edad = self.txt_edad.get()
        
        if nombre == "" or salario == "" or edad == "":
            messagebox.showerror("Error", "Todos los campos son obligatorios")
            return

        if not salario.isdigit() or not edad.isdigit():
            messagebox.showerror("Error", "Salario debe ser un número y Edad debe ser un entero")
            return

        salario = float(salario)
        edad = int(edad)
        
        self.nombres.append(nombre)
        self.salarios.append(salario)
        self.edades.append(edad)
        self.limpiar()
        messagebox.showinfo("Éxito", "Empleado agregado correctamente")
    
    def salario_mayor(self):
        if len(self.nombres) == 0:
            messagebox.showinfo("Información", "No hay empleados registrados")
            return
        
        max_salario = self.salarios[0]
        for salario in self.salarios:
            if salario > max_salario:
                max_salario = salario
        
        resultado = "Empleados con el salario mayor:\n"
        for i in range(len(self.salarios)):
            if self.salarios[i] == max_salario:
                resultado = resultado + "Nombre: " + self.nombres[i] + ", Salario: " + str(self.salarios[i]) + ", Edad: " + str(self.edades[i]) + "\n"
        
        self.lbl_resultado.config(text=resultado)
    
    def salario_menor(self):
        if len(self.nombres) == 0:
            messagebox.showinfo("Información", "No hay empleados registrados")
            return
        
        min_salario = self.salarios[0]
        for salario in self.salarios:
            if salario < min_salario:
                min_salario = salario
        
        resultado = "Empleados con el salario menor:\n"
        for i in range(len(self.salarios)):
            if self.salarios[i] == min_salario:
                resultado = resultado + "Nombre: " + self.nombres[i] + ", Salario: " + str(self.salarios[i]) + ", Edad: " + str(self.edades[i]) + "\n"
        
        self.lbl_resultado.config(text=resultado)
    
    def sumatoria_salarios(self):
        if len(self.nombres) == 0:
            messagebox.showinfo("Información", "No hay empleados registrados")
            return
        
        total = 0
        for salario in self.salarios:
            total = total + salario
        
        self.lbl_resultado.config(text="Sumatoria de salarios: " + str(total))
    
    def promedio_salarios(self):
        if len(self.nombres) == 0:
            messagebox.showinfo("Información", "No hay empleados registrados")
            return
        
        total = 0
        for salario in self.salarios:
            total = total + salario
        
        promedio = total / len(self.salarios)
        self.lbl_resultado.config(text="Promedio de salarios: " + str(promedio))
    
    def limpiar(self):
        self.txt_nombre.delete(0, tk.END)
        self.txt_salario.delete(0, tk.END)
        self.txt_edad.delete(0, tk.END)
        self.lbl_resultado.config(text="")

if __name__ == "__main__":
    app = Formulario()
    app.mainloop()