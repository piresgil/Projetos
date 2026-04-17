/*
 *  @ Daniel Gil
 */

package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

	// Generic -> parametriza um obj, pode ser qualquer tipo
	// (<T>)-> pode ser qualquer obj
	private List<T> list = new ArrayList<>();

	public void addValue(T value) {// tipo <T> Parametrizado
		list.add(value);
	}

	public T first() {// tipo <T> Parametrizado
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return list.get(0); // imprime o elemento na pos (0) 1º elemento
	}

	public void print() {
		System.out.print("[");
		if (!list.isEmpty()) {
			System.out.print(list.get(0)); // imprime 1º elemento
		}
		for (int i = 1; i < list.size(); i++) { // imprime a virgula com os restantes elementos
			System.out.print(", " + list.get(i));
		}
		System.out.println("]");
	}
}