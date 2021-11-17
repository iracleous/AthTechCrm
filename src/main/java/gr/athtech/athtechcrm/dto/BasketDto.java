package gr.athtech.athtechcrm.dto;

import gr.athtech.athtechcrm.model.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BasketDto {

    private long id;
    private Date dateTime;
    private Status status;

    private String customerName;

    private List<ProductDto> products;
}
