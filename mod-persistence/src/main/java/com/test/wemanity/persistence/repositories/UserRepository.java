package com.test.wemanity.persistence.repositories;

import com.test.wemanity.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JeanDodo on 15/02/2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByPrenomAndNom(String prenom, String nom);
}
