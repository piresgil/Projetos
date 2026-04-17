/*
 *  @ Daniel Gil
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationService;

public class Program {
	/*
	 * 
	 */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		String path = "C:\\temp\\in2.txt"; // caminho do arquivo

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// leitura da 1ª linha do aquivo
			String line = br.readLine();
			while (line != null) { // leitura das linhas enquanto houver
				String[] fields = line.split(","); // separa por virgula
				// instancia o producto com o recorte da string
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			// Operação estatica
			Product x = CalculationService.max(list);
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}