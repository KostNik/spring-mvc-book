package org.home.edu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Nikita_K on 02.06.2017.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String greeting(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "Amazing web store!!1");
        redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
        redirectAttributes.addFlashAttribute("tagline", "Amazzzing web store!");
        return "redirect:/welcome";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
//        model.addAttribute("greeting", "Welcome to Web Store!");
//        model.addAttribute("tagline", "Amazing web store!!1");
//        redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
//        redirectAttributes.addFlashAttribute("tagline", "Amazzzing web store!");
        return "welcome";
    }

}
