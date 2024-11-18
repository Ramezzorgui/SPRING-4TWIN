package services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.RamezZorgui4twin5.entities.Color;
import tn.esprit.RamezZorgui4twin5.entities.Piste;
import tn.esprit.RamezZorgui4twin5.entities.Skier;
import services.repositories.IPisteRepository;
import services.repositories.ISkierRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PisteServicesImpl implements IPisteServices {
    private final IPisteRepository pisteRepository;
    private final ISkierRepository skierRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> retrieveAll() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public void removePiste(Long numPiste) {
pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> getPisteByColor(Color color) {
        return  pisteRepository.findByColor(color);
    }

    @Override
    public Skier assignSkierToPiste(String fname, String lname, Color color) {
        Skier skier = skierRepository.findByFirstNameAndLastName(fname, lname);
        List<Piste> piste = pisteRepository.findByColor(color);
        for (Piste i : piste) {
                i.getSkiers().add(skier);
            pisteRepository.save(i);
        }

        return skier;

    }
}
