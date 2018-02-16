package com.test.wemanity.persistence.services;

import com.test.wemanity.persistence.PersistenceConfig;
import com.test.wemanity.persistence.models.User;
import com.test.wemanity.persistence.tools.Civilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Test
@ContextConfiguration(classes = PersistenceConfig.class)
public class PersistenceServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private IUserService service;

    @Test
    public void testInjectService(){
        assertNotNull(service);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testAllUsers() throws Exception {
        List<User> user = service.allUsers();
        assertNotNull(user);
        assertEquals(3, user.size());
    }

    @Test(dependsOnMethods = {"testAllUsers"})
    public void testFindById() throws Exception {
        User user = service.findById(2);
        assertNotNull(user);
        assertEquals(user.getAge(), 22);
    }

    @Test(dependsOnMethods = {"testAllUsers"})
    public void testFindByEmail() throws Exception {
        User user = service.findByEmail("jean@wemanity.fr");
        assertNotNull(user);
        assertEquals(user.getPrenom(), "Jean");
    }

    @Test(dependsOnMethods = {"testAllUsers"})
    public void testFindByPrenomAndNom() throws Exception {
        User user = service.findByPrenomAndNom("Jean", "JOSEPH");
        assertNotNull(user);
        assertEquals(user.getAge(), 33);
    }

    @Test
    public void testCreate() throws Exception {
        User user1 = User.builder().
                civilite(Civilite.Monsieur).
                ddn(LocalDate.of(1984, 10, 1)).
                email("jean@wemanity.fr").
                mdp("123456").
                nationalite("Haitienne").
                nom("JOSEPH").
                prenom("Jean").
                statutMarital(true).
                build();
        service.create(user1);

        User user2 = User.builder().
                civilite(Civilite.Madame).
                ddn(LocalDate.of(1995, 9, 29)).
                email("sabrina@wemanity.fr").
                mdp("123456").
                nationalite("française").
                nom("FELIXINE").
                prenom("sabrina").
                statutMarital(false).
                build();
        service.create(user2);

        User user3 = User.builder().
                civilite(Civilite.Madame).
                ddn(LocalDate.of(1980, 5, 9)).
                email("laurent@wemanity.fr").
                mdp("123456").
                nationalite("belge").
                nom("PIERRE").
                prenom("Laurent").
                statutMarital(true).
                build();
        service.create(user3);

    }

    @Test(dependsOnMethods = {"testFindByPrenomAndNom"})
    public void testUpdate() throws Exception {
        User user = service.findByEmail("jean@wemanity.fr");
        user.setPrenom("Mardochée");
        user.setDdn(LocalDate.of(1984, 10, 1));
        service.update(user);
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals(33, user.getAge());
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() throws Exception {
        User user = service.findById(3);
        service.delete(user.getId());
        user = service.findById(3);
        assertNull(user);
    }
}
