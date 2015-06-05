package automatoFinito;

public enum TipoEstado {
    
NAOFINAL(),
FINAL(),
ERRO();

    public static TipoEstado retornaEstadoAPartir(int tipo){
        switch(tipo){
            case 0:
                return NAOFINAL;
            case 1:
                return FINAL;
            case 2:
                return ERRO;
            default:
                return null;
        }
    }
}
