package sistek.repository;

import org.springframework.data.repository.CrudRepository;
import sistek.entity.User;

public interface UserRepo extends CrudRepository<User,Integer> {


    Boolean existsByNameAndPassword(String name, String password);

    User findOneByNameAndPassword(String name, String password);
}
