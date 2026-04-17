public class M1_UD03_Ex5 {
    public static void main(String[] args) {
        int x = 3, y = 4;
        System.out.println("*** Bem Vindo ***");
        System.out.println("Função de Ackermann");
        System.out.println("A(" + x + ", " + y + ") = " + ackermann(x, y));
    }

    /**
     * Method Ackermann
     * recursivo com as especificações passadas
     * <p>
     * A função de Ackermann é uma função matemática famosa que demonstra crescimento
     * extremamente rápido e é frequentemente usada em teoria da computação para exemplificar
     * funções totais computáveis que não são primitivas recursivas.
     * <p>
     * Ela é definida de forma recursiva, conforme abaixo:
     * Para os parâmetros A(x, y):
     * 𝐴(0,𝑦)=𝑦+1
     * 𝐴(𝑥,0)=𝐴(𝑥−1,1)
     * A(x,y)=A(x−1,A(x,y−1)), quando x > 0 e y > 0
     * Essa função é conhecida por crescer muito rapidamente.
     * Para valores ligeiramente maiores de x e y, a função de Ackermann
     * leva um número enorme de chamadas recursivas e rapidamente supera a capacidade de memória
     * e profundidade de recursão do computador.
     */
    public static int ackermann(int x, int y) {
        if (x == 0) {
            return y + 1; // 𝐴(0,𝑦)=𝑦+1
        } else if (y == 0) {
            return ackermann(x - 1, 1); // 𝐴(𝑥,0)=𝐴(𝑥−1,1)
        } else {
            return ackermann(x - 1, ackermann(x, y - 1)); // A(x,y)=A(x−1,A(x,y−1))
        }
    }
}