package comp31.demo.repo;



import org.springframework.data.repository.CrudRepository;

import comp31.demo.model.topping;

public interface toppingRepo extends CrudRepository<topping,Integer>{
    
}
