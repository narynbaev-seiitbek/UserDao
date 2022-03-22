package company.service.impl;

import company.dao.UserDao;
import company.exception.IdNotFoundException;
import company.model.User;
import company.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User searchById(int id) {
        try{
            if (userDao.searchById(id)==null) {
                throw new IdNotFoundException("Пользователь с такой ID в базе нет ");
            }
        }catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return userDao.searchById(id);
    }

    @Override
    public void removeById(int id) {
        userDao.removeById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{}";
    }
}
