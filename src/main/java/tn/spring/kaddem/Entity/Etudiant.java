package tn.spring.kaddem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Etudiant")
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "etudiants")
    @JsonIgnore
    private Set<Equipe> equipes;
}
