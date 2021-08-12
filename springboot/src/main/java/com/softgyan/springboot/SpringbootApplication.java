package com.softgyan.springboot;

import com.softgyan.springboot.dao.UserRepository;
import com.softgyan.springboot.models.User;
import com.softgyan.springboot.utils.Utils;
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

    private static int optionMessage() {
        Utils.logN("1. insert new data");
        Utils.logN("2. update user by id");
        Utils.logN("3. delete user by id");
        Utils.logN("4. show all records");
        Utils.logN("5. Exit");
        Utils.log("your option : ");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            Utils.logN(e.getMessage());
        }
        return 5;
    }


    private static User enterUserDetails(boolean isUpdate) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        if (isUpdate) {
            Utils.log("User id : ");
            user.setId(sc.nextInt());
            sc.nextLine();
        }
        Utils.log("Name : ");
        user.setName(sc.nextLine());
        Utils.log("city : ");
        user.setCity(sc.nextLine());
        Utils.log("status : ");
        user.setStatus(sc.nextLine());
        return user;
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        /*boolean isExit = false;
        while (!isExit) {
            int optionMessage = optionMessage();
            switch (optionMessage) {
                case 1: {

                    User insertNewUser = insertNewUser(userRepository, enterUserDetails(false));
                    Utils.logN(insertNewUser.toString());
                    break;
                }

                case 2: {
                    Utils.logN("if you don't want to update please enter \"no\"");
                    User user = updateUserById(userRepository, enterUserDetails(true));
                    if (user == null) {
                        Utils.logN("data not found");
                    } else {
                        Utils.logN("updated");
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
                    Utils.logN(allUserList);
                    break;
                }
                case 5: {
                    isExit = true;
                    break;
                }
            }
        }*/




    }

}
