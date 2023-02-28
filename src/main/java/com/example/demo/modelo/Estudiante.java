package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante_p")
public class Estudiante {

	@Id
	@GeneratedValue(generator = "seq_estu", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_estu", sequenceName = "seq_estu")
	@Column(name = "estu_ide")
	private Integer id;

	@Column(name = "estu_nombre_completo")
	private String nombreCompleto;

	@Column(name = "estu_edad")
	private Integer edad;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + "]";
	}

	// Set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
