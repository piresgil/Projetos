package entities;

public class Aluno {

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
