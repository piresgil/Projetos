/**
 * @author Daniel Gil
 */

import model.interfaces.Instrumento;
import model.instrumentos.*;

public class Orquestra {

    Instrumento[] orquestra = new Instrumento[]{
            new Flauta(),
            new Saxofone(),
            new Violino(),
            new ContraBaixo(),
            new Tambor(),
            new Xilofone()
    };

    public void tocar(String nota) {
        for (int i = 0; i < orquestra.length; i++) {
            orquestra[i].tocar(nota);
        }
    }
}
