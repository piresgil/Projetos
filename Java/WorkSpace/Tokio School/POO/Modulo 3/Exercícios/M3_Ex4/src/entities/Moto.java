package entities;

public class Moto extends Veiculo{
    protected String tipoMoto;

    public Moto(String marca, int ano, String tipoMoto) {
        super(marca, ano);
        this.tipoMoto = tipoMoto;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(int numeroPortas) {
        this.tipoMoto = tipoMoto;
    }

    @Override
    public void apresentar() {
        System.out.println("Marca: " + marca + ", Ano: " + ano + ", Tipo de Moto: " + tipoMoto);
    }
}
