import genericsClasses.Caixa;
import genericsClasses.Stack;

public class MainGenerics {
    public static void main(String[] args) {
        System.out.println("*** Generics ****");

        Caixa<String> caixa = new Caixa<>("caixa String");
        System.out.println(caixa.getValor());
        String valor = caixa.getValor();
        System.out.println(valor);

        // Wild Card <?>
        Caixa<?> c = new Caixa<>(1);
        System.out.println(c.getValor());
        // String valorC = c.getValor();
        // System.out.println(valorC);

        // Wild Card <?> com extends
        Caixa<? extends Object> c2 = new Caixa<>(2.90);
        System.out.println(c2.getValor());
        // String valorC2 = c2.getValor();
        // System.out.println(valorC2);

        // Class Stack
        Stack<String> stackStrings = new Stack<>();
        stackStrings.push("ola");
        stackStrings.push("ola2");
        System.out.println(stackStrings);
        stackStrings.pop();
        System.out.println(stackStrings);
    }
}