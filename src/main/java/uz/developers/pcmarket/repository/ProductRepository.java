package uz.developers.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.pcmarket.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {



}
