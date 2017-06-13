package org.home.edu.shop.controller;

import org.home.edu.shop.domain.Customer;
import org.home.edu.shop.domain.Product;
import org.home.edu.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Controller
public class CustomerController {

    private static final String REDIRECT = "redirect:";

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String allCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping(value = "customers/add", method = RequestMethod.GET)
    public String getAllNewProductForm(Model model) {
        Customer newCustomer = new Customer();
        model.addAttribute("newCustomer", newCustomer);
        return "addCustomer";
    }

    @RequestMapping(value = "customers/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newCustomer") Customer customer, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        customerService.addCustomer(customer);
        return REDIRECT + "/customers";
    }

    @InitBinder
    private void initializeBinder(WebDataBinder binder) {
        binder.setAllowedFields("customerId", "name", "address");
    }


}
