#include "jugador.h"

Jugador::Jugador(int cantidadIndividuosOrilla, Individuo** arrayDeObjetos){
    this->numeroFilas = cantidadIndividuosOrilla+1; //El tablero tiene una fila mas para los titulos
    tablero = new string*[numeroFilas]; //Creamos las filas del tablero

    for(int i = 0; i < numeroFilas; i++){ //Inicializamos las columnas
        tablero[i] = new string[4]; //Siempre van a haber 4 columnas

        for(int j = 0; j < 4; j++){
            tablero[i][j] = ""; //Hacemos que cada columna tenga un string vacio ""
        }
    }

    tablero[0][0] = "IZQUIERDA"; //Ponemos los titulos que el juego mostrara
    tablero[0][1] = "BARCA";
    tablero[0][2] = "";
    tablero[0][3] = "DERECHA";

    //Clonamos el arrayDeObjetos en el original (Necesario por si el jugador quiere reiniciar el juego)
    arrayDeObjetosOriginal = new Individuo*[cantidadIndividuosOrilla];

    for(int i  = 0; i < cantidadIndividuosOrilla; i++){
        arrayDeObjetosOriginal[i] = arrayDeObjetos[i]->clone();
    }

    //Generamos nuestros objetos
    orillaIzquierda = new Orilla(arrayDeObjetos, cantidadIndividuosOrilla); //El arrayDeObjetos quedara en nullptr al ser pasado al constructor de orilla
    orillaDerecha = new Orilla(cantidadIndividuosOrilla);
    barca = new Barca();  
}


void Jugador::setBoard(){
    int index_barca;
    char posicionDeBarca = barca->giveLado();

    //Reiniciamos todo el tablero en strings vacios
    for(int i = 0; i < numeroFilas-1; i++){
        for(int j = 0; j < 4; j++){
            tablero[i+1][j] = "";
        }
    }

    //Dicernimos la posicion de la barca para ser capaces de imprimir el listado de objetos en la posicion correcta del tablero
    if(posicionDeBarca == 'L'){
        tablero[0][1] = "BARCA";
        tablero[0][2] = "";
        index_barca = 1;
    }

    else {
        tablero[0][1] = "";
        tablero[0][2] = "BARCA";
        index_barca = 2;
    }

    //Obtenemos el lado en el que esta actualmente la barca para saber en que columna dibujar el array
    if(posicionDeBarca != 'L') index_barca = 2;
    
    //Obtenemos la informacion de la primera orilla y lo guardamos en su respectiva columna del tablero
    for(int i = 0; i < numeroFilas-1; i++){
        if(orillaIzquierda->getIndividuos()[i] != nullptr){
            if(orillaIzquierda->getIndividuos()[i]->giveType() == 1){
                tablero[i+1][0] = "ROBOT";
            }
            if(orillaIzquierda->getIndividuos()[i]->giveType() == 2){
                tablero[i+1][0] = "ZORRO";
            }
            if(orillaIzquierda->getIndividuos()[i]->giveType() == 3){
                tablero[i+1][0] = "CONEJO";
            }
            if(orillaIzquierda->getIndividuos()[i]->giveType() == 4){
                tablero[i+1][0] = "LECHUGA";
            }
        }
    }

    //Obtenemos la informacion de la orilla derecha y la guardamos en el tablero
    for(int i = 0; i < numeroFilas-1; i++){
        if(orillaDerecha->getIndividuos()[i] != nullptr){
            if(orillaDerecha->getIndividuos()[i]->giveType() == 1){
                tablero[i+1][3] = "ROBOT";
            }
            if(orillaDerecha->getIndividuos()[i]->giveType() == 2){
                tablero[i+1][3] = "ZORRO";
            }
            if(orillaDerecha->getIndividuos()[i]->giveType() == 3){
                tablero[i+1][3] = "CONEJO";
            }
            if(orillaDerecha->getIndividuos()[i]->giveType() == 4){
                tablero[i+1][3] = "LECHUGA";
            }
        }
    }

    //Obtenemos la informacion de la barca y la guardamos en su posicion respectiva del tablero dependiendo de la posicion
    for(int i = 0; i < 2; i++){
        if(barca->getIndividuos()[i] != nullptr){
            if(barca->getIndividuos()[i]->giveType() == 1){
                tablero[i+1][index_barca] = "ROBOT";
            }
            if(barca->getIndividuos()[i]->giveType() == 2){
                tablero[i+1][index_barca] = "ZORRO";
            }
            if(barca->getIndividuos()[i]->giveType() == 3){
                tablero[i+1][index_barca] = "CONEJO";
            }
            if(barca->getIndividuos()[i]->giveType() == 4){
                tablero[i+1][index_barca] = "LECHUGA";
            }
        }
    }
}

/*Imprime el tablero previamente creado*/
void Jugador::printScene(){
    cls();
    string aImprimir = "";

    for(int i = 0; i < numeroFilas; i++){
        for(int j = 0; j < 4; j++){
            aImprimir += "| " + tablero[i][j];
            while(aImprimir.length() < 14){ aImprimir+=" "; }
            if(j == 3) aImprimir += "|";
            cout<<aImprimir;
            aImprimir = "";
        }
        cout<<"\n";
    }

    cout<<"\n";
}

/*Nos da el mensaje al final de la partida (independientemente de si hayamos ganado o perdido)
Si elegimos algo diferente de 1 o 2, sigue preguntadonos.
Si damos 1 el juego borra todos los lugares excepto orillaIzquierda para reorganizarla con la misma distribucion
que tiene orillaOriginal.
Si damos 2 el juego borra todo.*/
void Jugador::playAgain(){
    string aux = "0";
    int cantidadObjetosOrillas;

    cls();
    cout<<"Quieres jugar de nuevo?\n1) Si\n2) No\n: ";
    while(aux != "1" && aux != "2"){
        getline(cin, aux);
        if(aux != "1" && aux != "2"){
            cout<<"\nHas dado una opcion invalida. ";
        }
        else{ break; }
    }

    if(aux == "1"){
        //Borramos todos los lugares (por ende sus objetos) excepto orillaIzquierda
        delete orillaDerecha;
        delete barca;

        //Miramos nuestro numero de filas para volver a crear los arreglos de las orillas
        cantidadObjetosOrillas = numeroFilas-1;

        //Hacemos que el arreglo de orillaIzquierda sea igual al arreglo original base de objetos del inicio
        for(int i = 0; i < cantidadObjetosOrillas; i++){
            if(orillaIzquierda->getIndividuos()[i] != nullptr) delete orillaIzquierda->getIndividuos()[i];
            orillaIzquierda->getIndividuos()[i] = arrayDeObjetosOriginal[i]->clone();
        }

        //Volvemos a crear los otros objetos
        barca = new Barca();
        orillaDerecha = new Orilla(cantidadObjetosOrillas);
    }

    else{
        gameLoop = false;
    }
}

void Jugador::OptionsManager(){
    Logica Logic = Logica();
    int TipoABuscar;
    int orden; //Nos permitira obtener el orden que buscamos segun la opcion cuando trabajamos con mas de un objeto del mismo tipo

    /*Variable que guardara el numero que nos devuelva el en intento de mover un objeto. Este numero especificara
    el tipo de caso que ha pasado cuando se ha intentado hacer el movimiento (Si ha sido exitoso, si ha tenido
    problemas ya que la barca estaba llena, etc.) por medio de numeros que retorna.*/
    int comprobacionesMovimiento;

    string aux;

    while(aux != "B" && aux != "R" && aux != "Z" && aux != "C" && aux != "L" && aux != "C2" && aux != "R2"){
        cls();
        printScene();

        cout<<"Que accion deseas realizar?"
            <<"\n\"B\" Mover barca para la otra orilla."
            <<"\n\"R\" Poner/Sacar Robot de la barca.";

        if(numeroFilas-1 == 6){ //Si estamos con la segunda modalidad, tambien mostramos la opcion R2
            cout<<"\n\"R2\" Poner/Sacar Robot 2 de la barca.";
        }

        cout<<"\n\"Z\" Poner/Sacar Zorro de la barca."
            <<"\n\"C\" Poner/Sacar Conejo de la barca.";

        if(numeroFilas-1 == 6){ //Si estamos con la segunda modalidad, tambien mostramos la opcion C2
            cout<<"\n\"C2\" Poner/Sacar Robot 2 de la barca.";
            
        }

        cout<<"\n\"L\" Poner/Sacar Lechuga de la barca."
            <<"\n: ";

        getline(cin, aux);
        if(aux != "B" && aux != "R" && aux != "Z" && aux != "C" && aux != "L" && aux != "C2" && aux != "R2"){
            cout<<"\nHas dado una opcion incorrecta.\n: ";
            wait4Enter();
        }
    }

    /*Aqui puede ocurrir un problema, ya que si estamos jugando con solamente 4 objetos (Primera modalidad) 
    pero el jugador decide elegir C2 o R2 como opcion, de todas maneras podra ser tomada. Si el jugador escribe
    C2 o R2 estando en la primera modalidad, haremos que aux sea igual a "R" o "C" respectivamente*/
    if(numeroFilas-1 != 6 && (aux == "C2" || aux == "R2")){
        aux = aux[0]; //Quitamos el ultimo caracter de aux :D
    }

    //Movemos la barca
    if(aux == "B"){
        if(Logic.MoverBarca(*barca)) return; //Si al mover la barca esta no nos devuelve un false (ha habido un error), entonces salmos del metodo
        else{ //Si al mover la barca hemos obtenido un error (nos ha devuelto false/0)
            cls();
            printScene();
            cout<<"No se ha podido mover la barca debido a: "<<barca->giveMensaje();
            sleepFor(2000);
        }
    }

    else if(aux == "R" || aux == "Z" || aux == "C" || aux == "L" || aux == "R2" || aux == "C2"){
        //Dependiendo de la opcion que el usuario haya ingresado, reconocemos el tipo que queremos buscar usando TipoABuscar.
        if(aux == "R" || aux == "R2"){
            TipoABuscar = 1;
        }
        else if(aux == "Z"){
            TipoABuscar = 2;
        }
        else if(aux == "C" || aux == "C2"){
            TipoABuscar = 3;
        }
        else if(aux == "L"){
            TipoABuscar = 4;
        }

        //Si nuestro aux es R2 o C2, el tipo que buscamos va a ser de segundo orden
        if(aux == "R2" || aux == "C2"){
            orden = 2;
        }
        //Sino, sera de primero
        else{
            orden = 1;
        }

        //Dependiendo del lado de la barca invertimos la orilla activa e inactiva para mover el objeto
        if(barca->giveLado() == 'L'){
            comprobacionesMovimiento = Logic.MoverObjeto(*orillaIzquierda, *orillaDerecha, *barca, TipoABuscar, orden);
        }

        else{
            comprobacionesMovimiento = Logic.MoverObjeto(*orillaDerecha, *orillaIzquierda, *barca, TipoABuscar, orden);
        }

        if(comprobacionesMovimiento == 3){
            cls();
            printScene();
            cout<<"No se ha podido mover el objeto a la barca debido a que no hay espacio en esta.";
            wait4Enter();
        }

        else if(comprobacionesMovimiento == 4){
            cls();
            printScene();
            cout<<"No se ha podido mover el objeto a la orilla debido a que no hay espacio en esta.";
            wait4Enter();
        }

        else if(comprobacionesMovimiento == 2){ //Si el objeto se cae de la barca, es game over.
            cls();
            printScene();
            cout<<"El objeto se ha caido porque la barca no estaba en su orilla! Perdiste...";
            wait4Enter();
            playAgain();
        }
        
    }

    /*Parte del codigo que se encarga de checkear si se ha perdido o se ha ganado. Si no es ninguno de los 2
    (CheckStatus devueve 1) entonces no hacemos nada, pero si obtuvimos algo diferente de uno ponemos el mensaje
    que nos haya dado CheckStatus y ejecutamos playAgain (ya que si CheckStatus da diferente de 1, significa que hemos
    perdido.)*/
    if(Logic.CheckStatus(*orillaIzquierda, *orillaDerecha, *barca) != 1){
        cls();
        setBoard();
        printScene();
        cout<<Logic.giveMensaje();
        wait4Enter();
        playAgain();
    }
}

bool Jugador::giveStatus(){
    return gameLoop;
}

/*Modificacion de nuestro optionsManager que nos permite realizar todos los procesos sin que 
el usuario tenga que intervenir en ningun momento (Obviamos el input haciendolo un parametro
y todos los wait4Enter() los reemplazamos con sleeps). Este metodo es usado por el metodoDePrueba para poder
realizar las pruebas sin necesidad de que el usuairo ingrese nada :D*/
void Jugador::optionsTest(string aux){
    Logica Logic = Logica();
    int TipoABuscar;
    int orden; //Nos permitira obtener el orden que buscamos segun la opcion cuando trabajamos con mas de un objeto del mismo tipo

    /*Variable que guardara el numero que nos devuelva el en intento de mover un objeto. Este numero especificara
    el tipo de caso que ha pasado cuando se ha intentado hacer el movimiento (Si ha sido exitoso, si ha tenido
    problemas ya que la barca estaba llena, etc.) por medio de numeros que retorna.*/
    int comprobacionesMovimiento;

    cls();
    setBoard();
    printScene();

    cout<<"\nMovimiento a realizar: " + aux << std::flush;

    sleepFor(1000);

    if(aux == "B"){
        if(Logic.MoverBarca(*barca)) return;
        else{
            cls();
            printScene();
            cout<<"No se ha podido mover la barca debido a: "<<barca->giveMensaje()<<std::flush;
            sleepFor(2000);
        }
    }

    else if(aux == "R" || aux == "Z" || aux == "C" || aux == "L" || aux == "R2" || aux == "C2"){
        if(aux == "R" || aux == "R2"){
            TipoABuscar = 1;
        }
        else if(aux == "Z"){
            TipoABuscar = 2;
        }
        else if(aux == "C" || aux == "C2"){
            TipoABuscar = 3;
        }
        else if(aux == "L"){
            TipoABuscar = 4;
        }

        //Si nuestro aux es R2 o C2, el tipo que buscamos va a ser de segundo orden
        if(aux == "R2" || aux == "C2"){
            orden = 2;
        }
        //Sino, sera de primero
        else{
            orden = 1;
        }

        //Dependiendo del lado de la barca invertimos la orilla activa e inactiva para mover el objeto
        if(barca->giveLado() == 'L'){
            comprobacionesMovimiento = Logic.MoverObjeto(*orillaIzquierda, *orillaDerecha, *barca, TipoABuscar, orden);
        }

        else{
            comprobacionesMovimiento = Logic.MoverObjeto(*orillaDerecha, *orillaIzquierda, *barca, TipoABuscar, orden);
        }

        if(comprobacionesMovimiento == 3){
            cls();
            printScene();
            cout<<"No se ha podido mover el objeto a la barca debido a que no hay espacio en esta."<<std::flush;
            sleepFor(2000);
        }

        else if(comprobacionesMovimiento == 4){
            cls();
            printScene();
            cout<<"No se ha podido mover el objeto a la orilla debido a que no hay espacio en esta."<<std::flush;
            sleepFor(2000);
        }

        else if(comprobacionesMovimiento == 2){ //Si el objeto se cae de la barca, es game over.
            cls();
            printScene();
            cout<<"El objeto se ha caido porque la barca no estaba en su orilla! Perdiste..."<<std::flush;
            sleepFor(2000);
            cls();
            cout<<"FIN DEL TEST AUTOMATIZADO\n"<<std::flush;
            sleepFor(2000);
            playAgain();
        }
        
    }

    if(Logic.CheckStatus(*orillaIzquierda, *orillaDerecha, *barca) != 1){
        cls();
        setBoard();
        printScene();
        cout<<Logic.giveMensaje();
        wait4Enter();
        cls();
        cout<<"FIN DEL TEST AUTOMATIZADO\n"; //Aqui no necesitamos el flush ya que se cumple la condicion de que haya un \n para que el buffer se imprima
        sleepFor(2000);
        playAgain();
    }
}

/*Aqui usamos nuestro optionsTest para realizar los 4 diferentes casos. En el caso 1 y 2 se gana el juego, en el caso
3 y 4 se pierde.*/
void Jugador::metodoDePrueba(int caso){
    if(caso == 1){
        optionsTest("C");
        optionsTest("B");
        optionsTest("R");
        optionsTest("B");
        optionsTest("C");
        optionsTest("B");
        optionsTest("Z");
        optionsTest("B");
        optionsTest("R");
        optionsTest("Z");
        optionsTest("C");
        optionsTest("R");
        optionsTest("B");
        optionsTest("R");
        optionsTest("C");
        optionsTest("L");
        optionsTest("R");
        optionsTest("B");
        optionsTest("L");
        optionsTest("B");
        optionsTest("C");
        optionsTest("B");
        optionsTest("R");
        optionsTest("C");
    }

    if(caso == 2){
        optionsTest("C");
        optionsTest("R");
        optionsTest("B");
        optionsTest("C");
        optionsTest("B");
        optionsTest("L");
        optionsTest("B");
        optionsTest("R");
        optionsTest("L");
        optionsTest("C");
        optionsTest("R");
        optionsTest("B");
        optionsTest("R");
        optionsTest("C");
        optionsTest("Z");
        optionsTest("R");
        optionsTest("B");
        optionsTest("Z");
        optionsTest("B");
        optionsTest("C");
        optionsTest("B");
        optionsTest("R");
        optionsTest("C");
    }

    if(caso == 3){
        optionsTest("R");
    }

    if(caso == 4){
        optionsTest("C");
        optionsTest("R");
        optionsTest("B");
        optionsTest("C");
        optionsTest("B");
        optionsTest("C");
    }
}

/*Borramos el array dinamico del tablero*/
Jugador::~Jugador(){
    for(int i = 0; i < numeroFilas; i++){
        delete[] tablero[i]; //Primero las columnas
    }

    delete[] tablero; //Despues el tablero como tal

    delete orillaIzquierda; //Cada una de las orillas que a su vez llamaran al destructor de lugar que destruira sus arrays respectivos
    delete orillaDerecha;
    delete barca;

    for(int i = 0; i < numeroFilas-1; i++){ //Y por ultimo, nuestro array original de objetos.
        delete arrayDeObjetosOriginal[i];
    }

    delete[] arrayDeObjetosOriginal;
}