/* Written By Aman Prajapati */ 

package comp31.demo.model;

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


// CREATE TABLE user
// (
//     userId int PRIMARY KEY AUTO_INCREMENT,
//     userName TEXT,
//     userRole TEXT
// );
@Data
@Entity
@NoArgsConstructor
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Integer userId;
    @Column(name="USER_NAME")
    private String userName;
    @Column(name="USER_ROLE")
    private String userRole ="customer";//Ravneet= Put the value of userRole as customer so every  time the  user enter their data 
    @Column(name="USER_ADDRESS")// Ravneet=for the signup they do not have to select the page to go. It is always customer.
    private String userAddress;
    @OneToMany(mappedBy = "userId")
    private List<order> orders;

    // @Override //ravneet
    // public String toString(){
    //     return "User [username = " + userName + ", userrole"+ userRole + "useraddress"+ userAddress + "]";
    // }
}
