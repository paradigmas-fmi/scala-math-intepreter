package miEjemplo

import interprete.interpretarEcuacion
import lector.leerEcuacion
import procesador.procesar

import java.util.Scanner
import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]) = {
    var input: String = readLine
    
    while (input != null) {
      val ecuacionParseada = leerEcuacion(input)
      val expresion = interpretarEcuacion(ecuacionParseada)
      val resultado = procesar(expresion)
      printf("Resultado = %f \n", resultado)
      
      input = readLine
    }
  }
}