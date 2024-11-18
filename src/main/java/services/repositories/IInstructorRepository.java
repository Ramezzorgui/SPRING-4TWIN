package services.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.RamezZorgui4twin5.entities.Instructor;

public interface IInstructorRepository extends CrudRepository<Instructor, Long> {
}
