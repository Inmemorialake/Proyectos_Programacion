/*
Archivo: jugador.h
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
CLASE: Jugador
INTENCIÓN: Encargada de la interacción con el usuario y el input/output del programa. Dependiendo de las interacciones,
llama a logica para comprobar y mover diferentes situaciones/objetos. Tambien es encargada de detectar cuando se ha ganado o perdido,
y si es el caso repetir la partida. Dentro de ella estan los diferentes objetos del juego y es considerada la clase principal.
RELACIONES:
- Es un jugador.
- Contiene a Orilla, Barca e Individuos.
- no conoce.
*/
#ifndef JUGADOR_H
#define JUGADOR_H

#include "utilities.h"
#include "logica.h"

class Jugador{
    private:
        Orilla* orillaIzquierda;
        Orilla* orillaDerecha;
        Barca* barca;

        /*Cuando el juego se reinicie en playAgain, necesitamos una manera rapida de volver a poner todos los objetos
        originales en la orillaIzquierda, por ende, vamos a tener un arreglo dinamico que nos apunte en el orden
        correcto a cada uno de los objetos del lugar en cuestion.
        las direcciones originales en el mismo orden en todo mome*/
        Individuo** arrayDeObjetosOriginal;

        bool gameLoop = true;
        int numeroFilas;
        string** tablero;
    public:
        /*Obtiene 2 parametros, una que es el tamaño del array de objetos de las orillas y otra que es el
        array de objetos que guardaremos en arrayDeObjetosOriginal y que usaremos para construir la orillaIzquierda.
        Cabe aclarar que cuando construyamos la orilla izquierda, automaticamente este array de objetos sera seteado
        a nullptr para evitar problemas con la memoria.*/
        Jugador(int cantidadIndividuosOrilla, Individuo** arrayDeObjetos);
        
        /*Reinicia nuestro arreglo string tablero (que es la tabla visual que vemos de cada objeto y sus individuos),
        escaneando cada objeto y sus elementos para añadirlos en el tablero.*/
        void setBoard();

        /*Imprime nuestro tablero*/
        void printScene();

        /*Nos muestra el menu de opciones despues de usar printScene() para mostrarnos el tablero. Luego, dependiendo
        de cada opcion hace comprobaciones y llama a logica para realizar la accion dada por el usuario. Al final de 
        cada turno, comprueba si se ha ganado o si hay una condicion que nos hace perder, si este es el caso, entonces
        llama a playAgain() para preguntarnos si queremos continuar o cerrar el programa.*/
        void OptionsManager();

        /*Nos pregunta si queremos seguir jugando o si cerramos el programa. Si lo cerramos, setea gameLoop en false saliendo
        por ende del bucle en main que nos permite seguir jugando. Si queremos seguir jugando, entonces borra todos los objetos,
        inicializa orillas y barca, y copia los objetos de arrayDeObjetosOriginal en la orillaIzquierda para devolver el juego a su
        estado inicial.*/
        void playAgain();

        /*Retorna el estado de el atributo "gameLoop"*/
        bool giveStatus();

        /*Nuestro metodo de prueba que dependiendo de con que parametro se llame va a ejecutar 4 diferentes casos*/
        void metodoDePrueba(int);

        /*Nuestro optionsManager que va a ejecutarse para las pruebas*/
        void optionsTest(string);

        /*Destructor que borra el tablero index por index y luego con delete[], para despues borrar cada uno de los objetos, los
        cuales borraran su arreglo de individuos respectivamente. Por ultimo, limpia la memoria de arrayDeObjetosOriginal de la misma forma*/
        virtual ~Jugador();
};

#else
    class Jugador;
#endif