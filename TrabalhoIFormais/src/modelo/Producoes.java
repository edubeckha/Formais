package modelo;

import java.util.ArrayList;

public class Producoes {
    public Simbolo origem;
    public ArrayList<Simbolo> destino;
    
    public Producoes(Simbolo o){
        origem = o;
        destino = new ArrayList<>();
    }
        
}
