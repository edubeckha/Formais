package gramatica.modelo;

public class Producao {
    public Simbolo origem;
    public String terminal, naoTerminal;
    
    public Producao(Simbolo o){
        origem = o;
    }
        
}
