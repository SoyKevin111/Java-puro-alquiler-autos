package model.autos;

import java.math.BigDecimal;

import model.Auto;

public class Suv extends Auto {

	public Suv(String marca, String modelo, BigDecimal precioPorDia) {
		super(marca, modelo, precioPorDia);
	}

	@Override
	public String getTipo() {
		return "SUV";
	}

}
