package springboot.desafio.cnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CnbApplication {

	public static void main(String[] args) {
		//System.out.println("\n**** APP Vai Rodar? ****\n");
		SpringApplication.run(CnbApplication.class, args);
		System.out.println("\n**** APP Rolando (Depois do Run)? ****\n"); // Veja se chega aqui
	}

}
