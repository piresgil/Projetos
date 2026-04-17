package genericsClasses;

public class Caixa<P> {

    private P valor;

    public Caixa(P valor) {
        this.valor = valor;
    }

    public P getValor() {
        return valor;
    }

    public void setValor(P valor) {
        this.valor = valor;
    }
}
