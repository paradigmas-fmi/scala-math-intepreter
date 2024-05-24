package procesador

import modelo.expresion.*

def procesar(expresion: Expresion): Float = {
  expresion match
    case Valor(v) => v
    case Suma(e1, e2) => procesar(e1) + procesar(e2)
    case Mult(e1, e2) => procesar(e1) * procesar(e2)
    case Raiz(e) => Math.sqrt(procesar(e)).toFloat
    case Cuadrado(e) => Math.pow(procesar(e), 2).toFloat
}

 
