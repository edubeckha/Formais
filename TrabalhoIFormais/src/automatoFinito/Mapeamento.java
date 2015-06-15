package automatoFinito;

import java.util.HashMap;
import java.util.Map;

public class Mapeamento {

    public Estado estadoOrigem, estadoDestino;
    public Character terminalTransicao;
    public String idDaTransicao;

    public Mapeamento() {

    }

    public Mapeamento(Estado eo, Character tt, Estado ed) {
        estadoOrigem = eo;
        terminalTransicao = tt;
        estadoDestino = ed;
        idDaTransicao = eo.label + ed.label;
    }

    public String retornaIdTransicao() {
        return idDaTransicao;
    }

    public Map<Character, Estado> trasicao() {
        Map<Character, Estado> transicao = new HashMap<>();
        transicao.put(terminalTransicao, estadoDestino);
        return transicao;
    }
}
