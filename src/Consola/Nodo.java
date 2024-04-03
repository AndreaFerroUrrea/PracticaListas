/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consola;

/**
 *
 * @author allil
 */
public class Nodo {
    //atributos de la clase
    int coe;// para guardar el coe
    int exp;
    private Nodo liga;//para guardar la referencia al siguiente Nodo

    public Nodo(int coe, int exp)//constructor que recibe como parámetro el coe
    {
        this.coe = coe;
        this.exp = exp;
        liga = null;
    }

    Nodo() {
    }

    // método encargado de devolver el coe
    public int obtenerCoe() {
        return coe;
    }

    // método encargado de devolver el exp
    public int obtenerExp() {
        return exp;
    }

    // método encargado de devolver la liga
    public Nodo obtenerLiga() {
        return liga;
    }

    //método encargado de asignar un nuevo valor a coe
    public void asignarCoe(int coe) {
        this.coe = coe;
    }

    //método encargado de asignar un nuevo valor a exp
    public void asignarExp(int exp) {
        this.exp = exp;
    }     //método encargado de asignar un nuevo valor a la liga

    public void asignarLiga(Nodo x) {
        liga = x;
    }

}