package com.thoa.englishTutor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity()
@Table(name = "medias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
}
