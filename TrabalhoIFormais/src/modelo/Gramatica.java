/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

public class Gramatica {
    
    public ArrayList<Simbolo> naoTerminais;
    public ArrayList<Simbolo> terminais;
    public ArrayList<Producao> producoes;
    private static Gramatica instancia;
    
    public static Gramatica retornaSingleton(){
        if(instancia == null)
            instancia = new Gramatica();
        return instancia;
    }

    private Gramatica(){
        naoTerminais = new ArrayList<>();
        terminais = new ArrayList<>();
        producoes = new ArrayList<>();
    }
}

