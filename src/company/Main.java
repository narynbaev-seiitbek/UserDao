package company;
import company.enums.Gender;
import company.model.User;
import company.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        User user1 = new User("Azat", (byte) 18,1, Gender.MALE);
        User user2 = new User("Kuba", (byte) 28,2, Gender.MALE);
        User user3 = new User("Ulan", (byte) 14,3, Gender.MALE);
        User user4 = new User("Nurjan", (byte) 15,4, Gender.FEMALE);
        User user5 = new User("Aijan", (byte) 17,5, Gender.FEMALE);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);

        System.out.println(userService.searchById(6));

        System.out.println("All elements of list------------------");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("After remove--------------------------");
        userService.removeById(2);
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("----------------------------------");

        Map<Gender, List<User>> allUsers = userService.getAllUsers()
                .stream().collect(Collectors.groupingBy(User::getGender));
        allUsers.forEach((gender, users) -> {
            System.out.println(gender);
            users.forEach(System.out::println);
            System.out.println();
        });
    }
}
