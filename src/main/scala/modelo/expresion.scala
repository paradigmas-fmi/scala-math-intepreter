package modelo.expresion

sealed trait Expresion

case class Valor(v: Float) extends Expresion
case class Suma(e1: Expresion, e2: Expresion) extends Expresion
case class Mult(e1: Expresion, e2: Expresion) extends Expresion
case class Raiz(e: Expresion) extends Expresion
case class Cuadrado(e: Expresion) extends Expresion
