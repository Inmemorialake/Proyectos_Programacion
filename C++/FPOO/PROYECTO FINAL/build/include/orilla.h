/*
Archivo: orilla.h
Autores:
Manuela Martínez Moncada Manuela.moncada@correounivalle.edu.co
Juan Esteban Arias Saldaña juan.arias.saldana@correounivalle.edu.co
Sebastian Calvo Carvajal sebastian.calvo@correounivalle.edu.co
Andrés Gerardo González Rosero  andres.gerardo.gonzalez@correounivalle.edu.co
Fecha creación: 2/11/2024
Fecha última modificación: 12/11/2024
Versión: 1.0.0
Licencia: GNU-GPL
*/
/**
CLASE: Orilla
INTENCIÓN: Hija de la clase lugar, encargada de guardar los objetos que participan en el juego (en cada orilla respectiva) y hacer diferentes comprobaciones.
RELACIONES:
- es un Lugar.
- no contiene.
- no conoce.
*/
#ifndef ORILLA_H
#define ORILLA_H

#include "utilities.h"
#include "lugar.h"

class Orilla : public Lugar{
    private:
    public:
        /*Crea un nuevo objeto orilla, tomando en cuenta un tamaño que se le de, entonces dependiendo de este
        tamaño inicializa el array dinamico de punteros con nullptr.*/
        Orilla(int size);

        /*Hace diferentes comprobaciones sobre si hay un robot, o si un individuo puede comer al otro, entonces,
        dependiendo de la situacion devuelve un entero y guarda en el atributo heredado "mensaje" una descripcion
        de que situacion es la que ha ocurrido.*/
        int checks() override;

        /*De forma similar al anterior constructor, este overload recibe tambien el arreglo, entonces copia de el
        los valores a su propio arreglo de individuos. Este constructor esta realizado para incializar la orilla
        izquierda.*/
        Orilla(Individuo** Individuos, int size);

        /*Destructor*/
        virtual ~Orilla();
};

#else
    class Orilla;
#endif