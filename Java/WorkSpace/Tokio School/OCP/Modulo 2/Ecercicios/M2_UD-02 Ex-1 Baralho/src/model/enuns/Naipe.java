package model.enuns;

/**
 * Enum Naipe
 */
public enum Naipe {
    ESPADAS('E'), COPAS('C'), PAUS('P'), OUROS('O');

    private final char abreviatura;

    Naipe(char abreviatura) {
        this.abreviatura = abreviatura;
    }

    public char getAbreviatura() {
        return abreviatura;
    }
}
