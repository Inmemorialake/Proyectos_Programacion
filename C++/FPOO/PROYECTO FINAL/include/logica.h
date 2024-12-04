/*
Archivo: logica.h
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
CLASE: Logica
INTENCION: Realiza diferentes tipos de movimientos y comprobaciones que son algo complejas entre los diferentes arreglos.
RELACIONES:
- es un Lugar.
- no contiene.
- no conoce.
*/
#ifndef LOGICA_H
#define LOGICA_H

#include "utilities.h"
#include "lugar.h"
#include "barca.h"
#include "orilla.h"

class Logica{
    private:

    /*Vamos a tener un caso cuando trabajemos con 2 objetos del mismo tipo a la vez y queramos por ejemplo, meter los 2 a la vez y luego
    sacarlos. Ya que con la logica implementada, primero se escaneara un sitio y luego otro siempre de la misma forma, lo cual
    generara un loop en el cual sera imposible sacar el segundo objeto (mismo objeto en la barca y en la orilla, siempre quedara uno
    en la barca). Por ende, se ha creado esta variable priority que sobreescribe ese orden cuando detecta que 2 objetos de la misma clase
    se encuentran en la barca.*/
    bool priority = false;

    /*Mensaje acumulado que hace CheckStatus con las diferentes comprobaciones*/
    string mensaje;

    public:
        //Constructor
        Logica();

        /*Se encarga de hacer los checkeos necesarios sobre cada uno de los objetos, para comprobar si se ha ganado,
        o si hay alguna condicion que nos hace perder el juego.*/
        int CheckStatus(Orilla& orilla1, Orilla& orilla2, Barca& barca);

        //Elimina el objeto segun su orden de la barca o de la orilla (dependiendo de donde esta) y lo copia en el sitio donde no estaba.
        int MoverObjeto(Orilla& orillaActiva, Orilla& orillaInactiva, Barca& barca, int tipoDeIndividuo, int orden);

        //Hecho booleano para poder comprobar si la accion se realizo con exito. Mueve la barca si detecta que hay un robot en ella.
        bool MoverBarca(Barca& barca);

        //Devuelve el mensaje que hayamos obtenido despues de acumular los mensajes respectivos de cada comprobacion de cada lugar.
        string giveMensaje();

        //Destructor
        virtual ~Logica();
};

#else
    class Logica;
#endif