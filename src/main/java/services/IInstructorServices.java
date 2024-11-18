package services;

import tn.esprit.RamezZorgui4twin5.entities.Instructor;


import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor(Instructor instructor);
        Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> retrieveAll();
    void removeInstructor(Long numInstructor);

    Instructor addAndSignToCourses(Instructor ins , List <Long> numCourses );

    Instructor addAndAssignCourses(Instructor ins);

}
