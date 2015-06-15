package gramatica.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gramatica {

    public ArrayList<Simbolo> naoTerminais;
    public ArrayList<Simbolo> terminais;
    public ArrayList<Producao> producoes;
    public Simbolo simboloInicial;

    public Gramatica() {
        naoTerminais = new ArrayList<>();
        terminais = new ArrayList<>();
        producoes = new ArrayList<>();
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

        definirTerminaisNaoTerminais();

    }

    public void adicionaUmaProducao(Simbolo origem, String s) {
        Producao tmp = new Producao(origem);
        tmp.terminal = new Simbolo(s.substring(0, 1), 2);

        try {
            tmp.naoTerminal = new Simbolo(s.substring(1, 2), 1);
        } catch (Exception e) {
            tmp.naoTerminal = new Simbolo("", 1);
        }
        producoes.add(tmp);
    }

    /**
     * Define um conjunto de terminais a partir das producoes da gramatica
     */
    public void definirTerminaisNaoTerminais() {
        for (Producao prod : producoes) {
            String naoTerminal = prod.naoTerminal.nome;
            if (!naoTerminal.isEmpty()) {
                naoTerminais.add(new Simbolo(prod.naoTerminal.nome, 1));
            }
            terminais.add(new Simbolo(prod.terminal.nome, 2));
        }
    }

    /**
     * Função que reseta a gramatica para ser reescrita na GUI
     */
    public void resetarGramatica() {
        producoes.clear();
        naoTerminais.clear();
        terminais.clear();
        simboloInicial = null;
    }
}
