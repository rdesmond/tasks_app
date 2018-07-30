package com.services;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryandesmond on 7/30/18.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() throws Exception {

        List<User> users;

        try {
            users = (List<User>) userRepository.findAll();
        } catch(Exception e){
            throw e;
        }

        return users;
    }

    public User findUserById(long id) throws Exception{

        User u;

        try {
            u = userRepository.findOne(id);
        } catch(Exception e){
            throw e;
        }

        return u;
    }

    public User createUser(User user) throws Exception {

        try {
            userRepository.save(user);
            User u = userRepository.findByEmail(user.getEmail());
            return u;
        } catch (Exception e){
            throw e;
        }

    }
}
