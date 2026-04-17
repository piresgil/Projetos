package model.funcionarios;

/**
 * Class Sub Contratado
 */
public class SubContratado extends Funcionario {
    private String especialidade;


    public SubContratado(String nome, String apelido, int numeroId, String morada, int telefone,
                         int numeroSegurancaSocial, double salario, Enum turno, String especialidade) {
        super(nome, apelido, numeroId, morada, telefone, numeroSegurancaSocial, salario, turno);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Sub, " + super.toString() + " {especialidade: " + especialidade + "}";
    }
}
