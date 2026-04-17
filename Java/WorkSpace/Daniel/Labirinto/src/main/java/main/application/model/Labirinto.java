package main.application.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
public class Labirinto {
    private char[][] mapa;

    private int altura;
    private int largura;
    private Random random = new Random();

    public Labirinto(int linhas, int colunas) {
        this.altura = linhas;
        this.largura = colunas;
        this.mapa = new char[altura][largura];
        //inicializarMapa();
        criarLabirinto();
        gerarLabirintoDFS(0, 0); // Começa a geração do ponto de partida (0, 0)
        colocarSaidaAleatoria(random);
    }

    /**
     * gerarLabirintoDFS(int linha, int coluna)
     * <p>
     * Este método implementa o algoritmo de Busca em Profundidade (Depth-First Search) para gerar os caminhos dentro do labirinto.
     * <p>
     * Como ele funciona:
     * <p>
     * Marcação da célula atual:
     * <p>
     * mapa[linha][coluna] = '.'; Marca a célula atual como um caminho (representado por .). Inicialmente, todas as células do labirinto são paredes (#).
     * Obtenção de vizinhos válidos:
     * <p>
     * List<int[]> vizinhos = getVizinhosValidosParaEscavar(linha, coluna); Chama o método que acabamos de explicar para obter uma lista de vizinhos válidos da célula atual.
     * Aleatorização dos vizinhos:
     * <p>
     * Collections.shuffle(vizinhos); Embaralha a ordem dos vizinhos na lista. Isso é crucial para garantir que o labirinto gerado seja aleatório e diferente a cada execução.
     * Iteração pelos vizinhos:
     * <p>
     * for (int[] vizinho : vizinhos): O código itera por cada vizinho na lista embaralhada.
     * Para cada vizinho:
     * int novaLinha = vizinho[0]; e int novaColuna = vizinho[1]; Extrai as coordenadas do vizinho.
     * Verificação de parede não visitada: if (mapa[novaLinha][novaColuna] == '#'): Verifica se o vizinho ainda é uma parede (#). Isso garante que o algoritmo explore novos caminhos e não revisite caminhos já criados.
     * Escavação da parede intermediária:
     * mapa[linha + (novaLinha - linha) / 2][coluna + (novaColuna - coluna) / 2] = '.'; Se o vizinho for uma parede não visitada, esta linha "escava" a parede entre a célula atual e o vizinho. Como os vizinhos válidos estão a duas células de distância, a célula intermediária representa a parede.
     * Chamada recursiva:
     * gerarLabirintoDFS(novaLinha, novaColuna); Chama o próprio método gerarLabirintoDFS recursivamente, passando as coordenadas do vizinho como a nova célula atual. Isso faz com que o algoritmo se aprofunde no labirinto a partir desse novo vizinho.
     * Retorno implícito: O método não tem um return explícito. A recursão continua até que uma célula não tenha mais vizinhos válidos não visitados. Nesse ponto, a chamada recursiva retorna, e o algoritmo volta para a chamada anterior, explorando outros vizinhos daquela célula.
     *
     * @param linha
     * @param coluna
     */
    private void gerarLabirintoDFS(int linha, int coluna) {
        mapa[linha][coluna] = '.'; // Marca a célula atual como caminho

        List<int[]> vizinhos = getVizinhosValidosParaEscavar(linha, coluna);
        Collections.shuffle(vizinhos);

        for (int[] vizinho : vizinhos) {
            int novaLinha = vizinho[0];
            int novaColuna = vizinho[1];
            if (mapa[novaLinha][novaColuna] == '#') {
                // Escava a parede entre a célula atual e o vizinho
                mapa[linha + (novaLinha - linha) / 2][coluna + (novaColuna - coluna) / 2] = '.';
                gerarLabirintoDFS(novaLinha, novaColuna);
            }
        }
    }

    /**
     * getVizinhosValidosParaEscavar(int linha, int coluna)
     * <p>
     * Este método tem como objetivo encontrar as células vizinhas à célula atual (linha, coluna) que são válidas para serem "escavadas" durante o processo de geração do labirinto usando o algoritmo de Busca em Profundidade (DFS).
     * <p>
     * Como ele funciona:
     * <p>
     * Inicialização:
     * <p>
     * Cria uma lista vazia chamada vizinhos para armazenar as coordenadas dos vizinhos válidos.
     * Define um array bidimensional chamado direcoes. Cada elemento deste array representa uma possível direção para um vizinho:
     * {0, 2}: 2 células para a direita
     * {2, 0}: 2 células para baixo
     * {0, -2}: 2 células para a esquerda
     * {-2, 0}: 2 células para cima A ideia de pular uma célula (2 em vez de 1) é garantir que haja sempre uma parede de separação entre os caminhos gerados.
     * Iteração pelas direções:
     * <p>
     * O código itera por cada uma das quatro direções definidas em direcoes.
     * Para cada direção dir:
     * Calcula as coordenadas do possível vizinho (novaLinha, novaColuna) somando o deslocamento da direção às coordenadas da célula atual.
     * Verificação de validade: A condição if (novaLinha > 0 && novaLinha < altura - 1 && novaColuna > 0 && novaColuna < largura - 1) verifica se o possível vizinho está dentro dos limites do labirinto. As verificações com 1 e -1 nos limites são importantes para evitar que o algoritmo tente acessar células fora da matriz do labirinto, o que causaria um ArrayIndexOutOfBoundsException. Essencialmente, ele garante que o vizinho potencial não esteja na borda do labirinto.
     * Adição de vizinhos válidos:
     * <p>
     * Se o vizinho estiver dentro dos limites, suas coordenadas (novaLinha, novaColuna) são adicionadas à lista vizinhos como um array de dois inteiros (new int[]{novaLinha, novaColuna}).
     * Retorno:
     * <p>
     * Finalmente, o método retorna a lista vizinhos contendo as coordenadas de todos os vizinhos válidos da célula atual.
     * Em resumo, este método encontra os vizinhos da célula atual que estão dentro dos limites do labirinto e que podem ser considerados para a próxima etapa da geração do labirinto pelo DFS.
     *
     * @param linha
     * @param coluna
     * @return
     */
    private List<int[]> getVizinhosValidosParaEscavar(int linha, int coluna) {
        List<int[]> vizinhos = new ArrayList<>();
        int[][] direcoes = {{0, 2}, {2, 0}, {0, -2}, {-2, 0}};

        for (int[] dir : direcoes) {
            int novaLinha = linha + dir[0];
            int novaColuna = coluna + dir[1];
            if (novaLinha > 0 && novaLinha < altura - 1 && novaColuna > 0 && novaColuna < largura - 1) {
                vizinhos.add(new int[]{novaLinha, novaColuna});
            }
        }
        return vizinhos;
    }


    public void resetarLabirinto() {
        //inicializarMapa();
        criarLabirinto();
        gerarLabirintoDFS(0, 0);
        colocarSaidaAleatoria(random);
    }

    // Geração simples de um labirinto
    private void criarLabirinto() {
        // Preencher o labirinto com paredes e caminhos
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (Math.random() < 0.2) {
                    mapa[i][j] = '#';  // Paredes
                } else {
                    mapa[i][j] = '.';  // Caminhos
                }
            }
        }
        // Garantir ponto de partida
        mapa[0][0] = '.';  // Ponto de partida é sempre um caminho«
    }

    // Método para colocar a saída (S) em uma posição aleatória
    private void colocarSaidaAleatoria(Random random) {
        int linha, coluna;

        // Garantir que a saída esteja em uma posição válida (não parede nem início)
        do {
            linha = random.nextInt(altura);
            coluna = random.nextInt(largura);
        } while ((linha == 0 && coluna == 0) || mapa[linha][coluna] == '#');

        mapa[linha][coluna] = 'S';  // Coloca a saída

        // Criar caminho direto entre (0,0) e (linha,coluna)
        int x = 0, y = 0;

        while (x != linha || y != coluna) {
            mapa[x][y] = '.';  // Garante que o caminho está livre

            if (x < linha) {
                x++;
            } else if (x > linha) {
                x--;
            } else if (y < coluna) {
                y++;
            } else if (y > coluna) {
                y--;
            }
        }
    }

    public char getCelula(int x, int y) {
        return mapa[x][y];
    }

    public void setCelula(int x, int y, char valor) {
        mapa[x][y] = valor;
    }

    public boolean ehMovimentoValido(int x, int y) {
        // Verifica se está dentro dos limites
        if (x < 0 || y < 0 || x >= altura || y >= largura) {
            return false;
        }

        char celula = getCelula(x, y);

        // Aqui, '#' é parede — então só podes andar se NÃO for parede
        return celula != '#';
    }

    public void mostrarLabirinto() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
