package comp31.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.demo.model.topping;

public interface ToppingRepo extends CrudRepository<topping,Integer>
{
    List<topping> findAll();
    List<topping> findByToppingId(Integer toppingId);
}
