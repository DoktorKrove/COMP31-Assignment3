package comp31.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="ORDER")

public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ID")
    private Integer orderId;
    @Column(name="PIZZA_NUMBER")
    private Integer pizzaNumber;
    @Column(name="PIZZA_SIZE")
    private String pizzaSize;
    @Column(name="ORDER_TOTAL")
    private String orderTotal;
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    @Column(name="ORDER_DATE")
    private Date orderDate;

   /* @OneToMany(mappedBy = "order")
    private List<Topping> toppings;*/

}