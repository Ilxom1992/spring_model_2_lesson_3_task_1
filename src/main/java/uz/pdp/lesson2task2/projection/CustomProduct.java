package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Attachment;
import uz.pdp.lesson2task2.entity.Category;
import uz.pdp.lesson2task2.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    String getDescription();

    Category getCategory();

    Double getPrice();

    Attachment getPhoto();
}
