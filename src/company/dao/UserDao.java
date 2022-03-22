package company.dao;
import company.model.User;
import company.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao implements UserService {

    private Map<Integer, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(),user);
    }

    @Override
    public User searchById(int id) {
        return users.get(id);
    }

    @Override
    public void removeById(int id) {
        users.remove(id);
    }

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }
}
