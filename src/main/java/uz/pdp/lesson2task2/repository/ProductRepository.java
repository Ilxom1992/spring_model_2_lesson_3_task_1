package uz.pdp.lesson2task2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.lesson2task2.entity.Product;
import uz.pdp.lesson2task2.projection.CustomProduct;

import java.util.List;

@RepositoryRestResource(path = "product", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @RestResource(path = "name")
    Page<Product> findByNameStartsWith(@Param("name") String name, Pageable p);

    @RestResource(path = "price")
    List<Product> findAllByPriceBetween(@Param("min") Double min, @Param("max") Double max);

    @RestResource(path = "description")
    Page<Product> findAllByDescriptionStartingWith(@Param("desc") String description, Pageable pageable);

    @RestResource(path = "category")
    Page<Product> findAllByCategoryId(@Param("id") Integer category_id, Pageable pageable);
}
