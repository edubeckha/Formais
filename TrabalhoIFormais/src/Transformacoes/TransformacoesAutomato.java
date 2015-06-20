package Transformacoes;

import automatoFinito.AutomatoFinito;
import automatoFinito.ClasseEquivalencia;
import automatoFinito.Estado;
import automatoFinito.Mapeamento;
import automatoFinito.TipoEstado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TransformacoesAutomato {

    /**
     * Funcao responsavel por determinizar o automato T(M), gerando um novo
     * automato T(M') e mostrando-o ao usuario.
     */
    public static void determinizar(AutomatoFinito automato) {
     AutomatoFinito tmp = new AutomatoFinito();
     tmp.estados.add(automato.inicial);
     
     if(automato.inicial.tipo.equals(TipoEstado.INICIALFINAL))
         tmp.estadosFinais.add(automato.inicial);
    }

    /**
     * Funcao responsavel por complementar o automato em questao T(M)
     */
    public static void complementar(AutomatoFinito automato) {
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
    public static void verificaETransformaCompleto(AutomatoFinito automato) {
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
    public static void minimizar(AutomatoFinito automato) {
        determinizar(automato);
        retiraInferteis(automato);
        retiraInalcancáveis(automato);
        criaClassesEquivalencia(automato);
    }

    /**
     * Metodo responsavel por retirar simbolos inuteis do automato em questao
     *
     * @param automato
     */
    public static void retiraInferteis(AutomatoFinito automato) {
        Set<Estado> ferteis = new LinkedHashSet<>();
        
        //coloca no set de ferteis todos os simbolos ferteis
        for (Estado estado : automato.estadosFinais) {
            ferteis.add(estado);
        }

        //adiciona nos ferteis todo simbolo que chega a um nao-terminal fertil...
        for (int i = 0; i < automato.estados.size(); i++) {
            for (Mapeamento mapeamento : automato.mapeamentos) {
                if (ferteis.contains(mapeamento.estadoDestino)) {
                    ferteis.add(mapeamento.estadoOrigem);
                }
            }
        }

        //retira do conjunto de mapeamentos todo mapeamento que contem um simbolo nao-fertil (sendo do lado esquerdo ou direito da producao).
        for (Iterator<Mapeamento> it = automato.mapeamentos.iterator(); it.hasNext();) {
            Mapeamento mapeamento = it.next();
            if (!ferteis.contains(mapeamento.estadoOrigem) || !ferteis.contains(mapeamento.estadoDestino)) {
                it.remove();
            }
        }

        //retira todos os estados inferteis do conjunto de estados
        Iterator<Estado> it = automato.estados.iterator();
        while (it.hasNext()) {
            Estado estado = it.next();
            if (!ferteis.contains(estado)) {
                it.remove();
            }
        }
    }

    /**
     * Metodo responsavel por retirar simbolos inalcancaveis do automato
     *
     * @param automato
     */
    public static void retiraInalcancáveis(AutomatoFinito automato) {
        Set<Estado> alcancaveis = new LinkedHashSet<>();
        //o simbolo inicial eh sempre alcancavel...
        alcancaveis.add(automato.inicial);

        
        //coloca em alcancaveis todos os simbolos alcancaveis a partir de outro simbolo ja alcancavel
        for (int i = 0; i < automato.estados.size(); i++) {
            for (Mapeamento mapeamento : automato.mapeamentos) {
                if (alcancaveis.contains(mapeamento.estadoOrigem)) {
                    alcancaveis.add(mapeamento.estadoDestino);
                }
            }
        }

        //cria um set de simbolos inalcancaveis
        Set<Estado> inalcancaveis = new LinkedHashSet<>();
        for (Estado estado : automato.estados) {
            if (!alcancaveis.contains(estado)) {
                inalcancaveis.add(estado);
            }
        }

        //retira os mapeamentos dos simbolos inalcancaveis
            for (Iterator<Mapeamento> it = automato.mapeamentos.iterator(); it.hasNext();) {
                Mapeamento mapeamento = it.next();
                if (inalcancaveis.contains(mapeamento.estadoOrigem)) {
                    it.remove();
                }
            }

        //retira os simbolos inalcancavels dos arrays de estados finais e estados
            Iterator<Estado> it = automato.estados.iterator();
            while(it.hasNext()){
                Estado estado = it.next();
                if(inalcancaveis.contains(estado)){
                    it.remove();
                }
            }
            
            
   }
    
    public static void criaClassesEquivalencia(AutomatoFinito automato){
        Set<ClasseEquivalencia> classesEquivalencia = new LinkedHashSet<>();
        
        ClasseEquivalencia q0 = new ClasseEquivalencia("0");
        ClasseEquivalencia q1 = new ClasseEquivalencia("1");
        for(Estado est : automato.estados){
            if(est.tipo.equals(TipoEstado.FINAL) || est.tipo.equals(TipoEstado.INICIALFINAL)){
                q0.estadosEquivalentes.add(est);
            }
            q1.estadosEquivalentes.add(est);
        }
        
        
        
    }

    /**
     * Funcao responsavel por intersectar dois automatos
     *
     * @param segundoAutomato Automato a ser intersectado com o automato atual
     */
    public static void interseccao(AutomatoFinito automato, AutomatoFinito segundoAutomato) {
        //compleemento da uniao dos complementos !(!L1 UNI !L2)
        complementar(automato);
        complementar(segundoAutomato);
        automato = uniao(automato, segundoAutomato);
        complementar(automato);
    }

    /**
     * Funcao responsavel por unir dois automatos
     *
     * @param automato
     * @param segundoAutomato
     * @return
     */
    public static AutomatoFinito uniao(AutomatoFinito automato, AutomatoFinito segundoAutomato) {
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

    public static void populaAutomato(AutomatoFinito temp, AutomatoFinito automato) {
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
