package modelo;
public class Simbolo {
    public TipoSimbolo tipo; //terminal, nao-terminal
    public String terminal, naoTerminal;
    
    public Simbolo(String ter, String nTer, int t){
       terminal = ter;
       naoTerminal = nTer;
       tipo = TipoSimbolo.retornaTipoAPartirDeBooleano(t);
    }
}
