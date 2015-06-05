package automatoFinito;
import java.util.HashSet;
import java.util.Set;

public class Estado {
    public String label;
    public TipoEstado tipo;
    public Set<Estado> antecessores, sucessores;
    
    public Estado(String l, int t){
        label = l;
        tipo = TipoEstado.retornaEstadoAPartir(t);
        antecessores = new HashSet<>();
        sucessores = new HashSet<>();
    }
    
}
