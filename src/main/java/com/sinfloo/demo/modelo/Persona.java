package com.sinfloo.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "persona") // entidad para crear una tabla con el nombre persona
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String name;

	private String telefono;

	// Crea el constructor
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	// Crea el contructor con los parametros
	public Persona(int id, String name, String telefono) {
		super();
		Id = id;
		this.name = name;
		this.telefono = telefono;
	}

	// Crea los metodos get and set
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
