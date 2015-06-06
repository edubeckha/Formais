package automatoFinito;

public enum TipoEstado {
INICIAL(),    
NAOFINAL(),
FINAL(),
INICIALFINAL(),
ERRO();

    public static TipoEstado retornaEstadoAPartir(int tipo){
        switch(tipo){
            case 0:
                return INICIAL;
            case 1:
                return NAOFINAL;
            case 2:
                return FINAL;
            case 3:
                return INICIALFINAL;
            case 4:
                return ERRO;
            default:
                return null;
        }
    }
}
