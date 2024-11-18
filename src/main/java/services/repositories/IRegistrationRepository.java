package services.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.RamezZorgui4twin5.entities.Registration;

public interface IRegistrationRepository extends CrudRepository<Registration, Long> {

}
