package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.CartInfo;
import uz.pdp.lesson2task2.entity.Product;

import java.util.List;

@Projection(types = CartInfo.class)
public interface CustomCartInfo {

    Integer getId();

    List<Integer> getProducts();

    Integer getCart();
    Integer getQuantity();
}
