package company.service;
import company.model.User;
import java.util.List;

public interface UserService {

    void addUser(User user);
    User searchById(int id);
    void removeById(int id);
    List<User> getAllUsers();

}
