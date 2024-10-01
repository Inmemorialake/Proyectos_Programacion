numero = int(input("Introduce el numero hasta el cual quieres verificar si es primo: "))
es_primo = ""

for i in range(1, numero+1):
    for j in range(1, i):
        if i % 1 == 0 and i % i == 0 and i % j != 0:
            es_primo += str(i)+" es primo \n"
        else:
            es_primo += str(i)+" no es primo \n"
                
print(es_primo)