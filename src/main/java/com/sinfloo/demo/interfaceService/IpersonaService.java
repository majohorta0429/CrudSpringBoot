package com.sinfloo.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sinfloo.demo.modelo.Persona;

public interface IpersonaService {

	// crear el metodo CRUD Create/listar
	public List<Persona> listar();

	public Optional<Persona> listarId(int id);

	public int save(Persona p);

	public void delete(int id);
}
