numpersonas = int(input("Ingrese el numero de personas encuestadas: "))
print("\nLas actividades principales son: ")
print("1. Leer")
print("2. Ver television")
print("3. Hacer deporte")
print("\nLos intervalos de tiempo son: ")
print("1. Menos de 6 horas")
print("2. Entre 6 y 9 horas")
print("3. Mas de 9 horas\n")
tv = 0
leer = 0
deporte = 0
mseis = 0
eseisynueve = 0
mnueve = 0
eseisynueveleer = 0

for i in range(0, numpersonas, 1):
    actividadprincipal = int(input("Ingrese la actividad principal de la persona "+str(i+1)+" (El codigo de la actividad): "))
    numhoras = int(input("Ingrese el numero de horas que dedica a la actividad la persona "+str(i+1)+" (El codigo del intervalo): "))
    if actividadprincipal == 1 and numhoras == 2:
        eseisynueveleer = eseisynueveleer + 1
    else:
        if actividadprincipal == 1:
            leer = leer + 1
        else:
            if actividadprincipal == 2:
                tv = tv + 1
            else:
                if actividadprincipal == 3:
                    deporte = deporte + 1
    if numhoras == 1:
        mseis = mseis + 1
    else:
        if numhoras == 2:
            eseisynueve = eseisynueve + 1
        else:
            if numhoras == 3:
                mnueve = mnueve + 1
                
print("La cantidad de personas que tienen entre 6 y 9 horas libres y su actividad principal es la lectura es: "+str(eseisynueveleer))
print("El porcentaje de tienen por actividad principal ver television es: "+str((tv/numpersonas)*100)+"%")