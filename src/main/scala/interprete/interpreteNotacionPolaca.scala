package interprete

import modelo.Operador
import modelo.Operador.{CUADRADO, MULT, RAIZ, SUMA}
import modelo.expresion.{Cuadrado, Expresion, Mult, Raiz, Suma, Valor}

import scala.annotation.tailrec
import scala.collection.mutable.Stack

def interpretarEcuacion(ecuacion: List[Operador | Float]): Expresion = {
  _interpretarEcuacion(ecuacion, Stack())
}

@tailrec
private def _interpretarEcuacion(ecuacion: List[Operador | Float], paramsActuales: Stack[Expresion]): Expresion = {
  ecuacion match
    case Nil => 
      if (paramsActuales.length > 1) throw Exception("Ecuacion invalida")
      else paramsActuales.head
    case x::xs =>
      x match
        case f: Float =>
          paramsActuales.push(Valor(f))
          _interpretarEcuacion(xs, paramsActuales)
        case op: Operador => 
          op match
            case SUMA => 
              val e1: Expresion = paramsActuales.pop()
              val e2: Expresion = paramsActuales.pop()
              paramsActuales.push(Suma(e1, e2))
            case MULT =>
              val e1: Expresion = paramsActuales.pop()
              val e2: Expresion = paramsActuales.pop()
              paramsActuales.push(Mult(e1, e2))
            case RAIZ =>
              val e: Expresion = paramsActuales.pop()
              paramsActuales.push(Raiz(e))
            case CUADRADO =>
              val e: Expresion = paramsActuales.pop()
              paramsActuales.push(Cuadrado(e))
          _interpretarEcuacion(xs, paramsActuales)
}
