package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Order;
import uz.pdp.lesson2task2.entity.User;

import java.sql.Date;

@Projection(types = Order.class)
public interface CustomOrder {

    Integer getId();

    User getCustomer();

    Date getOrderedDate();

    Date getRequiredDate();

    boolean isStatus();

}
