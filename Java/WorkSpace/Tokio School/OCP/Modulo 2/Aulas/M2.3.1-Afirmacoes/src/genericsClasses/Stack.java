package genericsClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {

    private List<T> listaValores = new ArrayList<>();

    public T push(T valor) {
        this.listaValores.add(valor);
        return valor;
    }

    public T pop() {
        int i = listaValores.size();
        return listaValores.remove(i - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(listaValores.toArray());
    }
}
