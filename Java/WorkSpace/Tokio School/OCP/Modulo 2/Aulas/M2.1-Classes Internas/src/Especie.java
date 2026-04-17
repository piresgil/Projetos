public enum Especie {

    CAO(1),
    GATO(2),
    PASSARO(3);

    private int valor;

    Especie(int valor) {
        this.valor = valor;
    }

    int getValor() {
        return valor;
    }
}
