package lector

import modelo.Operador

import scala.annotation.tailrec

def leerEcuacion(ecuacion: String): List[Operador | Float] = {
  val ops = ecuacion.split(" ").toList
  _leerEcuacionRec(ops)
}

private def _leerEcuacionRec(tokens: List[String]): List[Operador | Float] = {
  tokens match {
    case Nil => List()
    case x::xs =>
      val op = x match {
        case "+" => Operador.SUMA
        case "*" => Operador.MULT
        case "^2" => Operador.CUADRADO
        case "sqrt" => Operador.RAIZ
        case _ => x.toFloat
      }
      op::_leerEcuacionRec(xs)
  }
}
