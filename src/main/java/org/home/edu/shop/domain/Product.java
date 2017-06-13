package org.home.edu.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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

    private String productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
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
