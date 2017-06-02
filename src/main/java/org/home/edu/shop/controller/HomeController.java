package org.home.edu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nikita_K on 02.06.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "Amazing web store!!1");
        return "welcome";
    }

}
