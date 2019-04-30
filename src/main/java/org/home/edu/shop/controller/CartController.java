package org.home.edu.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SweetHome on 10.07.2017.
 */
@Slf4j
@Controller
@RequestMapping(value = "/cart")
public class CartController {


    @RequestMapping
    public String get(HttpServletRequest request) {
        return "redirect:/cart/" + request.getSession(true).getId();
    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
        log.info("Redirect to /cart/{}", cartId);
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
