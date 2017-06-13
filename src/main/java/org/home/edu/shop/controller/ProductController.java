package org.home.edu.shop.controller;

import org.home.edu.shop.domain.Product;
import org.home.edu.shop.exceptions.NoProductsFoundUnderCategoryException;
import org.home.edu.shop.exceptions.ProductNotFoundException;
import org.home.edu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Controller
@RequestMapping("market")
public class ProductController {

    private static final String REDIRECT = "redirect:";

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products/{category}")
    public String getProductByCategory(Model model, @PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
                                      Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return REDIRECT + "/products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/products/{itemCategory}/{price}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "price") Map<String, List<String>> priceRange
            , @PathVariable("itemCategory") String itemCategory
            , @RequestParam("brand") String brand
            , Model model) {
        model.addAttribute("products", productService.getProductsByFilter(priceRange, itemCategory, brand));
        return "products";
    }

    @RequestMapping("products/filter")
    public String getProductsByFilterCategoryAndMaxPrice(@RequestParam("category") String category, @RequestParam("maxPrice") Long maxPrice, Model model) {
        model.addAttribute("products", productService.getProductsByFilterCategoryAndMaxPrice(category, maxPrice));
        return "products";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.GET)
    public String getAllNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product product
            , BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addProduct";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage = product.getProductImage();
        MultipartFile productManual = product.getProductManual();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDir + "WEB-INF/resources/images/" + product.getProductId() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (productManual != null && !productManual.isEmpty()) {
            try {
                productManual.transferTo(new File(rootDir + "WEB-INF/resources/pdf/" + product.getProductId() + ".pdf"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.addProduct(product);
        return REDIRECT + "/market/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("productNotFound");
        modelAndView.addObject("invalidProductId", exception.getProductId());
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        modelAndView.setViewName("productNotFound");
        return modelAndView;
    }

    @RequestMapping("/products/invalidPromoCode")
    public String invalidPromo() {
        return "invalidPromoCode";
    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setAllowedFields("productId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "condition",
                "productImage",
                "productManual",
                "language");
    }


}
