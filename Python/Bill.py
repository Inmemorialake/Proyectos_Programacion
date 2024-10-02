
abecedario_ingles_1="abcdefghijklm" 
abecedario_ingles_2="nopqrstuvwxyz"
frase=input("Introduce una frase: ")
frase=frase.lower()
frase_descifrada=""

for i in range (0, len(frase)):
    abecedario_ingles_1.find(frase[i])
    if abecedario_ingles_1.find(frase[i])!=-1:
        frase_descifrada+=abecedario_ingles_2[abecedario_ingles_1.find(frase[i])]
    elif abecedario_ingles_2.find(frase[i])!=-1:
        frase_descifrada+=abecedario_ingles_1[abecedario_ingles_2.find(frase[i])]
    else:
        frase_descifrada+=frase[i]
print(frase_descifrada)