#Declaramos las funciones para el perimetro y el area de un rectangulo
def perimetro_rectangulo(base, altura):
    return 2 * (base + altura)

def area_rectangulo(base, altura):
    return base * altura

#Ahora pedimos al usuario que introduzca los valores de la base y la altura del rectangulo
base = float(input("Introduce la base del rectangulo: "))
altura = float(input("Introduce la altura del rectangulo: "))

#Calculamos el perimetro y el area del rectangulo
print("El perimetro del rectangulo es", perimetro_rectangulo(base, altura))
print("El area del rectangulo es", area_rectangulo(base, altura))