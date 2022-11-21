package tn.spring.kaddem.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Universite")
@Getter
@Setter
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversite")
    private Long idUniversite;
    private String nomUniversite;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
}
