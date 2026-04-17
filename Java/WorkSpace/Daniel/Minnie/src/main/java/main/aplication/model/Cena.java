package main.aplication.model;

public class Cena {
    private String texto;
    private String imagem;
    private String opcao1Texto;
    private String opcao1Destino;
    private String opcao2Texto;
    private String opcao2Destino;

    public Cena(String texto, String imagem, String opcao1Texto, String opcao1Destino,
                String opcao2Texto, String opcao2Destino) {
        this.texto = texto;
        this.imagem = imagem;
        this.opcao1Texto = opcao1Texto;
        this.opcao1Destino = opcao1Destino;
        this.opcao2Texto = opcao2Texto;
        this.opcao2Destino = opcao2Destino;
    }

    public String getTexto() { return texto; }
    public String getImagem() { return imagem; }
    public String getOpcao1Texto() { return opcao1Texto; }
    public String getOpcao1Destino() { return opcao1Destino; }
    public String getOpcao2Texto() { return opcao2Texto; }
    public String getOpcao2Destino() { return opcao2Destino; }
}
