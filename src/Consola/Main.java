/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consola;

import java.util.Scanner;

/**
 * 
 *
 * 
 * @author allil
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("Ingrese los términos del primer polinomio:");
        PolF3 polinomio1 = new PolF3("Polinomio 1"); 
        polinomio1.crearPolinomio();

        System.out.println("Ingrese los términos del segundo polinomio:");
        PolF3 polinomio2 = new PolF3("Polinomio 2");
        polinomio2.crearPolinomio();

        PolF3 resultadoSuma = polinomio1.sumar(polinomio1, polinomio2);

        System.out.println("El polinomio resultante de la suma es:");
        System.out.println(resultadoSuma.mostrarPolinomio());
        

        

       
        
        




       

        

        //Mostrar Polinomio
       // System.out.println(pol4.mostrarPolinomio());


    }
}
