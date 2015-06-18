package automatoFinito;

public class Estado {

    public String label;
    public TipoEstado tipo;

    public Estado() {

    }

    public Estado(String l, int t) {
        label = l;
        tipo = TipoEstado.retornaEstadoAPartir(t);
    }

    public Estado(String l, TipoEstado t) {
        label = l;
        tipo = t;
    }

}
