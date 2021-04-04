package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Cart;
import uz.pdp.lesson2task2.entity.User;

import java.sql.Date;

@Projection(types = Cart.class)
public interface CustomCart {

    Integer getId();
    User getCustomer();
    Date getCreatedDate();
}
