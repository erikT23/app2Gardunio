package mx.edu.utez.adoptame.adoptameapp.service;

import java.util.LinkedList;
import java.util.List;

import mx.edu.utez.adoptame.adoptameapp.model.Caracter;

public class CaracterServiceImpl implements CaracterService {

	private List<Caracter> lista = null;

	public CaracterServiceImpl() {
		lista = new LinkedList<>();
		lista.add(new Caracter(1, "Activo"));
		lista.add(new Caracter(2, "Independiente"));
		lista.add(new Caracter(3, "Juegueton"));
		lista.add(new Caracter(4, "Protector"));
		lista.add(new Caracter(5, "Ruidoso"));
		lista.add(new Caracter(6, "Timido"));
		lista.add(new Caracter(7, "Tranquilo"));
		lista.add(new Caracter(8, "Amorosi"));

	}

	@Override
	public List<Caracter> listarTodos() {
		return lista;
	}

}
