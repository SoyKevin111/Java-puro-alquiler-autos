package model.autos;

import java.math.BigDecimal;

import model.Auto;

public class Coupe extends Auto {

	public Coupe(String marca, String modelo, BigDecimal precioPorDia) {
		super(marca, modelo, precioPorDia);
	}

	public Coupe() {
	}

	@Override
	public String getTipo() {
		return "COUPE";
	}

}
