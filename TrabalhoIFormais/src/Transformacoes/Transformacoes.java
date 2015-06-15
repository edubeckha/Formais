package Transformacoes;

import automatoFinito.AutomatoFinito;
import automatoFinito.Mapeamento;
import gramatica.modelo.Gramatica;
import gramatica.modelo.Producao;
import gramatica.modelo.Simbolo;
import gramatica.modelo.TipoSimbolo;

public class Transformacoes {

   /* public static Gramatica automatoParaGramatica(AutomatoFinito automato) {
        Gramatica g = new Gramatica();
        g.simboloInicial = new Simbolo(automato.inicial.label, 0);
        Simbolo temp = g.simboloInicial;

        for (Mapeamento mapeamento : automato.mapeamentos) {
            if (automato.estadosFinais.contains(mapeamento.estadoDestino)) {
                g.producoes.add(new Producao(new Simbolo(mapeamento.estadoOrigem.label, 1), new Simbolo("", 1), mapeamento.terminalTransicao));
            }
            g.producoes.add(new Producao(new Simbolo(mapeamento.estadoOrigem.label, 1), new Simbolo(mapeamento.estadoDestino.label, 1) , mapeamento.terminalTransicao));
        }
        if(automato.estadosFinais.contains(automato.inicial)){
            g.simboloInicial.tipo = TipoSimbolo.NAOTERMINAL;
            g.simboloInicial = new Simbolo(temp.nome, 0);
            for(Producao p : g.producoes){
                if(p.origem.nome.equals(temp.nome)){
                    g.producoes.add(new Producao(g.simboloInicial, p.naoTerminal, p.terminal));
                }
            }
        }
        return g;
    }*/

}
