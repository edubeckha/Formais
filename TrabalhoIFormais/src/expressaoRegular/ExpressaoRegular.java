package expressaoRegular;

import automatoFinito.AutomatoFinito;
import automatoFinito.Estado;
import automatoFinito.Mapeamento;
import automatoFinito.TipoEstado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ExpressaoRegular {

    public AutomatoFinito montaAutomato(Arvore arvore) {
        List<CompoeEstado> listaDosEstados = new ArrayList<>();
        Stack<CompoeEstado> pendentes = new Stack<>();
        int contaEstado = 0;
        CompoeEstado inicial = new CompoeEstado("q" + contaEstado);
        List<JaPercorrido> jaPercorridoDaRaiz = new ArrayList<>();
        percorrimentoDaArvore(arvore.raiz, false, inicial.componentes, jaPercorridoDaRaiz);
        pendentes.push(inicial);
        listaDosEstados.add(inicial);

        List<Character> alfabeto = alfabeto(arvore.listaDeFolhas);

        while (!pendentes.isEmpty()) {
            CompoeEstado atual = pendentes.pop();

            List<Character> totalOperadores = new ArrayList<>();

            for (int i = 0; i < atual.componentes.size(); i++) {
                char simb = atual.componentes.get(i).simbolo;
                if (!totalOperadores.contains(simb) && simb != '&') {
                    totalOperadores.add(simb);
                }
            }

            for (int i = 0; i < totalOperadores.size(); i++) {
                contaEstado++;
                CompoeEstado novoEstado = new CompoeEstado("q" + contaEstado);
                List<Nodo> compoeEntradas = compoeEntrada(atual.componentes, totalOperadores.get(i));
                for (int j = 0; j < compoeEntradas.size(); j++) {
                    List<JaPercorrido> percorridos = new ArrayList<>();
                    percorrimentoDaArvore(compoeEntradas.get(j).costura, true, novoEstado.componentes, percorridos);
                }

                boolean jaExiste = false;
                for (int j = 0; j < listaDosEstados.size() && jaExiste == false; j++) {
                    int posicaoDoEquivalente = existeEquivalente(novoEstado.componentes, listaDosEstados);
                    if (posicaoDoEquivalente != -1) {
                        jaExiste = true;
                        atual.transicao.add(new Transicao(totalOperadores.get(i), listaDosEstados.get(posicaoDoEquivalente)));
                    } else {
                        jaExiste = true;
                        listaDosEstados.add(novoEstado);
                        atual.transicao.add(new Transicao(totalOperadores.get(i), novoEstado));
                        pendentes.push(novoEstado);
                    }
                }
            }
        }
        return transformaListaDeEstadosEmAutomato(listaDosEstados, alfabeto);
    }

    public void percorrimentoDaArvore(Nodo nodo, boolean direcao, List<Nodo> composicaoEstado, List<JaPercorrido> passeiApartirDaRaiz) {
        if (composicaoEstado.contains(nodo)) {
            return;
        }
        char simboloNodo = nodo.simbolo;
        if (direcao) {
            switch (simboloNodo) {
                case '.':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fDireita, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '|':
                    while (nodo.fDireita != null) {
                        nodo = nodo.fDireita;
                    }
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, true, nodo)) {
                        percorrimentoDaArvore(nodo.costura, true, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '*':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, true, nodo)) {
                        percorrimentoDaArvore(nodo.costura, true, composicaoEstado, passeiApartirDaRaiz);
                    }
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fEsquerda, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '?':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, true, nodo)) {
                        percorrimentoDaArvore(nodo.costura, true, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                default:
                    composicaoEstado.add(nodo);
                    break;
            }
        } else {
            switch (simboloNodo) {
                case '.':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fEsquerda, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '|':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fEsquerda, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fDireita, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '*':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, true, nodo)) {
                        percorrimentoDaArvore(nodo.costura, true, composicaoEstado, passeiApartirDaRaiz);
                    }
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fEsquerda, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                case '?':
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, true, nodo)) {
                        percorrimentoDaArvore(nodo.costura, true, composicaoEstado, passeiApartirDaRaiz);
                    }
                    if (jaPasseiPorAqui(passeiApartirDaRaiz, false, nodo)) {
                        percorrimentoDaArvore(nodo.fEsquerda, false, composicaoEstado, passeiApartirDaRaiz);
                    }
                    break;
                default:
                    composicaoEstado.add(nodo);
                    break;
            }
        }

    }

    public int existeEquivalente(List<Nodo> comporNovoEstado, List<CompoeEstado> compoeAtual) {
        boolean ehEquivalente = false;
        for (int i = 0; i < compoeAtual.size() && ehEquivalente == false; i++) {
            ehEquivalente = composicoesSaoIguais(comporNovoEstado, compoeAtual.get(i).componentes);
            if (ehEquivalente) {
                return i;
            }
        }
        return -1;
    }

    private boolean composicoesSaoIguais(List<Nodo> comporNovoEstado, List<Nodo> componentes) {
        if (comporNovoEstado.size() != componentes.size()) {
            return false;
        }
        for (int i = 0; i < comporNovoEstado.size(); i++) {
            Nodo atual = comporNovoEstado.get(i);
            boolean ehIgual = false;
            for (int j = 0; j < comporNovoEstado.size() && ehIgual == false; j++) {
                if (atual.valor == comporNovoEstado.get(i).valor) {
                    ehIgual = true;
                }
            }
            if (ehIgual == false) {
                return false;
            }
        }
        return true;
    }

    private AutomatoFinito transformaListaDeEstadosEmAutomato(List<CompoeEstado> estados, List<Character> alfabeto) {
        AutomatoFinito automato = new AutomatoFinito();
        automato.alfabeto = (ArrayList<Character>) alfabeto;
        Estado inicial = null;
        if (ehEstadoFinal(estados.get(0).componentes)) {
            inicial = new Estado("q0", 3);
            inicial.label = estados.get(0).estado;
        }
        automato.inicial = new Estado();
        automato.estados.add(inicial);
        if (inicial.tipo.equals(3)) {
            automato.estadosFinais.add(inicial);
        } else {
            automato.estados.add(inicial);
        }

        //i = 1 por que nao nao queremos pegar o estado inicial denovo
        for (int i = 1; i < estados.size(); i++) {
            Estado novoEstado = new Estado();
            novoEstado.label = estados.get(i).estado;
            boolean estadoFinal = ehEstadoFinal(estados.get(i).componentes);
            if (estadoFinal) {
                novoEstado.tipo = TipoEstado.FINAL;
                automato.estadosFinais.add(novoEstado);
            } else {
                novoEstado.tipo = TipoEstado.NAOFINAL;
                automato.estados.add(novoEstado);
            }
            automato.estados.add(novoEstado);
        }
        //agora que ja tenho as listas com os estados sÃ³ falta criar as funÃ§Ãµes
        for (int i = 0; i < automato.estados.size(); i++) {
            for (int j = 0; j < estados.get(i).transicao.size(); j++) {
                Mapeamento funcao = new Mapeamento();
                funcao.idDaTransicao = automato.estados.get(i).label + estados.get(i).transicao.get(j).proximo.estado;
                funcao.estadoOrigem = automato.estados.get(i);
                funcao.terminalTransicao = estados.get(i).transicao.get(j).simbolo;
                funcao.estadoOrigem = automato.estados.get(pegarEstado(automato.estados, estados.get(i).transicao.get(j).proximo.estado));
                automato.mapeamentos.add(funcao);
            }
        }
        return null;
    }

    private List<Nodo> compoeEntrada(List<Nodo> compoe, char entrada) {
        List<Nodo> composicoes = new ArrayList<>();
        Iterator<Nodo> iterador = compoe.listIterator();
        while (iterador.hasNext()) {
            Nodo next = iterador.next();
            if (next.simbolo == entrada) {
                composicoes.add(next);
            }
        }
        return composicoes;
    }

    private int pegarEstado(List<Estado> estados, String nome) {
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).label.equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    private List<Character> alfabeto(List<Nodo> folhas) {
        List<Character> alfabeto = new ArrayList<>();
        for (int i = 0; i < folhas.size(); i++) {
            char simb = folhas.get(i).simbolo;
            if (!alfabeto.contains(simb) && simb != '&') {
                alfabeto.add(simb);
            }
        }
        return alfabeto;
    }

    private boolean ehEstadoFinal(List<Nodo> estados) {
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).simbolo == '&') {
                return true;
            }
        }
        return false;
    }

    public boolean jaPasseiPorAqui(List<JaPercorrido> jaPassei, boolean direcaoPraIr, Nodo raiz) {
        for (int i = 0; i < jaPassei.size(); i++) {
            if (jaPassei.get(i).direcao == direcaoPraIr && jaPassei.get(i).nodo.equals(raiz)) {
                return false;
            }
        }
        jaPassei.add(new JaPercorrido(raiz, direcaoPraIr));
        return true;
    }
}

class JaPercorrido {

    Nodo nodo;
    boolean direcao;

    public JaPercorrido(Nodo nodo, boolean direcao) {
        this.nodo = nodo;
        this.direcao = direcao;
    }
}

class CompoeEstado {

    String estado;
    List<Transicao> transicao = new ArrayList<Transicao>();
    List<Nodo> componentes = new ArrayList<Nodo>();

    CompoeEstado(String estado) {
        this.estado = estado;
    }
};

class Transicao {

    char simbolo;
    CompoeEstado proximo;

    public Transicao(char simbolo, CompoeEstado proximo) {
        this.simbolo = simbolo;
        this.proximo = proximo;
    }

};

class Percorrido {

    Nodo nodo;
    boolean direcao;

    Percorrido(Nodo nodo, boolean direcao) {
        this.nodo = nodo;
        this.direcao = direcao;
    }
};
