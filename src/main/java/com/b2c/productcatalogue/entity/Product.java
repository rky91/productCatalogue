package com.b2c.productcatalogue.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;
    private String size;
    private Long price;

    @Column(unique = true)
    private String sku;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "COLOR_ID", nullable = false)
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false)
    private ProductCategory category;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SELLER_ID", nullable = false)
    private Seller seller;


}
