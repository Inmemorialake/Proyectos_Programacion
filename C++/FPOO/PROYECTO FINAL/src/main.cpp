/*
Nos manejamos por medio de:
Jugador - Es el que interactua con el usuario imprimiendo/recibiendo la informacion.
Logica - Es usado por Jugador y se encarga de hacer procesos como mover los objetos o checkear el estado de cada sitio (ver si alguien se puede comer a otro, etc)
Orilla - Clase hija de lugar el cual en su check necesita tambien comprobar si esta llena (ya que si es la orillaDerecha y tiene a todos los elementos en esta, eso significaria que el usuario ganó)
Barca - Clase hija de lugar con la caracteristica de que tiene un tamaño en su arreglo de individuos fixeado ( = 2 ) ademas de que en su check comprueba si esta llena o si hay un robot en ella
Lugar - Clase padre de las orillas y de las barcas. Este funciona para que orilla y para que barca tengan elementos generales de un lugar y tamien puedan usar el check general para comprobar si algun objeto se puede comer a otro
Zorro, Robot, Conejo y Lechuga - Son las clases hijas de Individuo, y nos sirven para distinguir del tipo de individuo por medio de una variable compartida "type". Ademas de ello, tienen una variable "order" que permite distinguir cuando hay 2 elementos de un mismo tipo
Individuo - Clase abstracta (ya que el clone tiene que ser implementado especificamente por cada una de las clases hijas (const = 0)) que nos sirve para inicializar las otras clases de objetos/elementos
utilities - No es una clase, solo es un header que nos incluye las librerias y algun que otro metodo muy importante general del programa.
*/

#include "jugador.h"

int main(){
    Individuo** arrayDeObjetos = new Individuo*[4];
    arrayDeObjetos[0] = new Robot(1);
    arrayDeObjetos[1] = new Zorro(1);
    arrayDeObjetos[2] = new Conejo(1);
    arrayDeObjetos[3] = new Lechuga(1);
    //arrayDeObjetos[4] = new Robot(2); //COMENTADO YA QUE EL MODO DE JUEGO ACTUAL ES DE 4 OBJETOS. SI SE QUIERE USAR EL DE 6, DESCOMENTAR ESTA Y LA SIGUIENTE LINEA Y CAMBIAR EL INICIALIZADOR DE GAME CON "6" AL IGUAL QUE LA CREACION DEL ARRAY DE INDIVIDUOS DE ARRIBA
    //arrayDeObjetos[5] = new Conejo(2);

    Jugador Game = Jugador(4, arrayDeObjetos);

    do{
        Game.setBoard();
        Game.OptionsManager();
        //Game.metodoDePrueba(4); COMENTADO YA QUE NO SE ESTA UTILIZANDO ACTUALMENTE COMO MODIFICACION, SI SE QUIERE USAR ENTONCES COMENTAR LAS ULTIMAS 2 LINEAS Y USAR SOLO ESTA CON ALGUNO DE LOS CASOS VALIDOS
    }
    while(Game.giveStatus() == true);
}

