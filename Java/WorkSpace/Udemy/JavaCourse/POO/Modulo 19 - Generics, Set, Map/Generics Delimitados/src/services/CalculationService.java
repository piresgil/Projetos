/*
 *  @ Daniel Gil
 */

package services;

import java.util.List;

public class CalculationService {
	/*
	 * Method estatico nao precisa ser instanciado,
	 * qualquer tipo <T> que extends comparable(porque vai precisar comparar para
	 * achar o maximo)
	 * recebendo uma lista desse mesmo tipo
	 * 
	 * Declaração mais completa (tipos curinga):
	 * public static <T extends Comparable<? super T>> T max(List<T> list) {
	 */
	public static <T extends Comparable<T>> T max(List<T> list) {

		if (list.isEmpty()) {// tratatamento da excepiton
			throw new IllegalStateException("List can't be empty");
		}
		// armazena o valor maximo e compara com os outros da lista, e actualiza valor
		// caso encontre um valor maior
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
}