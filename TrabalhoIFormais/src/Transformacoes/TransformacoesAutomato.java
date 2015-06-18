package Transformacoes;

import automatoFinito.AutomatoFinito;
import automatoFinito.Estado;
import automatoFinito.Mapeamento;
import automatoFinito.TipoEstado;
import java.util.ArrayList;

public class TransformacoesAutomato {

    /**
     * FunÃ§Ã£o responsÃ¡vel por determinizar o automato T(M), gerando um novo
     * automato T(M') e mostrando-o ao usuario.
     */
    public static void determinizar(AutomatoFinito automato) {
        ArrayList<Estado> estados = new ArrayList<>();
        for (Estado estado : automato.estados) {
            for (Character c : automato.alfabeto) {
                for (Mapeamento mapeamento : automato.mapeamentos) {
                    if (mapeamento.estadoOrigem.equals(estado)) {
                        estados.add(mapeamento.estadoDestino);
                    }
                }
            }

        }

    }

    /**
     * Funcao responsavel por complementar o automato em questao T(M)
     */
    public void complementar(AutomatoFinito automato) {
        determinizar(automato);
        verificaETransformaCompleto(automato);
        ArrayList<Estado> novosEstadosFinais = new ArrayList<>();
        ArrayList<Estado> novosEstadosNaoFinais = new ArrayList<>();

        for (Estado estado : automato.estados) {
            switch (estado.tipo) {
                case FINAL:
                    estado.tipo = TipoEstado.NAOFINAL;
                    break;
                case INICIAL:
                    estado.tipo = TipoEstado.INICIALFINAL;
                    break;
                case NAOFINAL:
                    estado.tipo = TipoEstado.FINAL;
                    break;
                case INICIALFINAL:
                    estado.tipo = TipoEstado.INICIAL;
                    break;
                case ERRO:
                    estado.tipo = TipoEstado.FINAL;
            }
        }

        automato.estadosFinais.clear();
        for (Estado est : automato.estados) {
            if (est.tipo == TipoEstado.FINAL || est.tipo == TipoEstado.INICIALFINAL) {
                automato.estadosFinais.add(est);
            }
        }

    }

    /**
     * Funcao responsavel por verificar se o automato em questao eh completo e
     * completa-lo caso seja necessario
     *
     */
    public void verificaETransformaCompleto(AutomatoFinito automato) {
        for (Mapeamento mapeamento : automato.mapeamentos) {
            if (mapeamento.estadoDestino.label.equals("-")) {
                break;
            }
            if (mapeamento.estadoDestino.label.equals("-")) {
                mapeamento.estadoDestino = automato.erro;
            }
        }
    }

    /**
     * Funcao responsavel por minimizar o automato
     */
    public void minimizar(AutomatoFinito automato) {

    }

    /**
     * FunÃ§Ã£o responsÃ¡vel por intersectar dois automatos
     *
     * @param segundoAutomato Automato a ser intersectado com o automato atual
     */
    public void interseccao(AutomatoFinito automato, AutomatoFinito segundoAutomato) {
        //compleemento da uniao dos complementos !(!L1 UNI !L2)
        complementar(automato);
        complementar(segundoAutomato);
        automato = uniao(automato, segundoAutomato);
        complementar(automato);
    }

    /**
     * FunÃ§Ã£o responsÃ¡vel por unir dois autÃ´matos
     *
     * @param automato
     * @param segundoAutomato
     * @return
     */
    public AutomatoFinito uniao(AutomatoFinito automato, AutomatoFinito segundoAutomato) {
        AutomatoFinito temp = new AutomatoFinito();
        Estado tmpInicial;
        tmpInicial = new Estado("U", TipoEstado.INICIAL);

        if (automato.inicial.tipo == TipoEstado.INICIALFINAL || segundoAutomato.inicial.tipo == TipoEstado.INICIALFINAL) {
            tmpInicial.tipo = TipoEstado.INICIALFINAL;
        }

        temp.inicial = tmpInicial;
        populaAutomato(temp, automato);
        populaAutomato(temp, segundoAutomato);
        return temp;
    }

    public void populaAutomato(AutomatoFinito temp, AutomatoFinito automato) {
        for (Mapeamento mapeamento : automato.mapeamentos) {
            if (mapeamento.estadoOrigem == automato.inicial) {
                temp.mapeamentos.add(new Mapeamento(temp.inicial, mapeamento.terminalTransicao, mapeamento.estadoDestino));
            } else {
                temp.mapeamentos.add(mapeamento);
            }
        }
        if (automato.inicial.tipo == TipoEstado.INICIALFINAL ? automato.inicial.tipo
                == TipoEstado.FINAL : automato.inicial.tipo == TipoEstado.NAOFINAL);
        temp.estados.addAll(automato.estados);
        temp.estadosFinais.addAll(automato.estadosFinais);
        for (int i = 0; i < automato.alfabeto.size(); i++) {
            String sim = automato.alfabeto.toString();
            if (!temp.alfabeto.contains(sim.charAt(0))) {
                temp.alfabeto.add(sim.charAt(0));
            }
        }
    }
}
