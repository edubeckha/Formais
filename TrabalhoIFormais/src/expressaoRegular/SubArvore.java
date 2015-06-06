package expressaoRegular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// Classe responsável por retornar a posição da raiz
// (operador de menor prioridade)

class SubArvore {

    private static final Map<Character, Integer> precedencia = new HashMap<Character, Integer>();

	// Ao construir a subarvore atribui os valores de precedencia
	// para cada operador unario ou não das expressões regulares.
    public SubArvore() {
        precedencia.put('*', 1);
        precedencia.put('?', 1);
        precedencia.put('.', 2);
        precedencia.put('|', 3);
    }

    // Função que retorna a posição do operador de menor precedencia
    // da ER.
    public int posicaoDaRaiz(String expressao) {
        List<Operador> listaDeOperadores = new ArrayList<Operador>();

        // Avalia todos os operadores da ER e verifica quais são
        // os candidatos a raiz da arvore. Os parenteses já estão sendo
        // considerados na função.
        listarOperadores(expressao, listaDeOperadores);

        // Seleciona, dentre os candidatos, a raiz da arvore.
        return posicaoDaMenorPrecedencia(listaDeOperadores);
    }

    // Obtem uma lista com os operadores e suas posições considerando a precedencia
    // dos parenteses.
    private void listarOperadores(String expressao, List<Operador> listaDeOperadores) {
        Stack<Character> ordemDosParenteses = new Stack<Character>();
        for (int i = 0; i < expressao.length(); i++) {
            if (ordemDosParenteses.isEmpty() && ehOperador(expressao.charAt(i))) {
                listaDeOperadores.add(new Operador(expressao.charAt(i), i));
            } else if (expressao.charAt(i) == '(') {
                ordemDosParenteses.push('(');
            } else if (expressao.charAt(i) == ')') {
                ordemDosParenteses.pop();
            }
        }
    }

    // Verifica se um dado simbolo é um operador válido.
    private boolean ehOperador(char simbolo) {
        return (simbolo == '.' || simbolo == '|' || simbolo == '*' || simbolo == '?');
    }

    // Retorna o operador de menor precedencia juntamente com a sua posição na ER
    // analisando os operadores que estão fora dos parenteses.
    private int posicaoDaMenorPrecedencia(List<Operador> listaDeOperadores) {
        int auxiliar = 0;
        for (int i = 0; i < listaDeOperadores.size(); i++) {
            if (menorPrecedencia(listaDeOperadores.get(auxiliar).simbolo, listaDeOperadores.get(i).simbolo)) {
                auxiliar = 1;
            }
        }
        return listaDeOperadores.get(auxiliar).posicao;
    }

    // Compara dois simbolos para verificar quem tem a menor precedencia, segundo o que foi definido
    // no construtor.
    private boolean menorPrecedencia(char simbolo, char simbolo0) {
        return precedencia.get(simbolo) < precedencia.get(simbolo0);
    }
}

// Classe utilizada para armazenar um simbolo e sua posição no contexto de uma expressão regular.
class Operador {

    public char simbolo;
    public int posicao;

    public Operador(char simbolo, int posicao) {
        this.simbolo = simbolo;
        this.posicao = posicao;
    }
};