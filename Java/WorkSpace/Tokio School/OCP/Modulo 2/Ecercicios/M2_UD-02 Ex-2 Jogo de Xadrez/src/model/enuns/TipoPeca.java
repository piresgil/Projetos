package model.enuns;

/**
 * Enum Tipo peça
 */
public enum TipoPeca {
    PEAO(1), TORRE(5), VALETE(3), BISPO(3), DAMA(9), REI(0);

    private final int valor;

    TipoPeca(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
