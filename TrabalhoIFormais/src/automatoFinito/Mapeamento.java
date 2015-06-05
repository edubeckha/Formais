package automatoFinito;
public class Mapeamento {
  
    public Estado estadoOrigem, estadoDestino;
    public SimboloAlfabeto terminalTransicao;
    
    public Mapeamento(Estado eo, SimboloAlfabeto tt, Estado ed){
        estadoOrigem = eo;
        terminalTransicao = tt;
        estadoDestino = ed;
    }
    
}
