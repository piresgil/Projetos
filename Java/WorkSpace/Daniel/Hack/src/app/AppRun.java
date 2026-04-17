package app; /**
 * @author Daniel
 * @version 1.0
 */

import controller.*;

public class AppRun {
    /**
     * Method Main
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");
        try {

            FileFolder.criarDiretorios();
            FileFolder.criarFicheiro();

            Thread.sleep(1000);

            Processo.abrirProcesso();

            Texto.converterTexto();
            Texto.escritaInteligente();

            Thread.sleep(1000);
            Texto.mouseMove();

            Processo.fecharProcesso();

            Thread.sleep(1000);
            Texto.mouseMove();

            //FileFolder.apagarFicheiro();
            //FileFolder.apagarDiretorio();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
