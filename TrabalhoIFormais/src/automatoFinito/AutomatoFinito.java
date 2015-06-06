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
    
    /**
     * Função que trata os dados de entrada de um usuario quando o mesmo cria ou recria um automato a 
     * partir da tabela
     * @param dados Dados do automato
     */
    public void tratarDadosEntrada(Object[][] dados, int numLinhas, int numColunas){
        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                processadorStrings(String.valueOf(dados[i][j]));
            }
        }
    }
    
    /**
     * Processa as strings que sao enviadas para essa funcao. Nesse processamento verificamos o tipo de estado do automato
     * e populamos as devidas estruturas da classe
     * @param string 
     */
    public void processadorStrings(String string){
        Estado temp;
        //vendo se o estado eh final e inicial
       if(string.substring(0, 1).equals("*")){
           if(string.substring(1, 3).equals("->")){
               temp = new Estado(string.substring(string.length()-1, string.length()), 3);
               estadosFinais.add(temp);
               inicial = temp;
           } else{
               temp = new Estado(string.substring(string.length()-1, string.length()), 2);
               estadosFinais.add(temp);
           }
       }//vendo se o estado eh so inicial  
       else if(string.substring(1, 3).equals("->")){
            temp = new Estado(string.substring(string.length()-1, string.length()), 3);
            inicial = temp;
       } else{//eh nao final
            temp = new Estado(string.substring(string.length()-1, string.length()), 1);
       }
       estados.add(temp);
    }
}