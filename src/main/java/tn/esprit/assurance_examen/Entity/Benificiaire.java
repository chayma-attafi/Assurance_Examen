package tn.esprit.assurance_examen.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Benificiaire")
public class Benificiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBenificiaire")
    Integer idBenificiaire;
    int cin;
    String nom,prenom,profession;
    float slaire;

    //fetch = FetchType.EAGER : assuranceList collection along with the Benificiaire entity whenever it is queried.

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "benificiaire", fetch = FetchType.EAGER)
    List<Assurance> assuranceList = new ArrayList<>();

}
