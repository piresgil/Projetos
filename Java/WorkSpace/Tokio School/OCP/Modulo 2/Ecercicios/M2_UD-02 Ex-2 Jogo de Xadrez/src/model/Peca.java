package model;

import model.enuns.CorPeca;
import model.enuns.TipoPeca;

/**
 * Class Peça
 */
public class Peca {

    private TipoPeca tipo;
    private CorPeca cor;

    public Peca(TipoPeca tipo, CorPeca cor) {
        this.tipo = tipo;
        this.cor = cor;
    }

    public TipoPeca getTipo() {
        return tipo;
    }

    public void setTipo(TipoPeca tipo) {
        this.tipo = tipo;
    }

    public CorPeca getCor() {
        return cor;
    }

    public void setCor(CorPeca cor) {
        this.cor = cor;
    }
}
