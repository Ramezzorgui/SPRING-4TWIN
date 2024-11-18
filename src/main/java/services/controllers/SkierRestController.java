package services.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.RamezZorgui4twin5.entities.Skier;
import services.ISkierServices;
import tn.esprit.RamezZorgui4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
@Tag(name = "Gestion Skier")
@RequiredArgsConstructor
@RequestMapping("skier")
@RestController
public class SkierRestController {

        private final ISkierServices skierServices;

        @PostMapping("/add")
        public Skier saveSkier(@RequestBody Skier skier) {
            return skierServices.addSkier(skier);
        }

        @GetMapping("/get/{numSkier}")
        public Skier getSkier(@PathVariable Long numSkier) {
            return skierServices.retrieveSkier(numSkier);
        }


        @GetMapping("/getAll")
        public List<Skier> getAllSkiers() {
            return skierServices.retrieveAll();
        }


        @PutMapping("/update")
        public Skier updateSkier(@RequestBody Skier skier) {
            return skierServices.updateSkier(skier);
        }


        @DeleteMapping("/delete/{numSkier}")
        public void deleteSkier(@PathVariable Long numSkier) {
            skierServices.removeSkier(numSkier);
        }


        @PutMapping("/assign/{numSkier}/{numPiste}")
        public void assignSkier(@PathVariable Long numSkier, @PathVariable Long numPiste) {
            skierServices.assignSkierToPiste(numSkier, numPiste);
        }

        @GetMapping("/getBy/{firstName}/{lastName}")
        public Skier getByFLname(@PathVariable String firstName, @PathVariable String lastName) {
            return skierServices.getByFirstAndLastName(firstName, lastName);
        }


        @GetMapping("/getBy/{birthDate}")
        public Skier getByBDate(@PathVariable LocalDate birthDate) {
            return skierServices.findByBirthDate(birthDate);
        }


        @GetMapping("/by-subscription")
        public List<Skier> getSkiersBySubscriptionType(@RequestParam TypeSubscription typeSubscription) {
            return skierServices.retrieveSkiersBySubscriptionType(typeSubscription);
        }
    }
