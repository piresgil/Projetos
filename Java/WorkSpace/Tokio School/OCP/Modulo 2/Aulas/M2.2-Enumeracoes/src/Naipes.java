public enum Naipes {
    COPAS("Copas"),
    OUROS("Ouros"),
    PAUS("Paus"),
    ESPADAS("Espadas");

    private String nomeNaipe;

    Naipes(String nome){
        this.nomeNaipe=nome;
    }

    public String getNomeNaipe() {
        return nomeNaipe;
    }

    public void setNomeNaipe(String nomeNaipe) {
        this.nomeNaipe = nomeNaipe;
    }
}
