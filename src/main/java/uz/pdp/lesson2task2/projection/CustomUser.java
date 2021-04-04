package uz.pdp.lesson2task2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.lesson2task2.entity.Attachment;
import uz.pdp.lesson2task2.entity.User;

@Projection(types = User.class)
public interface CustomUser {

    Integer getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();

    Integer getPhoto();
}
