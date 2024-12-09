import tkinter as tk

class TeatroApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("UV-Teatro")
        self.geometry("300x250")
        self.configure(padx=10, pady=10)
        
        # Crear widgets
        self.create_widgets()

    def create_widgets(self):
        # Ubicación
        tk.Label(self, text="Ubicación").grid(row=0, column=0, pady=5)
        self.ubicacion_var = tk.StringVar(self)
        self.ubicacion_var.set("Palco")  # valor por defecto
        self.ubicacion_menu = tk.OptionMenu(self, self.ubicacion_var, "Palco", "Platea")
        self.ubicacion_menu.grid(row=0, column=1, pady=5)

        # Tipo de venta
        tk.Label(self, text="Tipo de venta").grid(row=1, column=0, pady=5)
        self.tipo_venta_var = tk.StringVar(self)
        self.tipo_venta_var.set("Pre-venta")  # valor por defecto
        self.tipo_venta_menu = tk.OptionMenu(self, self.tipo_venta_var, "Pre-venta", "Venta normal")
        self.tipo_venta_menu.grid(row=1, column=1, pady=5)

        # Cantidad
        tk.Label(self, text="Cantidad").grid(row=2, column=0, pady=5)
        self.cantidad = tk.Entry(self)
        self.cantidad.grid(row=2, column=1, pady=5)

        # Botón para calcular valores
        tk.Button(self, text="Calcular valores", command=self.calcular_valores).grid(row=3, column=0, columnspan=2, pady=5)

        # Resultados
        tk.Label(self, text="Valor venta").grid(row=4, column=0, pady=5)
        self.valor_venta = tk.Entry(self, state='readonly')
        self.valor_venta.grid(row=4, column=1, pady=5)

        tk.Label(self, text="Valor aporte").grid(row=5, column=0, pady=5)
        self.valor_aporte = tk.Entry(self, state='readonly')
        self.valor_aporte.grid(row=5, column=1, pady=5)

    def calcular_valores(self):
        ubicacion = self.ubicacion_var.get().strip().lower()
        tipo_venta = self.tipo_venta_var.get().strip().lower()
        cantidad = int(self.cantidad.get().strip())  # Suponemos que el usuario siempre ingresa un número válido

        # Determinar el precio del boleto según la ubicación y el tipo de venta
        if ubicacion == 'palco':
            if tipo_venta == 'pre-venta':
                precio_boleto = 22000
            elif tipo_venta == 'venta normal':
                precio_boleto = 29000
        elif ubicacion == 'platea':
            if tipo_venta == 'pre-venta':
                precio_boleto = 30000
            elif tipo_venta == 'venta normal':
                precio_boleto = 38000

        total_venta = precio_boleto * cantidad
        aporte = total_venta * 0.15

        # Mostrar resultados
        self.valor_venta.config(state='normal')
        self.valor_venta.delete(0, tk.END)
        self.valor_venta.insert(0, f"${total_venta:,.2f}")
        self.valor_venta.config(state='readonly')

        self.valor_aporte.config(state='normal')
        self.valor_aporte.delete(0, tk.END)
        self.valor_aporte.insert(0, f"${aporte:,.2f}")
        self.valor_aporte.config(state='readonly')

if __name__ == "__main__":
    app = TeatroApp()
    app.mainloop()
