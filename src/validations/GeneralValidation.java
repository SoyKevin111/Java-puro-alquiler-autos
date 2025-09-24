package validations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Function;

public class GeneralValidation {

	private Scanner sc;

	public GeneralValidation(Scanner sc) {
		this.sc = sc;
	}

	public <T> T validar(String valor, Function<String, T> parser, String errorMsg) {
		while (true) {
			try {
				return parser.apply(valor);
			} catch (Exception e) {
				System.out.print(errorMsg + ": ");
				valor = sc.nextLine().trim();
			}
		}
	}

	public int validarInt(String valor) {
		return validar(valor, Integer::parseInt, "Error, ingrese un número entero");
	}

	public Double validarDouble(String valor) {
		return validar(valor, Double::parseDouble, "Error, ingrese un número decimal o entero");
	}

	public BigDecimal validarBigDecimal(String valor) {
		return validar(valor, BigDecimal::new, "Error, ingrese un número decimal");
	}

	public Long validarLong(String valor) {
		return validar(valor, Long::parseLong, "Error, ingrese un ID");
	}

	public LocalDate validarLocalDate(String valor) {
		return validar(valor, v -> LocalDate.parse(v, DateTimeFormatter.ISO_LOCAL_DATE),
				"Error, ingrese una fecha en formato yyyy-MM-dd");
	}
}
