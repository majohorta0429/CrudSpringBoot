package com.sinfloo.demo.controler;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinfloo.demo.interfaceService.IpersonaService;
import com.sinfloo.demo.modelo.Persona;

//Escribir las anotaciones correspondientes
@Controller
@RequestMapping
public class Controlador {

	// para implementar este metodo se debe crear la variable
	@Autowired
	private IpersonaService service;

	// crear el metodo listar
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona> personas = service.listar();
		// metodo para enviar toda la lista del obajeto al formulario
		model.addAttribute("personas", personas);
		return "index";
	}

	// crear el metodo agregar

	@GetMapping("/new")
	public String agregar(Model model) {

		// crear un nuevo metodo para que el usuario presione muestre el fomulario de
		// persona
		model.addAttribute("persona", new Persona());
		return "form";
	}

	// crear nuevo metodo para guardar
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		service.save(p);
		return "redirec:/listar";
	}

	// crear nuevo metodo para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
