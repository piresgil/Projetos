import model.*;
import model.Administrativo;
import model.Informatico;

public class Main {
    /*
     * Considera que numa universidade, existe um quadro de pessoal dividido em dois
     * grupos:
     *
     * Pessoal de Administração e Serviços (PAS): no pessoal de administração
     * encontra-se todo o pessoal que desempenha trabalhos administrativos ou de
     * gestão de algum tipo de serviço. Neste caso, por simplicidade, apenas vamos
     * considerar que existe pessoal administrativo e pessoal informático.
     *
     * Pessoal Docente Investigador (PDI): pessoal que se dedica ao ensino e à
     * investigação no qual incluímos os professores e os investigadores contratados
     * para algum projeto de investigação.
     * Todo o pessoal identifica-se com o seu nome e CC, e recebe um salário mensal que
     * devemos calcular, de forma simplificada, considerando o número de horas de
     * trabalho por semana multiplicado pelo valor/hora da sua categoria e pelo número de
     * semanas por mês (4). Os dados de cada tipo de pessoal são os seguintes (as
     * quantidades não são reais):
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");
        Pessoal p1 = new Administrativo("10000", "Francisca", 1);
        Pessoal p2 = new Informatico("10001", "Daniel", 0);
        Pessoal p3 = new Professor("10002", "Elisa", 5);
        Pessoal p4 = new Investigador("10003", "Bernardo");


        Pessoal[] pessoal = new Pessoal[]{p1, p2, p3, p4};

        Universidade.imprimirNominas(pessoal);
        System.out.println("Saldo Total com o pessoal: " + Universidade.obterOrcamentoTotal(pessoal) + " €");
    }
}