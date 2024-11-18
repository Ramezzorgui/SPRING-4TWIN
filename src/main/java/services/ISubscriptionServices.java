package services;



import tn.esprit.RamezZorgui4twin5.entities.Subscription;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {

    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);

    Subscription retrieveSubscription(Long numSub);

    List<Subscription> retrieveAllSubscription();

    void removeSubscription(Long numSub);

    Set<Subscription> getSubscriptionByType(TypeSubscription type);
}
