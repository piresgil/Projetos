/*
Utilize uma estrutura de repetição (por exemplo, um loop while) para permitir que o jogador
continue a tomar decisões até alcançar o resultado final.
 */

import java.util.Scanner;

public class M2_Ex5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*** Ben-vindo ***");
        System.out.println("*** Aventura ***");
        System.out.println("...---*** Depois de uma longa viagem, chegou há ilha Perdida, na qual parece haver um tesouro escondido...");
        System.out.println("...existem muitos perigos, e obstaculos, nesta ilha completamente desconhecida!!!");

        int res; // variavel para respostas Menu/Sair

        do {
            /*
             * Loop Menu/Sair
             */

            System.out.println();
            //System.out.println("Escolha uma opção, Sair(s)");
            System.out.println("1. Seguir para a Montanha!");
            System.out.println("2. Seguir pela Praia!");
            System.out.println("3. Seguir para a Floresta!");
            System.out.println("4. Seguir pela Ponte!");
            System.out.println("0. Sair!");

            res = sc.nextInt(); // Resposta ao Menu

            int resposta;    // variavel para respostas dentro do SWITCH

            switch (res) {  // Lê a resposta do Menu
                case 1 -> {
                    do {
                        System.out.println("--- Motanha ---");
                        System.out.println("1.Entrar na Caverna!");
                        System.out.println("2.Entrar na Selva!");
                        System.out.print("0.Voltar! ");
                        resposta = sc.nextInt();   // variavel para respostas dentro do SWITCH

                        switch (resposta) {

                            case 1 -> {
                                System.out.println("...entrou na caverna escura ...");
                                System.out.println("...não parece haver nada por aqui");
                                System.out.println("*** Falhou ***");
                                System.out.println();
                            }
                            case 2 -> {
                                System.out.println("...entrou na Selva");
                                System.out.println("...não parece haver nada por aqui");
                                System.out.println("*** Falhou ***");
                                System.out.println();
                            }
                        }
                    } while (resposta != 0);
                }
                case 2 -> {
                    do {
                        System.out.println("--- Praia ---");
                        System.out.println("1.Entrar no Pantano!");
                        System.out.println("2.Entrar no Barco abandonado!");
                        System.out.print("0.Voltar! ");
                        resposta = sc.nextInt();   // variavel para respostas dentro do SWITCH
                        switch (resposta) {
                            case 1 -> {
                                System.out.println("...entrou no Pantano");
                                System.out.println("Foi engolido pelas areias movediças");
                                System.out.println("*** Falhou ***");
                                System.out.println();
                            }
                            case 2 -> {
                                System.out.println("...entrou no Barco");
                                System.out.println("Esta tudo destruido, não tem nada por aqui");
                                System.out.println("*** Falhou ***");
                                System.out.println();
                            }
                        }
                    } while (resposta != 0);
                }

                case 3 -> {
                    do {
                        System.out.println("--- Floresta ---");
                        System.out.println("1.Enfrentar Urso Selvagem!");
                        System.out.println("2.Fugir do Urso Selvagem!");
                        System.out.print("0.Voltar! ");
                        resposta = sc.nextInt();   // variavel para respostas dentro do SWITCH

                        switch (resposta) {
                            case 1 -> {
                                System.out.println("...Incrivel voce derrotou o Urso");
                                System.out.println("...---*** Parece reluzir uma caixa ao fundo...");
                                System.out.println("1.Abrir Caixa!");
                                System.out.print("0.Voltar! ");
                                resposta = sc.nextInt();
                                if (resposta == 1) {
                                    System.out.println("**** Parabens ****");
                                    System.out.println("**** Encontrou o Tesouro ****");
                                    System.exit(0);
                                }
                            }
                            case 2 -> {
                                System.out.println("...Conseguiu escapar");
                                System.out.println("mas agora voce esta perdido");
                                System.out.println("*** Falhou ***");
                                System.out.println();
                            }
                        }
                    } while (resposta != 0);
                }
                case 4 -> {
                    do {
                        System.out.println("--- Ponte ---");
                        System.out.println("A ponte parece perigosa e instavel");
                        System.out.println("1.Atravessar Ponte!");
                        System.out.print("0.Voltar! ");
                        resposta = sc.nextInt();   // variavel para respostas dentro do SWITCH

                        System.out.println("...entrou na Ponte");
                        System.out.println("Caiu no penhasco, a ponte não aguentou!");
                        System.out.println("*** Falhou ***");
                        System.out.println();
                    } while (resposta != 0);
                }
            }
        } while (res != 0);
        System.out.println("*** Sair ***");
    }
}
