import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class M3_Ex1 {
    public static void main(String[] args) {

        // Entrada de dados


        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("*** Bem-vindo ***");
            System.out.println("*** Sistema de dados dos Alunos ***");

            int sair;

            List<Aluno> alunos = new ArrayList<>();

            do {
                System.out.println();
                System.out.println("1.Criar Aluno");
                System.out.println("2.Exibir dados do Aluno");
                System.out.println("0.Sair");
                sair = sc.nextInt();

                if (sair == 1) {
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    System.out.print("Curso: ");
                    String curso = sc.next();
                    System.out.print("Nr Matricula: ");
                    String numeroMatricula = sc.next();
                    Aluno aluno = new Aluno(nome, idade, curso, numeroMatricula);
                    alunos.add(aluno);

                } else if (sair == 2) {
                    for (Aluno aluno : alunos) {
                        System.out.println(aluno);
                    }
                }
            }
            while (sair != 0);
            // System.out.println("*** Sair ***");
        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            sc.close(); // Fecha Scanner
            System.out.println("*** Sair ***");
        }
    }

    /*
     * Class Aluno
     */
    static class Aluno {

        // Atributos da Class
        private String nome;
        private int idade;
        private String curso;
        private String numeroMatricula;

        // Construtores
        public Aluno() {
        }

        public Aluno(String nome, int idade, String curso, String numeroMatricula) {
            this.nome = nome;
            this.idade = idade;
            this.curso = curso;
            this.numeroMatricula = numeroMatricula;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getNumeroMatricula() {
            return numeroMatricula;
        }

        public void setNumeroMatricula(String numeroMatricula) {
            this.numeroMatricula = numeroMatricula;
        }

        // Metodo toString, Mostra dados do aluno na consola
        @Override
        public String toString() {
            return "Nome: " + nome +
                    ", idade: " + idade +
                    ", Curso: " + curso +
                    ", Nr Matricula: " + numeroMatricula;
        }
    }
}