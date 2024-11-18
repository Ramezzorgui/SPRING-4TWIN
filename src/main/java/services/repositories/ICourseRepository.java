package services.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.RamezZorgui4twin5.entities.Course;

public interface ICourseRepository extends CrudRepository<Course, Long> {
}
