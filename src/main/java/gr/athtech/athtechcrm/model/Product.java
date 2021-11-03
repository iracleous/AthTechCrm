package gr.athtech.athtechcrm.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Data

public class Product {


    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;

}
