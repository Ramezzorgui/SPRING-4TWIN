package services.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import tn.esprit.RamezZorgui4twin5.entities.Subscription;
import services.ISubscriptionServices;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("subscription")
@RestController
@Service
public class SubscriptionRestController {

    private final ISubscriptionServices subscriptionServices;

    @PostMapping("/add")
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.addSubscription(subscription);
    }

    @GetMapping("/get/{numSubscription}")
    public Subscription getSubscription(@PathVariable Long numSubscription) {
        return subscriptionServices.retrieveSubscription(numSubscription);
    }

    @GetMapping("/getAll")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionServices.retrieveAllSubscription();
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.updateSubscription(subscription);
    }

    @DeleteMapping("/delete/{numSubscription}")
    public void deleteSubscription(@PathVariable Long numSubscription) {
        subscriptionServices.removeSubscription(numSubscription);
    }



    @GetMapping("/by-type")
    public Set<Subscription> getSubscriptionsByType(@RequestParam TypeSubscription type) {

        return subscriptionServices.getSubscriptionByType(type);
    }



}


