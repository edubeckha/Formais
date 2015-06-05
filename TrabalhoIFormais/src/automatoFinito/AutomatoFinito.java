package automatoFinito;
import java.util.HashSet;
import java.util.Set;

public class AutomatoFinito {
    
    public Set<Estado> estados;
    public Set<SimboloAlfabeto> alfabeto;
    public Set<Mapeamento> mapeamentos;
    public Estado inicial;
    public Set<Estado> estadosFinais;
    private static AutomatoFinito _instancia;
    
    public static AutomatoFinito retornaInstancia(){
        if(_instancia == null)
            _instancia = new AutomatoFinito();
        return _instancia;
    }
    public AutomatoFinito(){
        estados = new HashSet<>();
        alfabeto = new HashSet<>();
        mapeamentos = new HashSet<>();
        estadosFinais = new HashSet<>();
    }
    
    /**
     * Função que adiciona uma nova função de mapeamento na estrutura do autômato
     * @param q Estado de origem
     * @param s Simbolo pertencente à transição
     * @param destino Estado de destino
     */
    public void adicionarNovaFuncaoMapeamento(Estado q, SimboloAlfabeto s, Estado destino){
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
    public void resetarAutomato(){
        estados.clear();
        alfabeto.clear();
        mapeamentos.clear();
        inicial = null;
        estadosFinais.clear();
        
    }
}
