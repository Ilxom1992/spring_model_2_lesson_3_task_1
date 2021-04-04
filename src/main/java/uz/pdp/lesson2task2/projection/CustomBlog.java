package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Attachment;
import uz.pdp.lesson2task2.entity.Blog;

@Projection(types = Blog.class)
public interface CustomBlog {
    Integer getId();

    String getBody();

    String getTitle();

    Integer getPhoto();
}
