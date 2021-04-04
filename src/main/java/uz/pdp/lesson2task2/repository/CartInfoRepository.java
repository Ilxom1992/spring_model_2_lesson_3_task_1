package uz.pdp.lesson2task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.lesson2task2.entity.CartInfo;
import uz.pdp.lesson2task2.projection.CustomCart;

@RepositoryRestResource(path = "cartInfo", excerptProjection = CustomCart.class)
public interface CartInfoRepository extends JpaRepository<CartInfo, Integer> {
}
