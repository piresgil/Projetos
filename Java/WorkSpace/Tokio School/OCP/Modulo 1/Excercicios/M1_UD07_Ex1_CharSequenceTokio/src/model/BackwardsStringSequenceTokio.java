package model;

import model.interfaces.CharSequenceTokio;

public class BackwardsStringSequenceTokio implements CharSequenceTokio {

    private String texto;

    public BackwardsStringSequenceTokio(String texto) {
        //this.texto = new StringBuilder(texto).reverse().toString();
        int left = 0;
        int right = texto.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(texto.charAt(right));
            right--;
        }
        this.texto = sb.toString();
    }

    @Override
    public int length() {
        return texto.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= texto.length()) {
            //return '\0'; // Retorna o char com valor zero
            return '0';
        }
        return texto.charAt(index);
    }

    @Override
    public CharSequenceTokio subSequence(int start, int end) {
        if (start < 0 || end > texto.length() || start > end) {
            return null; // Índices inválidos
        }
        
        String subString = texto.substring(start, end);
        int left = 0;
        int right = subString.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(subString.charAt(right));
            right--;
        }
        return new BackwardsStringSequenceTokio(sb.toString());
        //return new BackwardsStringSequenceTokio(new StringBuilder(subString).reverse().toString());
    }

    @Override
    public String toString() {
        return texto;
    }
}
