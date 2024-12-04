#include "robot.h"

Robot::Robot(int order){this->type = 1; this->order = order;}

//Metodo clone necesario de implementar en cada clase hija.
Individuo* Robot::clone() const{
    return new Robot(order);
}

Robot::~Robot(){}