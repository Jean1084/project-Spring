package com.test.wemanity.persistence.services;

import com.test.wemanity.persistence.exceptions.PersistenceException;
import com.test.wemanity.persistence.models.User;

import java.util.List;

/**
 * Created by JeanDodo on 15/02/2018.
 */
public interface IUserService {

    List<User> allUsers() throws PersistenceException;

    User findById(Integer id) throws PersistenceException;

    User findByEmail(String email) throws PersistenceException;

    User findByPrenomAndNom(String prenom, String nom) throws PersistenceException;

    void create(User user) throws PersistenceException;

    void update(User user) throws PersistenceException;

    void delete(Integer id) throws PersistenceException;
}
