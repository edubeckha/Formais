package gramatica.modelo;

import java.util.ArrayList;

public class Gramatica {
    
    public ArrayList<Simbolo> naoTerminais;
    public ArrayList<Simbolo> terminais;
    public ArrayList<Producao> producoes;
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
    }
    
    /**
     * Define uma nova gramatica a partir do conjunto de producoes passado como parametro
     * @param prod 
     */
    public void definirNovaGramatica(ArrayList<Producao> prod){
        resetarGramatica();
        for(int i = 0; i < prod.size(); i++){
            if(prod.get(i).origem.tipo.equals(TipoSimbolo.INICIAL))
                simboloInicial = prod.get(i).origem;
            producoes.add(prod.get(i));
        }
            definirTerminaisNaoTerminais();
    }
    
    /**
     * Define um conjunto de terminais a partir das producoes da gramatica
     */
    public void definirTerminaisNaoTerminais(){
        for(Producao prod : producoes){
            String naoTerminal = prod.naoTerminal;
            if(!naoTerminal.isEmpty())
            naoTerminais.add(new Simbolo(prod.naoTerminal, 1));
           terminais.add(new Simbolo(prod.terminal, 2));
        }     
    }
    
    /**
     * Função que reseta a gramatica para ser reescrita na GUI
     */
    public void resetarGramatica(){
        producoes.clear();
        naoTerminais.clear();
        terminais.clear();
        simboloInicial = null;
    }
}

