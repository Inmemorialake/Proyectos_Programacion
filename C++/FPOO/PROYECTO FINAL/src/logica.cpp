#include "logica.h"

Logica::Logica(){}

//Nos dice el estado del juego acumulando y comprobando los estados de los 3 lugares, de forma practica, nos permite saber si hemos perdido, ganado, o si no ha pasado nada.
int Logica::CheckStatus(Orilla& orilla1, Orilla& orilla2, Barca& barca){
    int comprobacionOrillaIzq = orilla1.checks(); //Guardamos el valor que nos devuelvan las comprobaciones de cada lugar
    int comprobacionOrillaDer = orilla2.checks();
    int comprobacionBarca = barca.checks();
    mensaje = ""; //Mensaje va a estar vacio, y se le ira acumulando los mensajes de cada lugar despues de los checks.

    //Si la orilla izquierda no esta bien (1) y si la orilla izquierda no esta completa (4)
    if(comprobacionOrillaIzq != 1 && comprobacionOrillaIzq != 4){
        mensaje += orilla1.giveMensaje();
    }

    //Si la orilla derecha no esta bien (1) y si la orilla derecha no esta llena (4, es decir, que el jugador ha ganado)
    if(comprobacionOrillaDer != 1 && comprobacionOrillaDer != 4){
        mensaje += orilla2.giveMensaje();
    }

    //Si la barca no esta bien (1) y si la barca no esta sin un robot (5) o si la barca no esta llena (6)
    if(comprobacionBarca != 1 && comprobacionBarca != 5 && comprobacionBarca != 6){
        mensaje += barca.giveMensaje();
    }

    //Si cualqquiera de los casos anteriores se ha cumplido, imprimos al final del mensaje "Perdiste..."
    if((comprobacionOrillaIzq != 1 && comprobacionOrillaIzq != 4) || (comprobacionOrillaDer != 1 && comprobacionOrillaDer != 4) || (comprobacionBarca != 1 && comprobacionBarca != 5 && comprobacionBarca != 6)){
        mensaje += "Perdiste...";
    }

    //Como dijimos, si la orilla derecha esta llena (retorna "4" en su check) es porque hemos ganado.
    if(comprobacionOrillaDer == 4){
        mensaje = "Ganaste!";
        return 2; //Si hemos ganado, retornamos 2.
    }
    if(mensaje.length() > 1) return 0; //Si el mensaje nos ha dado algo que tengamos que imprimir, retornamos 0
    else {return 1;} //Sino (el mensaje ha quedado vacio por ende no ha ocurrido nada que se tenga que informar, retornamos 1)
}

int Logica::MoverObjeto(Orilla& orillaActiva, Orilla& orillaInactiva, Barca& barca, int tipoDeIndividuo, int orden){
    //Hacemos la comprobacion y el procedimiento por si el elemento esta en la orilla activa.
    for(int i = 0; i < orillaActiva.giveSize(); i++){
        if(orillaActiva.getIndividuos()[i] != nullptr && orillaActiva.getIndividuos()[i]->giveType() == tipoDeIndividuo && orillaActiva.getIndividuos()[i]->getOrder() == orden){
            if(barca.addIndividuo(orillaActiva.getIndividuos()[i])){
                orillaActiva.removeIndividuo(i);
                return 1; //Si se ha movido exitosamente, retornamos uno.
            }
            else{
                return 3; //No se ha podido mover el objeto porque al intentar moverlo en la barca ha ocurrido un error
            }
        }
    }

    //Si no estaba en la orilla activa, ahora comprobamos que esté en la barca
    for(int i = 0; i < barca.giveSize(); i++){
        if(barca.getIndividuos()[i] != nullptr && barca.getIndividuos()[i]->giveType() == tipoDeIndividuo && barca.getIndividuos()[i]->getOrder() == orden){         
            if(orillaActiva.addIndividuo(barca.getIndividuos()[i])){
                barca.removeIndividuo(i);
                if(priority == true) priority = false;
                return 1; //Si se ha movido exitosamente, retornamos 1
            }     
            else{
                return 4; //Si no se ha podido mover a la orilla, retornamos 4
            }
        }
    }

    //Si no esta en ninguno de los anteriores, buscamos ahora en la orilla inactiva (Esto significaria que el objeto intenta saltar en una orilla donde no esta la barca)
    for(int i = 0; i < orillaInactiva.giveSize(); i++){
        if(orillaInactiva.getIndividuos()[i] != nullptr && orillaInactiva.getIndividuos()[i]->giveType() == tipoDeIndividuo && orillaInactiva.getIndividuos()[i]->getOrder() == orden){
            return 2; //Retornamos 2 si el objeto esta intentando saltar desde una orilla donde no esta la barca.
        }
    }

    //Si no se pudo mover el objeto y ademas no estaba en la orilla equivocada, devolvemos un 0.
    return 0;
}

bool Logica::MoverBarca(Barca& barca){
    if(barca.checks() == 1){barca.CambiarLado(); return true;}
    else {return false;}
}

string Logica::giveMensaje(){
    return mensaje;
}

Logica::~Logica(){}