package component;

import model.Peca;
import model.enuns.CorPeca;
import model.enuns.TipoPeca;

public class Tabuleiro {
    private Peca[][] matriz = new Peca[8][8];

    // Construtor para iniciar todas as peças na posição
    public Tabuleiro() {
        tabuleiroTodasPecas();
    }

    /**
     * Metodo colocar peça
     * Coloca uma peça especifica,
     * numa posição específica na matriz
     *
     * @param peca
     * @param linha
     * @param coluna
     */
    public void colocarPeca(Peca peca, int linha, int coluna) {
        matriz[linha][coluna] = peca;
    }

    /**
     * Metodo get peça
     * Obtém posição específica da peça na matriz
     *
     * @param linha
     * @param coluna
     * @return a posição específica de uma peça na matriz
     */
    public Peca getPeca(int linha, int coluna) {
        return matriz[linha][coluna];
    }

    /**
     * Metodo Avalia()
     * Avalia o valor das peças por uma determinada cor
     *
     * @param cor
     * @return valor das peças de uma determinada cor
     */
    public int avalia(CorPeca cor) {
        int valor = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] != null && matriz[i][j].getCor() == cor) {
                    valor += matriz[i][j].getTipo().getValor();
                }
            }
        }
        return valor;
    }

    /**
     * Metodo Avalia()
     * Avalia o valor das peças na matriz por uma determinada cor
     * 39 Brancas vencem
     * 0 Empate
     * -39 Pretas vencem
     *
     * @return valor das peças no tabuleiro
     */
    public int avalia() {
        int valorBrancas = 0;
        int valorPretas = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca peca = matriz[i][j];
                if (peca != null) {
                    if (peca.getCor() == CorPeca.BRANCA) {
                        valorBrancas += peca.getTipo().getValor();
                    } else {
                        valorPretas += peca.getTipo().getValor();
                    }

                }
            }
        }
        return valorBrancas - valorPretas;
    }

    /**
     * Métodos auxiliares
     */
    // Coloca todas as peças Brancas
    public void tabuleiroBrancas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    matriz[i][j] = new Peca(TipoPeca.PEAO, CorPeca.BRANCA);
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        matriz[i][j] = new Peca(TipoPeca.TORRE, CorPeca.BRANCA);
                    } else if (j == 1 || j == 6) {
                        matriz[i][j] = new Peca(TipoPeca.VALETE, CorPeca.BRANCA);
                    } else if (j == 2 || j == 5) {
                        matriz[i][j] = new Peca(TipoPeca.BISPO, CorPeca.BRANCA);
                    } else if (j == 3) {
                        matriz[i][j] = new Peca(TipoPeca.DAMA, CorPeca.BRANCA);
                    } else {
                        matriz[i][j] = new Peca(TipoPeca.REI, CorPeca.BRANCA);
                    }
                } else {
                    matriz[i][j] = null; // Casas vazias
                }
            }
        }
    }

    // Coloca todas as peças Pretas
    public void tabuleiroPretas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 6) {
                    matriz[i][j] = new Peca(TipoPeca.PEAO, CorPeca.PRETA);
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        matriz[i][j] = new Peca(TipoPeca.TORRE, CorPeca.PRETA);
                    } else if (j == 1 || j == 6) {
                        matriz[i][j] = new Peca(TipoPeca.VALETE, CorPeca.PRETA);
                    } else if (j == 2 || j == 5) {
                        matriz[i][j] = new Peca(TipoPeca.BISPO, CorPeca.PRETA);
                    } else if (j == 3) {
                        matriz[i][j] = new Peca(TipoPeca.DAMA, CorPeca.PRETA);
                    } else {
                        matriz[i][j] = new Peca(TipoPeca.REI, CorPeca.PRETA);
                    }
                } else {
                    matriz[i][j] = null; // Casas vazias
                }
            }
        }
    }

    // Coloca todas as peças
    public void tabuleiroTodasPecas() {
       tabuleiroBrancas();
       tabuleiroPretas();
    }
}

