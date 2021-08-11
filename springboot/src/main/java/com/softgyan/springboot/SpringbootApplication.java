package com.softgyan.springboot;

import com.softgyan.springboot.dao.UserRepository;
import com.softgyan.springboot.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
/*
combination of given attributes
@Configuration
@EnableAutoConfiguration
@ComponentScan*/

public class SpringbootApplication {
    private static List<User> getAllUserList(UserRepository userRepository) {
        Iterable<User> all = userRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }

    private static void deleteUserById(UserRepository userRepository, int... ids) {
        if (ids.length == 1) {
            userRepository.deleteById(ids[0]);
            return;
        }
        ArrayList<Integer> toDelete = new ArrayList<>();
        for (int i : ids) {
            toDelete.add(i);
        }
        userRepository.deleteAllById(toDelete);
    }


    private static User updateUserById(UserRepository userRepository, final User toUpdateUser) {
        Optional<User> userOptional = userRepository.findById(toUpdateUser.get_id());
        if (userOptional.isPresent()) {
            User tempUser = userOptional.get();
            if (!toUpdateUser.get_name().equals("no")) {
                tempUser.set_name(toUpdateUser.get_name());
            }
            if (!toUpdateUser.get_city().equals("no")) {
                tempUser.set_city(toUpdateUser.get_city());
            }

            if (!toUpdateUser.get_status().equals("no")) {
                tempUser.set_status(toUpdateUser.get_status());
            }
            return userRepository.save(tempUser);
        }
        return null;
    }


    private static User insertNewUser(UserRepository userRepository, final User user) {
        return userRepository.save(user);
    }

    private static void log(Object string) {
        System.out.print(string);
    }

    private static void logN(Object s) {
        System.out.println(s);
    }


    private static int optionMessage() {
        logN("1. insert new data");
        logN("2. update user by id");
        logN("3. delete user by id");
        logN("4. show all records");
        logN("5. Exit");
        log("your option : ");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            logN(e.getMessage());
        }
        return 5;
    }


    private static User enterUserDetails(boolean isUpdate) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        if (isUpdate) {
            log("User id : ");
            user.set_id(sc.nextInt());
            sc.nextLine();
        }
        log("Name : ");
        user.set_name(sc.nextLine());
        log("city : ");
        user.set_city(sc.nextLine());
        log("status : ");
        user.set_status(sc.nextLine());
        return user;
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        boolean isExit = false;
        while (!isExit) {
            int optionMessage = optionMessage();
            switch (optionMessage) {
                case 1: {

                    User insertNewUser = insertNewUser(userRepository, enterUserDetails(false));
                    logN(insertNewUser.toString());
                    break;
                }

                case 2: {
                    logN("if you don't want to update please enter \"no\"");
                    User user = updateUserById(userRepository, enterUserDetails(true));
                    if (user == null) {
                        logN("data not found");
                    } else {
                        logN("updated");
                    }
                    break;
                }

                case 3: {
                    Scanner sc = new Scanner(System.in);
                    log("User id : ");
                    int id = sc.nextInt();
                    deleteUserById(userRepository, id);
                    break;
                }
                case 4: {
                    List<User> allUserList = getAllUserList(userRepository);
                    logN(allUserList);
                    break;
                }
                case 5: {
                    isExit = true;
                    break;
                }
            }
        }

    }

}
