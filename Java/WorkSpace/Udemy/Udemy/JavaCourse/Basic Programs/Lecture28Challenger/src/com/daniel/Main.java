/**
 * Created by Daniel 14/06/2019
 */
package com.daniel;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Main {

    public static void main(String[] args) {
/**
                //boolean para testar condiçao verdadeiro e falso
                // variavel para score, levelcompreted e bonus
       boolean gameOver = true;
        int score = 800, levelCompleted = 5, bonus = 100;//estas variaveis boolena e int sao criadas apenas no metodo correspondente
                //como atribui valores, sera a ptuaçao do player 1

                //variavel highScore chama metodo criado como calculateSocre, e
                // que irá testar o gameOver e se gameOver for verdadeiro
                // vai fazer os calculos dos valores das variaveis(metodo calculateSocre)
                // levelcompleted e bonus e score ou seja:
                //highScore = score + (levelCompleted * bonus);
        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
                //que serão as pontuçoes do Player 1 (valores em cima)
        System.out.println("Final score: " + highScore);

            //PLAYER 2
                 //chama o metodo CalculateScore
        calculateScore(true, 1000,8,200);
                //pontuçao do player 2
        System.out.println("Your Final Score is: " + highScore);

        //PLAYER 3
        //chama o metodo CalculateScore
       calculateScore(true, 1500,8,200);
        //pontuçao do player 2
       System.out.println("Your Final Score is: " + highScore);

        //PLAYER 4
        //chama o metodo CalculateScore
        calculateScore(true, 100,8,200);
        //pontuçao do player 2
        System.out.println("Your Final Score is: " + highScore);

        //PLAYER 5
        //chama o metodo CalculateScore
        calculateScore(true, 100,8,200);
        //pontuçao do player 2
        System.out.println("Your Final Score is: " + highScore);
 */
        //NEW PLAYER
        //chamando metodos calculascore, dysplayhighscoreposition calculatehighscore atraves de variavel do tipo inteiro
        int highScorePosition = calculateHighScorePosition(1500);
        //chamando metodo dysplayhighposition que lE os dados
        displayHighScorePosition("Rui", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Daniel", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Pires", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Gil", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Patricia", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Gisela", highScorePosition);

        //new player
        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Andre", highScorePosition);
    }

    //criando metodo calculateSore como inteiro que será um calculo
    public static int calculateScore (boolean gameOver, int score, int levelCompleted, int bonus) {
                //declara variaveis necessarias para o calculo e teste
                //ou seja, as variaveis podem ser criadas apenas neste metodo
                //embora neste projecto estejam no metodo MAIN tambem
                //se gameOver for verdadeiro
        if (gameOver) {
                // cria calculo na variavel finalscore do tipo inteiro
            int finalScore = score + (levelCompleted * bonus);
                //feito o calculo como "bonus final" soma 2000 a finalscore
            finalScore += 2000;
                //como tem que retornar um valor do tipo inteiro retorna a variavel do calculo
            return finalScore;
        }
            //saindo do ciclo if, ou com um else, ou entao como não testa mais nada:
        return -1;//return -1 para retornar ao ponto onde foi chamado o IF
    }

// Create a method called displayHighScorePosition
// it should a players name as a parameter, and a 2nd parameter as a position in the high score table
// You should display the players name along with a message like " managed to get into position " and the
// position they got and a further message " on the high score table".
// Create a 2nd method called calculateHighScorePosition
// it should be sent one argument only, the player score
// it should return an in
// the return data should be
// 1 if the score is >=1000
// 2 if the score is >=500 and < 1000
// 3 if the score is >=100 and < 500
// 4 in all other cases
// call both methods and display the results of the following
// a score of 1500, 900, 400 and 50

    //criando metodo calculate dysplay score position, void, porque n vai devolver dados, apenas apresentar/Leitura
    // as variaveis playername e highscoreposition mais os respectivos textos

    public static void displayHighScorePosition(String playerName, int highScorePosition){
        System.out.println(playerName + " managed to get into position: " + highScorePosition + " on the high score table");
    }

    //criando metodo calculate higScore position como inteiro para receber dados nas variavel playername e playerScore

    public static int calculateHighScorePosition(int playerScore) {
            //criar varial para valor 4 para poder retornar o calculo
        int position = 4;
        if (playerScore >= 1000) {
            position = 1; //return 1;
            //para a 2ª position a condiçao:
        }else if (playerScore >= 500){
            position = 2; //return 2;
            //para a 3ª position a condiçao:
        }else if (playerScore >=100){
            position = 3; //return 3;
            //para a 4ª position a condiçao será apenas Else
            //se a 1ª condiçao for falsa salta para a 2ª, se tambem for falsa, vai para a 3ª
            //se a 3ª for falsa tbm, passa para a 4ª, que nao testa nada, e retorna no valor 4
            // }else { mas neste caso utilizei uma variavel (position para retornar nao valor 4)
            // para existam outros testes a testar antes de retornar completamente.
        }return position;
    }
}
