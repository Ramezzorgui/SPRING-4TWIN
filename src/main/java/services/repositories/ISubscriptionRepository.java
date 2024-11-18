package services.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.RamezZorgui4twin5.entities.Subscription;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.util.Set;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubscription(TypeSubscription typeSubscription);



    Set<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription typeSub);

}
