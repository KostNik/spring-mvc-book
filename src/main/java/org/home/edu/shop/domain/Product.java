package org.home.edu.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SweetHome on 03.06.2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    @JsonIgnore
    private MultipartFile productImage;
    @JsonIgnore
    private MultipartFile productManual;

    @Pattern(regexp = "P[1-9]+", message = "{Pattern.Product.productId.validation}")
    private String productId;
    @Size(min = 4, max = 50, message = "{Size.Product.name.validation}")
    private String name;
    @Min(value = 0, message = "{Min.Product.unitPrice.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    @NotNull(message = "{NotNull.Product.condition.validation}")
    private String condition;

    @XmlTransient
    public MultipartFile getProductManual() {
        return productManual;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

}
