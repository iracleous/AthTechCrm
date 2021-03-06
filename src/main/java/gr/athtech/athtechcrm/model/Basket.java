package gr.athtech.athtechcrm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dateTime;
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "basket")
   private List<BasketProduct> basketProducts;

}
