package uz.developers.pcmarket.service;

import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.User;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.UserDto;

import java.util.List;


public interface UserService {
    List<User> getUsers();

    User getUser(Integer id);

    ApiResponce addUser(UserDto userDto);

    ApiResponce editUser(Integer id, UserDto userDto);

    ApiResponce deleteUser(Integer id);


}
