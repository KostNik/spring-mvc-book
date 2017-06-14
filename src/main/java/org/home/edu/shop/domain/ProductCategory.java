package org.home.edu.shop.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SweetHome on 14.06.2017.
 */
public class ProductCategory {

    private final static String SMARTPHONE = "Smartphone";
    private final static String TABLET = "Tablet";
    private final static String LAPTOP = "Laptop";

    private final static List<String> categories = Arrays.asList(SMARTPHONE, TABLET, LAPTOP);

    public static boolean contains(String category) {
        return categories.contains(category);
    }

    public static List<String> getCategories() {
        return categories;
    }


}