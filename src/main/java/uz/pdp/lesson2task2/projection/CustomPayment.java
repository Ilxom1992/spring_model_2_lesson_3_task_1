package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Invoice;
import uz.pdp.lesson2task2.entity.Payment;
import uz.pdp.lesson2task2.entity.User;

import java.sql.Date;

@Projection(types = Payment.class)
public interface CustomPayment {
    Integer getId();

    Double getPrice();

    User getCustomer();

    Invoice getInvoice();

    Date getDate();
}
