package com.test.wemanity.persistence.services;

import com.test.wemanity.persistence.exceptions.PersistenceException;
import com.test.wemanity.persistence.models.User;
import com.test.wemanity.persistence.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = PersistenceException.class)
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> allUsers() throws PersistenceException {
        return repository.findAll();
    }

    @Override
    public User findById(Integer id) throws PersistenceException {
        return repository.findOne(id);
    }

    @Override
    public User findByEmail(String email) throws PersistenceException {
        return repository.findByEmail(email);
    }

    @Override
    public User findByPrenomAndNom(String prenom, String nom) throws PersistenceException {
        return repository.findByPrenomAndNom(prenom, nom);
    }

    @Override
    public void create(User user) throws PersistenceException {
        if (user.getId() == null && !allUsers().contains(user))
            repository.save(user);
    }

    @Override
    public void update(User user) throws PersistenceException {
        if (user.getId() != null && !allUsers().contains(user)) {
            User use = findById(user.getId());
            if (use != null) {
                use.setNom(user.getNom());
                use.setPrenom(user.getPrenom());
                use.setNationalite(user.getNationalite());
                use.setEmail(user.getEmail());
                use.setMdp(user.getMdp());
                use.setStatutMarital(user.getStatutMarital());
                use.setCivilite(user.getCivilite());
                use.setDdn(user.getDdn());
                repository.save(use);
            }
        }
    }

    @Override
    public void delete(Integer id) throws PersistenceException {
        User user = findById(id);
        if(allUsers().contains(user))
            repository.delete(user);
    }
}

