package tn.esprit.RamezZorgui4twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long numCourse;
     int level;

    @Enumerated(EnumType.STRING)
     TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
     Support support;

     float price;
     int timeSlot;
    @OneToMany(mappedBy = "course")
    Set<Registration> registrations;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
