package model;

import model.interfaces.CharSequenceTokio;

public class ArrayCharSequenceTokio implements CharSequenceTokio {
    private char[] array;

    public ArrayCharSequenceTokio(char[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return array[index];
    }

    /**
     * Devolve uma nova CharSequenceTokio que é uma subsequencia da propria
     * sequencia.
     * A subsequencia começa no caracter situado na posição start e acaba no
     * caracter
     * no caracter situado na posição end -1.
     * Se start == end devolve CharSequenceTokio sem caracteres.
     * Se start não é uma posição válida ou se end não é uma posição válida ou se
     * start > end devolve um objeto nulo (null).
     *
     * @param start É o indice de começo, incluido.
     * @param end   É o indice de fim, exlcuido.
     * @return A subsequencia especifica ou null se os indices não são validos.
     */
    @Override
    public CharSequenceTokio subSequence(int start, int end) {
        if (start < 0 || end > array.length || start > end) {
            return null; // Índices inválidos
        }

        char[] newArray = new char[end - start];
        for (int i = start; i < end; i++) {
            newArray[i - start] = array[i];
        }
        /*
         * char[] subArray = new char[end - start];
         * System.arraycopy(array, start, subArray, 0, end - start);
         */
        return new ArrayCharSequenceTokio(newArray);
    }

    @Override
    public String toString() {
        return String.valueOf(array);
    }
}
