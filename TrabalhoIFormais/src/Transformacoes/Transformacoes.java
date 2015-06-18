package Transformacoes;

import automatoFinito.AutomatoFinito;
import automatoFinito.Estado;
import automatoFinito.Mapeamento;
import automatoFinito.TipoEstado;
import gramatica.modelo.Gramatica;
import gramatica.modelo.Producao;
import gramatica.modelo.Simbolo;
import gramatica.modelo.TipoSimbolo;

public class Transformacoes {
    
    public static Gramatica automatoParaGramatica(AutomatoFinito automato) {
        Gramatica g = new Gramatica();
        g.simboloInicial = new Simbolo(automato.inicial.label, 0);
        Simbolo temp = g.simboloInicial;
        for (Mapeamento mapeamento : automato.mapeamentos) {
            if (mapeamento.estadoDestino.label.equals("-")) {
                continue;
            }
            if (automato.estadosFinais.contains(mapeamento.estadoDestino)) {
                g.producoes.add(new Producao(new Simbolo(mapeamento.estadoOrigem.label, 1), new Simbolo(mapeamento.terminalTransicao.toString(), 2), new Simbolo("", 1)));
            }
            g.producoes.add(new Producao(new Simbolo(mapeamento.estadoOrigem.label, 1), new Simbolo(mapeamento.terminalTransicao.toString(), 2), new Simbolo(mapeamento.estadoDestino.label, 1)));
        }
        if (automato.estadosFinais.contains(automato.inicial)) {
            g.simboloInicial.tipo = TipoSimbolo.NAOTERMINAL;
            g.simboloInicial = new Simbolo(temp.nome + "'", 0);
            for (Producao p : g.producoes) {
                if (p.origem.nome.equals(temp.nome)) {
                    g.producoes.add(new Producao(g.simboloInicial, p.naoTerminal, p.terminal));
                }
            }
            g.producoes.add(new Producao(g.simboloInicial, new Simbolo("", 1), new Simbolo("&", 2)));
        }
        return g;
    }
    
    public static AutomatoFinito gramaticaParaAutomato(Gramatica gramatica) {
        AutomatoFinito automato = new AutomatoFinito();
        if (gramatica.inicialVaiPraEpsilon()) {
            automato.estados.add(new Estado(gramatica.simboloInicial.nome, TipoEstado.INICIALFINAL));
        } else {
            automato.estados.add(new Estado(gramatica.simboloInicial.nome, TipoEstado.INICIAL));
        }
        automato.estados.add(new Estado("U", TipoEstado.FINAL));
        for (Producao producao : gramatica.producoes) {
            if (producao.naoTerminal.nome.isEmpty()) {
                if (producao.origem.tipo.equals(TipoEstado.INICIAL)) {
                    automato.mapeamentos.add(new Mapeamento(new Estado(producao.origem.nome, TipoEstado.INICIAL), producao.terminal.nome.charAt(0), new Estado(producao.naoTerminal.nome, TipoEstado.NAOFINAL)));
                } else if(producao.origem.tipo.equals(TipoEstado.INICIALFINAL)){
                    automato.mapeamentos.add(new Mapeamento(new Estado(producao.origem.nome, TipoEstado.INICIALFINAL), producao.terminal.nome.charAt(0), new Estado(producao.naoTerminal.nome, TipoEstado.NAOFINAL)));
                }
            }
        }
        return automato;
    }
    
}
