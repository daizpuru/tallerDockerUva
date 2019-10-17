package com.example.tallerDockerUva;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/alumnos")
public class ControladorBase {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@GetMapping(path = "/todos")
	public @ResponseBody Iterable<Alumnos> getAllAlumnos() {
		Iterable<Alumnos> alumnos = alumnoRepository.findAll();
		return alumnos;
	}

	@PostMapping(path = "/nuevo")
	public @ResponseBody String addNewUser(@RequestParam Integer id, @RequestParam String name,
			@RequestParam String email, @RequestParam String apellido1, @RequestParam String apellido2) {
				
		Alumnos a = new Alumnos();
		a.setId(id);
		a.setNombre(name);
		a.setApellido1(apellido1);
		a.setApellido2(apellido2);
		a.setF_nacimiento(new Date());
		a.setEmail(email);
		alumnoRepository.save(a);
		return "Alumno guardado correctamente";
	}
}
