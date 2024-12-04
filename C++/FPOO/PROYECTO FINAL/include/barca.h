/*
Archivo: barca.h
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
CLASE: Barca
INTENCIÓN: Hija de la clase lugar, encargada de guardar los objetos que se mueven a la barca y hacer diferentes comprobaciones.
RELACIONES:
- es un Lugar.
- no contiene.
- no conoce.
*/

#ifndef BARCA_H
#define BARCA_H

#include "utilities.h"
#include "lugar.h"

class Barca : public Lugar{
    private:
        char lado = 'L';
    public:
        /*Constructor que la inicializa con un array de punteros tipo Individuo de tamaño 2, ya que solamente
        contiene 2 espacios.*/
        Barca();

        /*Comprueba si la barca se puede mover (hay un robot en ella), si tiene espacio suficiente para ingresar
        otro individuo o si 2 individuos dentro de la barca se pueden comer.*/
        int checks() override;

        /*Cambia el lado donde esta la barca. Si estaba del lado derecho, pasa a estar al lado izquierdo y viceversa.*/
        void CambiarLado();

        /*Retorna el lado actual de la barca.*/
        char giveLado();

        /*Destructor de la barca que llama al destructor de Lugar para eliminar su arreglo dinamico.*/
        virtual ~Barca();
};

#else
    class Barca;
#endif