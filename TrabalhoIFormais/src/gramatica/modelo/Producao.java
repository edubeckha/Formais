package gramatica.modelo;

public class Producao {
    public Simbolo origem, naoTerminal, terminal;

    public Producao(Simbolo o){
        origem = o;
    }
    
    public Producao(Simbolo o, Simbolo nt, Simbolo term){
        origem = o;
        naoTerminal = nt;
        terminal = term;
    }
        
}
