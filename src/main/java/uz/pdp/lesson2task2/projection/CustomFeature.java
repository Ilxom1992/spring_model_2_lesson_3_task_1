package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Category;
import uz.pdp.lesson2task2.entity.Feature;

@Projection(types = Feature.class)
public interface CustomFeature {

    Integer getId();

    String getName();

    String getType();

    Category getCategory();
}
