package comp31.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name="TOPPING")    

public class topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TOPPING_ID")
    private Integer toppingId;
    @Column(name="TOPPING_NAME")
    private String toppingName;
    @Column(name="TOPPING_PRICE")
    private String toppingPrice;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private User orderId;

    
}
