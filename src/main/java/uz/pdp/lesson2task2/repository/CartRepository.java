package uz.pdp.lesson2task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.lesson2task2.entity.Cart;
import uz.pdp.lesson2task2.projection.CustomCart;

@RepositoryRestResource(path = "cart", excerptProjection = CustomCart.class)
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
