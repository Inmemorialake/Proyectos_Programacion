def fibonacci(n):
    a, b = 0, 1
    for i in range(1, n + 1):
        print(f"El numero en la posición {i} es: {a}")
        a, b = b, a + b

numero = int(input("Ingrese el número de elementos que desea ver de la serie de Fibonacci: "))

fibonacci(numero)