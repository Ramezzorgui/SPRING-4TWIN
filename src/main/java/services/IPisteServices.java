package services;

import tn.esprit.RamezZorgui4twin5.entities.Color;
import tn.esprit.RamezZorgui4twin5.entities.Piste;
import tn.esprit.RamezZorgui4twin5.entities.Skier;

import java.util.List;

public interface IPisteServices {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(Long numPiste);
    List<Piste> retrieveAll();
    void removePiste(Long numPiste);
    List<Piste> getPisteByColor(Color color);
    Skier assignSkierToPiste(String fname, String lname, Color color);

}
