package uz.developers.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.pcmarket.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {


}
