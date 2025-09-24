package model;

import java.math.BigDecimal;

public class Auto {

	private Long id;
	private String marca;
	private String modelo;
	private BigDecimal precioPorDia;
	private boolean disponible = true;

	public Auto(String marca, String modelo, BigDecimal precioPorDia) {
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
	}

	public Auto() {

	}

	public void validar() {
		if (marca == null || marca.isBlank())
			throw new IllegalArgumentException("Marca inválida");
		if (modelo == null || modelo.isBlank())
			throw new IllegalArgumentException("Modelo inválido");
		if (precioPorDia == null)
			throw new IllegalArgumentException("Precio inválido");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getPrecioPorDia() {
		return precioPorDia;
	}

	public void setPrecioPorDia(BigDecimal precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTipo() {
		return "GENERICO";
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precioPorDia=" + precioPorDia
				+ ", disponible=" + disponible + "]";
	}

}
