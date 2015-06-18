package gramatica.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Gramatica {

    public ArrayList<Producao> producoes;
    public Simbolo simboloInicial;
    public Set<Character> alfabeto;

    public Gramatica() {
        producoes = new ArrayList<>();
        alfabeto = new LinkedHashSet<>();
    }

    /**
     * Função que trata os dados de entrada de um usuario quando o mesmo cria ou
     * recria uma gramatica a partir da tabela
     *
     * @param dados Dados do automato
     * @param numColunas numero de colunas da tabela da gramatica
     * @param numLinhas numero de linhas da tabela da gramatica
     */
    public void tratarDadosEntrada(Object[][] dados, int numLinhas, int numColunas) {
        Simbolo origem;
        for (int j = 0; j < numLinhas; j++) {
            if (j == 0) {
                origem = new Simbolo(String.valueOf(dados[j][1]), 0);
                simboloInicial = origem;
            } else {
                origem = new Simbolo(String.valueOf(dados[j][1]), 1);
            }

            List<String> listaProducoes = Arrays.asList(String.valueOf(dados[j][2]).split("\\|"));
            for (String s : listaProducoes) {
                adicionaUmaProducao(origem, s);
            }
        }
    }

    public void adicionaUmaProducao(Simbolo origem, String s) {
        Simbolo terminal = new Simbolo(s.substring(0, 1), 2);
        Simbolo naoTerminal;

        try {
            naoTerminal = new Simbolo(s.substring(1, 2), 1);
        } catch (Exception e) {
            naoTerminal = new Simbolo("", 1);
        }

        Producao producao = new Producao(origem, terminal, naoTerminal);
        producoes.add(producao);
    }

    /**
     * Função que reseta a gramatica para ser reescrita na GUI
     */
    public void resetarGramatica() {
        producoes.clear();
        simboloInicial = null;
    }

    /**
     * Verifica se o simbolo inicial tem uma producao que vai para &
     *
     * @return flag que mostra se vai para &
     */
    public boolean inicialVaiPraEpsilon() {
        for (Producao prod : producoes) {
            if (prod.origem.equals(simboloInicial) && prod.naoTerminal.nome.equals("&")) {
                return true;
            }
        }
        return false;
    }
}
