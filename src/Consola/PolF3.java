/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consola;

/**
 *
 * @author allil
 */
import java.util.Scanner;

public class PolF3 {

    //atributos de la clase
    private String nombre;
    private Nodo punta;// atributo que indica donde inicia la lista

    //constructor sin parámetro, encargado de iniciar la lista vacia
    public PolF3(String nombre) {
        this.nombre = nombre;
        punta = null;
    }

    public Nodo obtenerPunta(){
        return punta;
    }

    public void insertarTermino(int coe, int exp) {
        Nodo q, p, ant;

        if (punta == null) {
            q = new Nodo(coe, exp);
            punta = q;
        } else {
            p = punta;
            ant = null;
            while (p != null && p.obtenerExp() > exp) {
                ant = p;
                p = p.obtenerLiga();
            }
            if (p != null && p.obtenerExp() == exp) {
                p.asignarCoe(p.obtenerCoe() + coe);
                if (p.obtenerCoe() == 0) {
                    if (p == punta) {
                        punta = p.obtenerLiga();
                    } else {
                        ant.asignarLiga(p.obtenerLiga());

                    }
                    p = null;
                }

            } else {
                q = new Nodo(coe, exp);
                if (p == punta) {
                    q.asignarLiga(punta);
                    punta = q;
                } else {
                    ant.asignarLiga(q);
                    q.asignarLiga(p);
                }
            }
        }
    }

    public String mostrarPolinomio(){
        boolean band = true;
        Nodo Q = punta;
        String polinomio = "";
        while (Q != null){

            if(Q.obtenerCoe() >= 0){
                if(band){
                    polinomio = polinomio +  Q.obtenerCoe() + "Y^" + Q.obtenerExp() ;
                    band = false;
                }else{
                    polinomio = polinomio + " + "+ Q.obtenerCoe() + "Y^" + Q.obtenerExp() ;
                }

            }else {
                polinomio = polinomio + " - " + (Q.obtenerCoe()*(-1)) + "Y^" + Q.obtenerExp();
            }
            Q = Q.obtenerLiga();
        }

        return polinomio;
    }

    public void crearPolinomio(){

        Scanner sc = new Scanner(System.in);
        Nodo P = null;
        Nodo ULTIMO = null;
        Nodo X;
        int terminos = 0;
        int coef = 0;
        int exp = 0;


        System.out.println("Digite la cantidad de términos");
        terminos = sc.nextInt();

        for (int i = 0; i < terminos ; i++) {
            System.out.println("Digite coeficiente");
            coef = sc.nextInt();
            System.out.println("Digite exponente");
            exp = sc.nextInt();
            X = new Nodo(coef, exp);
            if (punta == null){
                punta = X;
            }else{
                ULTIMO.asignarLiga(X);
            }
            ULTIMO = X;
        }
    }

    public PolF3 sumar(PolF3 pol1, PolF3 pol2) {
    Nodo P = pol1.obtenerPunta();
    Nodo Q = pol2.obtenerPunta();
    PolF3 resultado = new PolF3("Resultado");

    while (P != null || Q != null) {
        if (P != null && Q != null) {
            if (P.obtenerExp() == Q.obtenerExp()) {
                resultado.insertarTermino(P.obtenerCoe() + Q.obtenerCoe(), P.obtenerExp());
                P = P.obtenerLiga();
                Q = Q.obtenerLiga();
            } else if (P.obtenerExp() > Q.obtenerExp()) {
                resultado.insertarTermino(P.obtenerCoe(), P.obtenerExp());
                P = P.obtenerLiga();
            } else {
                resultado.insertarTermino(Q.obtenerCoe(), Q.obtenerExp());
                Q = Q.obtenerLiga();
            }
        } else if (P != null) {
            resultado.insertarTermino(P.obtenerCoe(), P.obtenerExp());
            P = P.obtenerLiga();
        } else {
            resultado.insertarTermino(Q.obtenerCoe(), Q.obtenerExp());
            Q = Q.obtenerLiga();
        }
    }

    return resultado;
}
        
        
    

    public PolF3 multiplicar(PolF3 B){
        int expA = 0;
        int expB = 0;
        int coeA = 0;
        int coeB = 0;
        PolF3 C = new PolF3("C");
        Nodo Q = null;
        Nodo R = punta;
        while ( R != null){
            Q = B.obtenerPunta();
            while ( Q != null){
                expA = R.obtenerExp();
                expB = Q.obtenerExp();
                coeA = R.obtenerCoe();
                coeB = Q.obtenerCoe();
                C.insertarTermino(coeA * coeB, expA + expB);
                Q = Q.obtenerLiga();
            }
            R = R.obtenerLiga();
        }
        return  C;
    }

    private void crearPolinomio(int coe, int exp) {
        Nodo n = new Nodo(coe, exp);
        if (punta == null) {
            punta = n;
        } else {
            Nodo ultimo = punta;
            while (ultimo.obtenerLiga() != null) {
                ultimo = ultimo.obtenerLiga();
            }
            ultimo.asignarLiga(n);
        }
    }
    
    //Dividir
    public PolF3 dividir(PolF3 B){
        int expA = 0;
        int expB = 0;
        int coeA = 0;
        int coeB = 0;
        PolF3 C = new PolF3("C");
        Nodo Q = null;
        Nodo R = punta;
        while ( R != null){
            Q = B.obtenerPunta();
            while ( Q != null){
                expA = R.obtenerExp();
                expB = Q.obtenerExp();
                coeA = R.obtenerCoe();
                coeB = Q.obtenerCoe();
                C.insertarTermino(coeA * coeB, expA + expB);
                Q = Q.obtenerLiga();
            }
            R = R.obtenerLiga();
        }
        return  C;
    }

    
    
    
}