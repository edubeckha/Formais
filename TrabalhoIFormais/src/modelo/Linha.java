package modelo;

import java.util.ArrayList;

public class Linha {
    
    public ArrayList<Simbolo> linha;
    
    public Linha(){
        linha = new ArrayList<>();
    }
    
    public void adicionaSimboloNaLinha(Simbolo simbolo){
        linha.add(simbolo);
    }
}
