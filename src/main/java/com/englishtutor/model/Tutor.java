package com.englishtutor.model;

import com.englishtutor.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Tutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutor extends Person {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name="SID_customGenerator",strategy = "com.englishtutor.utils.StudentIdGenerator")
    @GeneratedValue(generator = "SID_customGenerator")
    private UUID id;
}
