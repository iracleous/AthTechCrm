package gr.athtech.athtechcrm.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
}
