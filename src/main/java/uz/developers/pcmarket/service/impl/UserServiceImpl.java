package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.User;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.UserDto;
import uz.developers.pcmarket.repository.UserRepository;
import uz.developers.pcmarket.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public ApiResponce addUser(UserDto userDto) {
        return null;
    }

    @Override
    public ApiResponce editUser(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public ApiResponce deleteUser(Integer id) {
        return null;
    }
}
