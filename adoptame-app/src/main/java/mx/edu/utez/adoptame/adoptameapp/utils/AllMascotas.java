package mx.edu.utez.adoptame.adoptameapp.utils;

import mx.edu.utez.adoptame.adoptameapp.model.Mascota;

import java.util.LinkedList;
import java.util.List;

public class AllMascotas {
    public List<Mascota> regresarAllMascotas(){
        List<Mascota> allMascotas = new LinkedList<>();
        allMascotas.add(new Mascota("Mosha", 13, "Una perrita muy bonita", "perro", "perrito.jpg", false));
        allMascotas.add(new Mascota("Georgie", 3, "Gato blanco con manchas negras", "gato", "georgie.jpg", false));
        allMascotas.add(new Mascota("Blondie", 12, "Perrita de color blanco", "perro", "imagedog.jpeg", true));
        allMascotas.add(new Mascota("Petite", 1, "Gata complemtamente blanca", "gato", "petite.jpg", true));
        allMascotas.add(new Mascota("Cachirulo", 3, "Perrito con orejas largas", "perro", "cachirulo.jpg", false));
        allMascotas.add(new Mascota("Garfield", 15, "Gato naranja y gordito", "gato", "garfield.jpg", false));
        allMascotas.add(new Mascota("Puca", 5, "Perrita grande de color negro", "perro", "puca.jpg", true));
        allMascotas.add(new Mascota("Persa", 2, "Gata cafe claro", "gato", "persa.jpg", true));
        return allMascotas;
    }

    public List<Mascota> disponiblesAdopcion(String tipoMascota){
        List<Mascota> allMascotas = regresarAllMascotas();
        List<Mascota> disponible = new LinkedList<>();
        if (tipoMascota.equals("todos")){
            for (Mascota mascota: allMascotas) {
                if (mascota.isDisponibleAdopcion()){
                    disponible.add(mascota);
                }
            }
        }else{
            for (Mascota mascota: allMascotas) {
                if (mascota.getTipoMascota().equals(tipoMascota) && mascota.isDisponibleAdopcion()){
                    disponible.add(mascota);
                }
            }
        }

        return disponible;
    }

    public List<Mascota> tipoMascota(String tipoMascota){
        List<Mascota> allMascotas = regresarAllMascotas();
        List<Mascota> especie = new LinkedList<>();
        if (tipoMascota.equals("todos")){
            return allMascotas;
        }
        for (Mascota mascota : allMascotas) {
            if (mascota.getTipoMascota().equals(tipoMascota)){
                especie.add(mascota);
            }
        }

        return especie;
    }
}
