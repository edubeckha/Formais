package gramatica.modelo;
public class Simbolo {
    public TipoSimbolo tipo; //terminal, nao-terminal
    String nome;
    
    public Simbolo(String n, int t){
       nome = n;
       tipo = TipoSimbolo.retornaTipoAPartirDeBooleano(t);
    }
}
