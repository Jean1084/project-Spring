package com.test.wemanity.webmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String pageAccueil(Model model){
        model.addAttribute("titre","Page Accueil");
        return "accueil";
    }
}
