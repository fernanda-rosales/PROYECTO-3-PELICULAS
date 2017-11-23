/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacioncalculadora;

import java.lang.System;
/**
 *
 * @author Clases
 */
public class Calculadora {
    private int operandoInt1;
    private int operandoInt2;
    private short operandoShort1;
    private short operandoShort2;
    private float operandoFloat1;
    private float operandoFloat2;
    private double operandoDouble1;
    private double operandoDouble2;
    private int opción;
    private int resultdoInt;
    private short resultadoShort;
    private float resultadoFloat;
    private double resultadoDouble;
    private byte opcionTipo;

public void menu()
{
   System.out.println("Calculadora");
   System.out.println("1) Suma");
   System.out.println("2) Resta");
   System.out.println("3) Multiplicación");
   System.out.println("4) División");
   System.out.println("5) Salir");
   System.out.println("Elige una opción:");
   //Leer opción
   System.out.println("¿Qué tipo de datos deseas operar?");
   System.out.println("a) Enteros");
   System.out.println("b) Enteros cortos");
   System.out.println("c) floats");
   System.out.println("d) double");
   System.out.println("Elige un tipo de dato:");
   //Leer opcionTipo
}
public void EjecutaOperacion(int opcion, int op1, int op2)
{
    switch(opcion)
    {
    case 1:
      System.out.println("La suma de " + op1 + " + " + op2 + " = " + Suma(op1, op2));
    break;
    case 2:
      System.out.println("La resta de " + op1 + " - " + op2 + " = " + Resta(op1, op2));
   break;
   case 3:
      System.out.println("La multiplicación de " + op1 + " * " + op2 + " = " + Multiplicación(op1, op2));
   break;
   case 4:
      System.out.println("La división de " + op1 + " / " + op2 + " = " + División(op1, op2));
   break;
   case 5:
      System.out.println("Hasta la vista baby!");
   break;
   default:
      System.out.println( "Error: Opción no definida.");

    }
}
public void pideOperandos()
{
    String letrero = "Dame un valor ";
    switch(opcionTipo) 
    {
        case 'a':
             letrero = letrero + " Entero.";
             System.out.println(letrero);
             //Leer operandoInt1
             System.out.println(letrero);
             //Leer operandoInt2
             EjecutaOperacion(opción, operandoInt1, operandoInt2);
        break;
        case 'b':
             letrero = letrero + " Entero corto.";
             System.out.println( letrero);
             //Leer operandoShort1
             System.out.println( letrero);
             //Leer operandoShort2
             EjecutaOperacion(opción, operandoShort1, operandoShort2);
        break;
        case 'c':
             letrero = letrero + " float.";
             System.out.println( letrero);
             //Leer operandoFloat1
             System.out.println( letrero);
             //Leer operandoFloat2
             EjecutaOperacion(opción, operandoFloat1, operandoFloat2);
       break;
        case 'd':
             letrero = letrero + " double.";
             System.out.println( letrero);
             //Leer operandoDouble1
             System.out.println( letrero);
             //Leer operandoDouble2
             EjecutaOperacion(opción, operandoDouble1, operandoDouble2);
        break;
        default:
             System.out.println( "Error: Operación para tipo no definida");
    }
}

}

