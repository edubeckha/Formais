package modelo;

import java.util.ArrayList;

public class Gramatica {
    
    public ArrayList<Simbolo> naoTerminais;
    public ArrayList<Simbolo> terminais;
    public ArrayList<Producoes> producoes;
    public Simbolo simboloInicial;
    
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
        
        simboloInicial = new Simbolo("S", 0);
        naoTerminais.add(simboloInicial);
    }
}

