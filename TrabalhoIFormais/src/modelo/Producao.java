package modelo;

import java.util.ArrayList;

public class Producao {
    public Simbolo origem;
    public ArrayList<String> producao;
    
    public Producao(Simbolo o){
        origem = o;
        producao = new ArrayList<>();
    }
        
}
