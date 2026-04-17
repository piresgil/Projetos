package controller; /**
 * @author Daniel
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.KeyEvent;

public class Texto {
    /**
     * controller.Texto a ser digitado automáticamente
     */

    //static String texto = "01000100 01100001 01101110 01101001 01100101 01101100 \n";

    private static String texto = """
            
            
            O Clube de Futebol Os Belenenses, conhecido como Belenenses, foi fundado a 23 de setembro de 1919 em Lisboa por um grupo de amigos liderados por Artur Jose Pereira, um antigo jogador do futebol portugues.\s
            Com o objetivo de criar um clube forte que representasse o bairro de Belem,
            o Belenenses rapidamente conquistou uma base de apoio local e tornou-se uma referencia no futebol portugues.
            
            Nos seus primeiros anos, o clube destacou-se no panorama desportivo nacional e em 1946 tornou-se o primeiro clube portugues fora dos ditos tres grandes a vencer o Campeonato Nacional,\s
            uma conquista historica que marcou o apogeu do clube. O Belenenses continuou a ser uma presenca regular nos principais campeonatos e torneios de futebol em Portugal ao longo das decadas seguintes.
            
            O clube tambem possui uma forte tradicao em outras modalidades, incluindo o rugby, o andebol e o atletismo, conquistando inumeros titulos e formando atletas de destaque.\s
            A equipa de rugby do Belenenses, em particular, e uma das mais vitoriosas em Portugal.
            
            Com uma base de adeptos dedicada e fiel, o Belenenses viveu momentos complexos nos ultimos anos, com uma divisao interna que levou a criacao de duas entidades com o mesmo nome e simbolo.\s
            No entanto, o espirito e a tradicao do clube permanecem vivos entre os adeptos e o Belenenses continua a ser um simbolo importante para o desporto portugues e para o bairro de Belem,
            representando dedicacao, historia e paixao pelo futebol e pelo desporto..""";

/*
    private static String texto = """
            
            O Sport Lisboa e Benfica, conhecido simplesmente como Benfica, foi fundado a 28 de fevereiro de 1904 em Lisboa por um grupo de jovens, incluindo Cosme Damiao, 
            que se tornaria um dos grandes impulsionadores do clube. Inicialmente, o clube foi chamado de Sport Lisboa e as suas primeiras atividades focavam-se no futebol, 
            que rapidamente ganhou popularidade.
            
            O clube passou por varias fases de crescimento e, em 1908, uniu-se ao Grupo Sport Benfica, formando o Sport Lisboa e Benfica,
            que manteve a aguia como simbolo e o vermelho como cor principal.
            
            Com o tempo, o Benfica tornou-se uma referencia no futebol portugues e europeu, conquistando inumeros campeonatos nacionais e internacionais. 
            Na decada de 1960, o clube viveu um dos periodos mais gloriosos da sua historia, especialmente apos a chegada do lendario jogador Eusebio da Silva Ferreira. 
            O Benfica ganhou duas Tacas dos Campeoes Europeus em 1961 e 1962, consolidando-se como um dos maiores clubes de futebol da Europa.
            
            Alem do futebol, o Benfica e uma potencia em outras modalidades, como o basquetebol, voleibol e hoquei em patins. Hoje,
            com milhoes de adeptos, o clube orgulha-se da sua rica historia e do seu contributo para o desporto,
            sendo um simbolo de paixao e dedicacao para os seus fas em Portugal e no mundo.""";

 */

    /**
     * Cria uma instância da Class "Robot",
     * Responsável pelos eventos, como teclado e rato
     */
    private static Robot robot;

    /**
     * Method Escrita Inteligente
     * <p>
     * Usa Key Event para monitorizar teclas do teclado e escreve num documento de texto
     * se este estiver aberto
     */
    public static void escritaInteligente() {
        System.out.println("A Escrever no ficheiro...");
        try {

            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }

            // Pausa breve para evitar sobrecarga do sistema
            Thread.sleep(1000);
            //converte controller.Texto em minúsculas e remove caracteres não alfabéticos
            texto = converterTexto();
            // EVENTO de Escrita
            for (char caracter : texto.toCharArray()) {

                //Movimento do rato
                mouseMove();

                // Verifica se o character é uma letra ou número
                if (Character.isUpperCase(caracter)) {
                    robot.keyPress(KeyEvent.VK_SHIFT); // Pressiona Shift para letras maiúsculas
                }
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(caracter));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(caracter));

                if (Character.isUpperCase(caracter)) {
                    robot.keyRelease(KeyEvent.VK_SHIFT); // Libera Shift
                }
                // Espera um pouco entre as teclas
                Thread.sleep(20);
            }
            //dar tempo até começar a apagar o text
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Escrita concluída");


        /**
         * Apaga controller.Texto
         * assim que termina de o escrever
         */
        //apagarTexto();
    }

    /**
     * Method Converter controller.Texto
     * <p>
     * Usando "Key Event"
     */
    public static String converterTexto() {
        String text = texto;
        // converter texto em minuscúlas e remove todos os caracteres não alfabéticos
        StringBuilder stb = new StringBuilder();
        for (char letra : text.toLowerCase().toCharArray()) {
            if (letra >= 'a' && letra <= 'z'
                    || letra >= '0' && letra <= '9'
                    || letra == '-' || letra == ' '
                    || letra == '.' || letra == '\n'
                    || letra == ',' || letra == '_'
                    || letra == '\\' || letra == '/'
                    || letra == '|') {
                stb.append(letra);
            }
        }
        return stb.toString();
    }

    /**
     * Method Apagar controller.Texto (Notepad)
     * <p>
     * Usando "Key Event"
     */
    static void apagarTexto() {
        String text = texto;
        try {
            System.out.println("A apagar controller.Texto...");
            for (char c : text.toCharArray()) {

                // movimento do rato
                mouseMove();

                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                Thread.sleep(10);
            }
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(20);
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
            guardar();
            // Guarda eespera um pouco
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Guardar Documento\Ficheiro (Notepad)
     * <p>
     * Usando "Key Event"
     */
    static void guardar() {
        try {
            mouseMove();
            System.out.println("Concluído, a Guardar...");
            Thread.sleep(50);
            // Guardar documento
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_G); // Guarda documento
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mouseMove() {
        robot.mouseMove(500, 50);
        robot.mouseMove(50, 1000);
        robot.mouseMove(1000, 500);
    }
}