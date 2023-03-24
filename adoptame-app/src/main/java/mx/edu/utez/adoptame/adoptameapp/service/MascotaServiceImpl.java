package mx.edu.utez.adoptame.adoptameapp.service;

import mx.edu.utez.adoptame.adoptameapp.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {
    List<Mascota> listaMascotas = new LinkedList<>();

    public MascotaServiceImpl(){
    llenarLista();
}

    public void llenarLista(){
        listaMascotas.add(new Mascota("Mosha", 13, "Una perrita muy bonita", "perro", "perrito.jpg", false));
        listaMascotas.add(new Mascota("Georgie", 3, "Gato blanco con manchas negras", "gato", "georgie.jpg", false));
        listaMascotas.add(new Mascota("Blondie", 12, "Perrita de color blanco", "perro", "imagedog.jpeg", true));
        listaMascotas.add(new Mascota("Petite", 1, "Gata complemtamente blanca", "gato", "petite.jpg", true));
        listaMascotas.add(new Mascota("Cachirulo", 3, "Perrito con orejas largas", "perro", "cachirulo.jpg", false));
        listaMascotas.add(new Mascota("Garfield", 15, "Gato naranja y gordito", "gato", "garfield.jpg", false));
        listaMascotas.add(new Mascota("Puca", 5, "Perrita grande de color negro", "perro", "puca.jpg", true));
        listaMascotas.add(new Mascota("Persa", 2, "Gata cafe claro", "gato", "persa.jpg", true));
    }

    @Override
    public List<Mascota> listarMascotas(String tipo) {
        List<Mascota> especie = new LinkedList<>();
        if (tipo.equals("todos")){
            return listaMascotas;
        }
        for (Mascota mascota : listaMascotas) {
            if (mascota.getTipoMascota().equals(tipo)){
                especie.add(mascota);
            }
        }
        return especie;
    }

    @Override
    public List<Mascota> disponiblesAdopcion(String tipoMascota) {
        List<Mascota> disponible = new LinkedList<>();
        if (tipoMascota.equals("todos")){
            for (Mascota mascota: listaMascotas) {
                if (mascota.isDisponibleAdopcion()){
                    disponible.add(mascota);
                }
            }
        }else{
            for (Mascota mascota: listaMascotas) {
                if (mascota.getTipoMascota().equals(tipoMascota) && mascota.isDisponibleAdopcion()){
                    disponible.add(mascota);
                }
            }
        }

        return disponible;
    }


    @Override
    public boolean registrarMascota(Mascota mascota) {
        try{
            listaMascotas.add(mascota);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Mascota> registrarMascotaS(Mascota mascota) {
        try{
            listaMascotas.add(mascota);
            List<Mascota> nuevasMascotas = listarMascotas(mascota.getTipoMascota());
            return nuevasMascotas;
        }catch (Exception e){
            System.out.println("ERROR AL INSERTAR UNA NUEVA MASCOTA");
            return listaMascotas;
        }
    }

}
