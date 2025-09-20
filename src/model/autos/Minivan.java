package model.autos;

import java.math.BigDecimal;

import model.Auto;

public class Minivan extends Auto {

	public Minivan(String marca, String modelo, BigDecimal precioPorDia) {
		super(marca, modelo, precioPorDia);
	}

	@Override
	public String getTipo() {
		return "MINIVAN";
	}

}
