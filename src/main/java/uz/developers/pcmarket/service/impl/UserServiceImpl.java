package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.User;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.UserDto;
import uz.developers.pcmarket.repository.UserRepository;
import uz.developers.pcmarket.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return new User();
    }

    @Override
    public ApiResponce addUser(UserDto userDto) {
        User savedUser = new User();
        //todo userDto dan keladigan warehouseId listini generatsiya qilish kerak
        //todo put da ham
        return null;
    }

    //    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    private String code;
//    private String password;
    @Override
    public ApiResponce editUser(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public ApiResponce deleteUser(Integer id) {
        userRepository.deleteById(id);
        return new ApiResponce("User is deleted",true);
    }
}
