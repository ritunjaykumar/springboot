package com.softgyan.springboot.dao;

import com.softgyan.springboot.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.softgyan.springboot.utils.Utils.logN;

public class UserServices {
    public List<User> getAllUserList(UserRepository userRepository) {
        Iterable<User> all = userRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        logN(users);
        return users;
    }


    public User getSingleUser(UserRepository userRepository, int id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }

    public void deleteUserById(UserRepository userRepository, int... ids) {
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

    public User updateUserById(UserRepository userRepository, final User toUpdateUser) {
        Optional<User> userOptional = userRepository.findById(toUpdateUser.getId());
        if (userOptional.isPresent()) {
            User tempUser = userOptional.get();
            if (!toUpdateUser.getName().equals("no")) {
                tempUser.setName(toUpdateUser.getName());
            }
            if (!toUpdateUser.getCity().equals("no")) {
                tempUser.setCity(toUpdateUser.getCity());
            }

            if (!toUpdateUser.getStatus().equals("no")) {
                tempUser.setStatus(toUpdateUser.getStatus());
            }
            return userRepository.save(tempUser);
        }
        return null;
    }

    public User insertNewUser(UserRepository userRepository, final User user) {
        return userRepository.save(user);
    }
}
