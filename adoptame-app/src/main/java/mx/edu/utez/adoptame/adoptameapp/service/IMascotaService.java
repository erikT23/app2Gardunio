package mx.edu.utez.adoptame.adoptameapp.service;

import mx.edu.utez.adoptame.adoptameapp.model.Mascota;

import java.util.List;

public interface IMascotaService {

    List<Mascota> listarMascotas(String tipo);

    boolean registrarMascota(Mascota mascota);

    List<Mascota> registrarMascotaS(Mascota mascota);

    List<Mascota> disponiblesAdopcion(String tipoMascota);


}
