package comp31.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.demo.model.order;

@Repository
public interface OrderRepo extends CrudRepository<order, Integer> {
    List<order> findbyOrderStatus(String orderStatus);
}
