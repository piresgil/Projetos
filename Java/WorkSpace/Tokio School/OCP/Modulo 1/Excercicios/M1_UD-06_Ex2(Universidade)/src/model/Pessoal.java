package model;

/**
 * Class Pessoal
 */
public class Pessoal {
    private String cc;
    private String nome;
    private int horasSemana;
    private int valorHora;

    public Pessoal(String cc, String nome, int horasSemana, int valorHora) {
        this.cc = cc;
        this.nome = nome;
        this.horasSemana = horasSemana;
        this.valorHora = valorHora;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    // Método para calcular o salário base mensal
    public int calcularSalarioBase() {
        return getHorasSemana() * getValorHora() * 4; // 4 semanas por mês
    }

    // Método para calcular o salário total (a ser implementado em subclasses)
    public int calcularSalarioTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "cc: " + getCc() +
                ", nome: " + getNome() +
                ", salário: " + calcularSalarioTotal() / 100 + " €"; // conversao de cent para euros
    }
}

