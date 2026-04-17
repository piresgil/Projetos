/**
 * @author Daniel Gil
 */

/**
 * Class cidade
 */
public class Cidade {

    private String nome;
    private String pais;
    private String provincia;
    private int habitantes;

    public Cidade(String nome, String pais, String provincia, int habitantes) {
        this.nome = nome;
        this.pais = pais;
        this.provincia = provincia;
        this.habitantes = habitantes;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public String toString() {
        return nome + ", " + pais;
    }
}
