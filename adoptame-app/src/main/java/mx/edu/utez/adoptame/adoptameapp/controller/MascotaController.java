package mx.edu.utez.adoptame.adoptameapp.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import mx.edu.utez.adoptame.adoptameapp.service.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.edu.utez.adoptame.adoptameapp.model.Mascota;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotaController {

	@Autowired
	private MascotaServiceImpl mascotaService;

	@GetMapping(value = { "/mostrarMascotas/{tipoMascota}", "/mostrarMascotas/{tipoMascota}/{disponibleAdopcion}" })
	public String consultarMascotas(@PathVariable Optional<String> tipoMascota,
			@PathVariable Optional<String> disponibleAdopcion, Model modelo, Mascota mascota,
			BindingResult bindingResult) {
		if (tipoMascota.isPresent()) {
			modelo.addAttribute("mascotas", mascotaService.listarMascotas(tipoMascota.get()));
			modelo.addAttribute("filtrado", false);
		}
		if (disponibleAdopcion.isPresent()) {
			boolean filtrado = Boolean.parseBoolean(disponibleAdopcion.get());
			if (filtrado) {
				modelo.addAttribute("mascotas", mascotaService.disponiblesAdopcion(tipoMascota.get()));
				modelo.addAttribute("filtrado", true);
			}
		}
		String mascotas = tipoMascota.get();
		switch (mascotas) {
		case "perro":
			modelo.addAttribute("tipoMascota", "perro");
			return "mascotas/perros";
		case "gato":
			modelo.addAttribute("tipoMascota", "gato");
			return "mascotas/gatos";
		case "todos":
			modelo.addAttribute("tipoMascota", "todos");
			return "mascotas/inicio";
		}
		return "mascotas/inicio";
	}

	@PostMapping(value = "/guardarMascota")
	public String guardarMascota(Mascota mascota, BindingResult bindingResult, Model modelo,
			RedirectAttributes redirect) {

		if (bindingResult.hasErrors()) {
			System.out.println("HAY ERRORES");
			modelo.addAttribute("mascotas", mascotaService.listarMascotas(mascota.getTipoMascota()));
			System.out.print("Hay errores");
		} else {
			modelo.addAttribute("mascotas", mascotaService.registrarMascotaS(mascota));
			modelo.addAttribute("filtrado", false);
		}
		redirect.addFlashAttribute("msg_success", "Registro Exitoso");

		return "redirect:/mascotas/mostrarMascotas/" + mascota.getTipoMascota();
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
