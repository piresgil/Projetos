package model.funcionarios;

import model.Entidade;
import model.enuns.Turno;

/**
 * Class Funcionario,
 * herda de Entidade
 */
public class Funcionario extends Entidade {
    private int numeroSegurancaSocial;
    private double salario = 0;
    private Enum turno;


    /**
     * Constructor,
     * corre o method Obter Salario para calcular o salario devido ha condição
     */
    public Funcionario(String nome, String apelido, int numeroId, String morada, int telefone, int numeroSegurancaSocial, double salario, Enum turno) {
        super(nome, apelido, numeroId, morada, telefone);
        this.numeroSegurancaSocial = numeroSegurancaSocial;
        this.salario = salario;
        this.turno = turno;
        obterSalario();
    }

    public int getNumeroSegurancaSocial() {
        return numeroSegurancaSocial;
    }

    public void setNumeroSegurancaSocial(int numeroSegurancaSocial) {
        this.numeroSegurancaSocial = numeroSegurancaSocial;
    }

    public Enum getTurno() {
        return turno;
    }

    public void setTurno(Enum turno) {
        this.turno = turno;

    }

    /**
     * Method Obter Salario
     * logica para calcular salario
     */
    public double obterSalario() {
        if (turno == Turno.NOITE) {
            this.salario += 150.0;
        }
        return this.salario;
    }

    @Override
    public String toString() {
        return "Funcionario: " + super.toString() +
                " {SS: " + numeroSegurancaSocial +
                ", Salario: " + salario +
                ", turno: " + turno +
                '}';
    }
}
