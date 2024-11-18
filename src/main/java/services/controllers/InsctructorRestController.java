package services.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.RamezZorgui4twin5.entities.Instructor;

import services.IInstructorServices;

import java.util.List;

@Tag(name = "Gestion Instructor")
@RequiredArgsConstructor
@RequestMapping("instructor")
@RestController
public class InsctructorRestController {
    private final IInstructorServices instructorServices;

    @Operation(description = "Ajouter un Instructor")
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }

    @Operation(description = "Récupérer un Instructor par id")
    @GetMapping("/get/{numInstructor}")
    public Instructor getInstructor(@PathVariable Long numInstructor) {
        return instructorServices.retrieveInstructor(numInstructor);
    }

    @Operation(description = "Récuperer tous les instructors")
    @GetMapping("/get")
    public List<Instructor> getInstructors() {
        return instructorServices.retrieveAll();
    }

    @Operation(description = "Modifier un Instructor")
    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }

    @Operation(description = "Supprimer un Instructor")
    @DeleteMapping("/delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorServices.removeInstructor(numInstructor);

    }

}
