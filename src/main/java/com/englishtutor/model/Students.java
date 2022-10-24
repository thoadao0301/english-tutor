package com.englishtutor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name="SID_customGenerator",strategy = "com.englishtutor.utils.StudentIdGenerator")
    @GeneratedValue(generator = "SID_customGenerator")
    private UUID id;
}
