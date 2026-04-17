package controller; /**
 * @author Daniel
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Processo {
    /**
     * Path
     * <p>
     * Variaveis para path aplicação
     */
    private static final String app = "notepad.exe";
    private static Process processo;
    private static final String explorerEXE = "explorer.exe";
    private static Process processoExplorer;

    /**
     * "Task kill", variaveis para terminal processos
     * <p>
     * A tarefa principal é encerrar um processo específico com o comando "taskkill /F /IM".
     * O parâmetro "/F" força o encerramento do processo e /IM especifica o nome ou o “ID” do processo a ser encerrado.
     * O "/IM" é um parâmetro que especifica o nome da imagem (nome do programa executável)
     * que será usado para encerrar o processo
     */
    private static final String taskkillPath = "taskkill";
    private static final String taskkill_F = "/F";
    private static final String taskkill_IM = "/IM"; //
    /**
     * Cria uma instância da Class "Robot",
     * Responsável pelos eventos, como teclado e rato
     */
    private static Robot robot;

    /**
     * Method Abrir controller.Processo
     * <p>
     * Usando o "Process Builder"
     */
    public static void abrirProcesso() {
        //minimiza todas as janelas para depois maximizar o notepad
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // maximiza notepad, depois de minimizar tudo
        maximiza();

        //mata o explorer, para bloqueio do ecrã
        killExplorer();

        // Abre o processo
        try {
            processo = new ProcessBuilder(app, FileFolder.pathDiretorioFinal + FileFolder.pathFicheiroFinal).start();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        try {
            maximiza();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Kill Explorer
     * <p>
     * encerra o processo do explorer.exe, funciona como suspensão do sistema
     */
    static void killExplorer() {
        // Verifica se o processo está ativo
        try {
            // Comando para fechar o processo explorer.exe
            Process processo = Runtime.getRuntime().exec("taskkill /f /im explorer.exe");
            System.out.println("controller.Processo explorer.exe finalizado.");

            // Se desejar reiniciar o explorer, use:
            // Runtime.getRuntime().exec("explorer.exe");
        } catch (IOException e) {
            System.err.println("Erro ao finalizar o explorer.exe: " + e.getMessage());
        }
    }

    /**
     * Method Fechar controller.Processo
     * <p>
     * (obs: Pode ou não usar o "taskkill", para terminar processos.)
     * No final ainda abre o explorer.exe
     * Sentenças de código para terminar de outra forma, sem usar taskkill
     * processo.destroy();
     * System.out.println("Tentando encerrar o processo normalmente… ");
     * System.out.println("O processo continua ativo. Tentando encerrar forçadamente… ");
     * processo.destroyForcibly(); // Força o encerramento se o processo ainda estiver ativo
     */
    public static void fecharProcesso() {
        // Verifica se o processo está ativo
        try {
            minimiza();
            if (processo.isAlive()) {
                System.out.println("O processo ainda está em execução.");
                // Aguarda alguns segundos antes de encerrar o processo
                Thread.sleep(500);
                // Usa o comando "taskkill" para encerrar o processo pelo nome
                new ProcessBuilder(taskkillPath, taskkill_F, taskkill_IM, app).start();
                Thread.sleep(500);// Espera um tempo para garantir que o comando foi processado
                System.out.println("controller.Processo encerrado com sucesso pelo comando taskkill.");

                // no caso do explorer.exe
                // Se desejar reiniciar o explorer, use:
                Runtime.getRuntime().exec("explorer.exe");
                System.out.println("O processo 'explorer.exe' foi Reiniciado.");

            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Maximizar Janela aplicação
     * <p>
     * Usando "Key Event"
     */
    static void maximiza() {
        try {

            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }

            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SPACE);
            Thread.sleep(250);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_X);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Minimizar Janela aplicação
     * <p>
     * Usando "Key Event"
     */
    static void minimiza() {
        try {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SPACE);
            Thread.sleep(250);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
