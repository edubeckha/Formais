package Modelo;

import java.util.ArrayList;

public class Producao {
    
    private final Simbolo ladoEsquerdo;
    private ArrayList<Simbolo> ladoDireito;
    
    public Producao(Simbolo le, ArrayList<Simbolo> ld){
        ladoDireito = new ArrayList<>();
        ladoEsquerdo = le;
        ladoDireito = ld;
    }
}
