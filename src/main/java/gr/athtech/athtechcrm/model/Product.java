package gr.athtech.athtechcrm.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private int quantity;

    @OneToMany(mappedBy = "product")
    private List<BasketProduct> basketProducts;
}
