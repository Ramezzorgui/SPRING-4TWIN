package services;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import services.repositories.*;
import tn.esprit.RamezZorgui4twin5.entities.Piste;
import tn.esprit.RamezZorgui4twin5.entities.Skier;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices {


    private final ISkierRepository skierRepository;
    private final IPisteRepository pisteRepository;
    private final ISubscriptionRepository subscriptionRepository;
    private final ICourseRepository courseRepository;
    private final IRegistrationRepository registrationRepository;
    public Skier addSkier(Skier skier){
        return skierRepository.save(skier);
    }



    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skier> retrieveAll() {
        return (List<Skier>) skierRepository.findAll();
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);
    }

    @Override
    public void assignSkierToPiste(Long numSkier, Long numPiste) {

        Skier skier = skierRepository.findById(numSkier)
                .orElse(null);
        Piste piste = pisteRepository.findById(numPiste)
                .orElse(null);

        piste.getSkiers().add(skier);
        pisteRepository.save(piste);
    }

    @Override
    public Skier getByFirstAndLastName(String firstName, String lastName) {
        return skierRepository.findByFirstNameAndLastName(firstName,lastName);
    }


    @Override
    public Skier findByBirthDate(LocalDate birthDate) {
        return skierRepository.findByBirthDate(birthDate);
    }


    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription subscriptionType) {

        return  skierRepository.findBySubscription(subscriptionType);

    }
}
