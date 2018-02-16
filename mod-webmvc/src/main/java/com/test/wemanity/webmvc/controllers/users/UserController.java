package com.test.wemanity.webmvc.controllers.users;

import com.test.wemanity.persistence.exceptions.PersistenceException;
import com.test.wemanity.persistence.models.User;
import com.test.wemanity.persistence.services.IUserService;
import com.test.wemanity.persistence.tools.Civilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService service;

    private static final String[] PAYS = new String[]{"France", "Belgique", "Italie","Suisse"};

    @GetMapping("liste")
    public String pageListe(Model model) throws PersistenceException{
        model.addAttribute("titre","Liste Utilisateurs");
        model.addAttribute("titrePage","Liste des Utilisateurs");
        model.addAttribute("utilisateurs",service.allUsers());
        return "utilisateur/liste";
    }

    @GetMapping("ajouter")
    public String formAjouter(Model model){
        model.addAttribute("utilisateur", new User());
        model.addAttribute("titre","Page ajouter");
        model.addAttribute("titrePage","Form Utilisateur");
        model.addAttribute("civilite", Civilite.values());
        model.addAttribute("nationalite",PAYS);
        return "utilisateur/ajouter";
    }

    @PostMapping("ajouter")
    public String ajouterUtilisateur(@ModelAttribute User user)throws PersistenceException{
        service.create(user);
        return "redirect:liste";
    }

    @GetMapping("modifier/{id}")
    public String formModifier(@PathVariable Integer id, Model model) throws PersistenceException {
        model.addAttribute("titrePage", "Page Modifier");
        model.addAttribute("titre", "Form Ajouter");
        model.addAttribute("user", service.findById(id));
        model.addAttribute("civilite", Civilite.values());
        model.addAttribute("nationalite", PAYS);
        return "user/ajouter";
    }

    @PostMapping("modifier/{id}")
    public String modifierUtilisateur(@ModelAttribute User user, Model model) throws PersistenceException {
        service.update(user);
        return "redirect:/user/liste";
    }

    @GetMapping("supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable Integer id, Model model)throws PersistenceException{
        service.delete(id);
        return "redirect:/user/liste";
    }
}

