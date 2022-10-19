package uz.developers.pcmarket.payload;

import lombok.Data;
import uz.developers.pcmarket.entity.Product;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private Integer productId;
}
