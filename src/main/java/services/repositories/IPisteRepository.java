package services.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.RamezZorgui4twin5.entities.Color;
import tn.esprit.RamezZorgui4twin5.entities.Piste;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste, Long> {
    List<Piste> findByColor(Color color);
}
