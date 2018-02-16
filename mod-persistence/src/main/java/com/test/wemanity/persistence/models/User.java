package com.test.wemanity.persistence.models;


import com.test.wemanity.persistence.models.abstracts.AbstractEntity;
import com.test.wemanity.persistence.tools.Civilite;
import com.test.wemanity.persistence.tools.PersistenceTools;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @Enumerated(value = EnumType.STRING)
    private Civilite civilite;

    private String email;

    private String mdp;

    @Transient
    private String mdpRepeat;

    @Transient
    private String repeatMdp;

    private String prenom;

    private String nom;

    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private LocalDate ddn;

    private String nationalite;

    private Boolean statutMarital;

    @Transient
    private int age;

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!email.equalsIgnoreCase(user.email)) {
            return false;
        }

        return nom.equalsIgnoreCase(user.nom) && prenom.equalsIgnoreCase(user.prenom);
    }

    @PrePersist
    private void initPersiste() {
        super.initDatePersistence();
        email = email.trim().toLowerCase();
        mdp = PersistenceTools.hashGuava(mdp);
        prenom = PersistenceTools.capitalize(prenom);
        nom = PersistenceTools.capitalize(nom);
        age = PersistenceTools.calculAge(ddn);
        nationalite = PersistenceTools.capitalize(nationalite);
    }

    @PreUpdate
    @PostLoad
    private void initData() {
        email = email.trim().toLowerCase();
        mdp = PersistenceTools.hashGuava(mdp);
        prenom = PersistenceTools.capitalize(prenom);
        nom = PersistenceTools.capitalize(nom);
        age = PersistenceTools.calculAge(ddn);
        nationalite = PersistenceTools.capitalize(nationalite);
    }
}
