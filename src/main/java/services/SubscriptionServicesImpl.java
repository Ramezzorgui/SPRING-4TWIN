package services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.RamezZorgui4twin5.entities.Subscription;
import services.repositories.ISubscriptionRepository;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {
    private final ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(Long numSub) {
        return subscriptionRepository.findById(numSub).orElse(null);
    }

    @Override
    public List<Subscription> retrieveAllSubscription() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public void removeSubscription(Long numSub) {
        subscriptionRepository.deleteById(numSub);
    }


    @Query("SELECT s FROM Skier s WHERE s.subscription.typeSub = :subscriptionType ORDER BY s.subscription.startDate ASC")
    @Override
    public Set<Subscription> getSubscriptionByType(@Param("subscriptionType") TypeSubscription type) {
        return subscriptionRepository.findByTypeSubscription(type);
    }


    public Set<Subscription> getSubscriptionByTypeOrder(TypeSubscription type) {

        return subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
    }
}
