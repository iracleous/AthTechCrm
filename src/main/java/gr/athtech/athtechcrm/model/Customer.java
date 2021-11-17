package gr.athtech.athtechcrm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(indexes = {
        @Index(name = "nameIndex", columnList = "name")
}
)

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;
    @Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "customer")
    private List<Basket> baskets;
}
