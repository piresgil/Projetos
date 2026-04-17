package model.enuns;

/**
 * Enum Numero
 */
public enum Numero {
    AS('A'), DOIS('2'), TRES('3'), QUATRO('4'), CINCO('5'),
    SEIS('6'), SETE('7'), VALETE('A'), DAMA('D'), REI('R');

    private final char abreviatura;

    Numero(char abreviatura) {
        this.abreviatura = abreviatura;
    }

    public char getAbreviatura() {
        return abreviatura;
    }
}
