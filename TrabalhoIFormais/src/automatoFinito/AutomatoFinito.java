package automatoFinito;

import java.util.ArrayList;
import java.util.Iterator;

public class AutomatoFinito {

    public ArrayList<Estado> estados;
    public ArrayList<SimboloAlfabeto> alfabeto;
    public ArrayList<Mapeamento> mapeamentos;
    public Estado inicial;
    public ArrayList<Estado> estadosFinais;

    public AutomatoFinito() {
        estados = new ArrayList<>();
        alfabeto = new ArrayList<>();
        mapeamentos = new ArrayList<>();
        estadosFinais = new ArrayList<>();
    }

    /**
     * Função que adiciona uma nova função de mapeamento na estrutura do
     * autômato
     *
     * @param q Estado de origem
     * @param s Simbolo pertencente à transição
     * @param destino Estado de destino
     */
    public void adicionarNovaFuncaoMapeamento(Estado q, SimboloAlfabeto s, Estado destino) {
        Mapeamento mapeamento = new Mapeamento(q, s, destino);
        q.sucessores.add(destino);
        destino.antecessores.add(q);
        estados.add(q);
        estados.add(destino);
        alfabeto.add(s);
    }

    /**
     * Função que reseta o automato para ser reescrita na GUI
     */
    public void resetarAutomato() {
        estados.clear();
        alfabeto.clear();
        mapeamentos.clear();
        inicial = null;
        estadosFinais.clear();
    }

    /**
     * Função que trata os dados de entrada de um usuario quando o mesmo cria ou
     * recria um automato a partir da tabela
     *
     * @param dados Dados do automato
     * @param numColunas numero de colunas da minha tabela do automato
     */
    public void tratarDadosEntrada(Object[][] dados, int numLinhas, int numColunas) {
        for (int j = 0; j < numColunas; j++) {
            processadorEstados(String.valueOf(dados[0][j]));
        }
        criaFuncoesMapeamento(dados, numLinhas, numColunas);
    }

    public void criaFuncoesMapeamento(Object[][] dados, int numLinhas, int numColunas) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                //Mapeamento mapea = new Mapeamento(inicial, null, inicial)
            }
        }
    }

    /**
     * Processa as strings que sao enviadas para essa funcao. Nesse
     * processamento verificamos o tipo de estado do automato e populamos as
     * devidas estruturas da classe
     *
     * @param string String a ser computada
     */
    public void processadorEstados(String string) {
        Estado temp = null;
//vendo se o estado eh final e inicial
        if (string.subSequence(0, 1).equals("*")) {
            string = string.substring(1);
            if (string.subSequence(0, 1).equals("-")) {
                if (string.subSequence(1, 2).equals(">")) {
                    temp = new Estado(string.substring(2), 3);
                    estadosFinais.add(temp);
                    inicial = temp;
                }
            } else {
                temp = new Estado(string, 2);
                estadosFinais.add(temp);
            }
        }//vendo se o estado eh so inicial 
        else {
            if (string.subSequence(0, 1).equals("-")) {
                if (string.subSequence(1, 2).equals(">")) {
                    temp = new Estado(string.substring(2), 0);
                    inicial = temp;
                }
            } else {//eh nao final
                if (string.substring(0, 1).matches("[A-Za-z0-9]+")) {
                    temp = new Estado(string, 1);
                }
            }
        }
        estados.add(temp);
    }

    public Estado retornaEstadoAPartirDeLabel(String label) {
        Estado estado = null;
        for (Estado est : estados) {
            if (est.label.equals(label)) {
                estado = est;
            }
        }
        return estado;
    }

}
