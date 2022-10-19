package uz.developers.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.pcmarket.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    boolean existsByNameAndCategoryId(String name, Integer categoryId);

    boolean existsByCode(String code);
}
