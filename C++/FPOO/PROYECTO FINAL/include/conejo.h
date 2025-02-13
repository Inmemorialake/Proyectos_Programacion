/*
Archivo: conejo.h
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
CLASE: Conejo
INTENCIÓN: Hija de la clase Individuo, creada para poder diferenciar los diferentes tipos de individuos por medio del atributo "type".
RELACIONES:
- es un Individuo.
- no contiene.
- no conoce.
*/

#ifndef CONEJO_H
#define CONEJO_H

#include "utilities.h"
#include "individuo.h"

class Conejo : public Individuo{
    private:
    public:
        //Constructor que inicializa el objeto con un type = 3
        Conejo(int);

        /*Metodo clone usado para poder clonar el objeto. retorna un new Conejo(), y esto nos es util
        para poder añadir un objeto a otro array de individuos independientemente de su clase. Cabe aclarar que
        luego de su uso se borra la memoria del objeto original, por lo que no hay memory leaks.*/
        virtual Individuo* clone() const override;

        //Destructor.
        virtual ~Conejo();
};

#else
    class Conejo;
#endif