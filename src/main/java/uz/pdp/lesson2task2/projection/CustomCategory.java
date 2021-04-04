package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Attachment;
import uz.pdp.lesson2task2.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    String getDescription();

    Integer getParentCategory();

    Integer getAttachment();


}
