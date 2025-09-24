package model;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Contrato {

	private Long id;
	private Cliente cliente;
	private Auto auto;
	private LocalDate fechaInicio;
	private LocalDate fechaSalida;
	private int cantidadDias;
	private BigDecimal total;

	public Contrato(Cliente cliente, Auto auto, LocalDate fechaInicio, LocalDate fechaSalida) {
		this.cliente = cliente;
		this.auto = auto;
		this.fechaInicio = fechaInicio;
		this.fechaSalida = fechaSalida;
	}

	public Contrato() {
	}

	public void validar() {
		if (this.getCliente() == null)
			throw new IllegalArgumentException("Cliente no disponible");
		if (this.getAuto() == null)
			throw new IllegalArgumentException("Auto no disponible");
		if (this.getFechaInicio() == null)
			throw new IllegalArgumentException("Fecha entrada no disponible");
		if (this.getFechaSalida() == null)
			throw new IllegalArgumentException("Fecha salida no disponible");

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", cliente=" + cliente + ", auto=" + auto + ", fechaInicio=" + fechaInicio
				+ ", fechaSalida=" + fechaSalida + ", cantidadDias=" + cantidadDias + ", total=" + total + "]";
	}

}
