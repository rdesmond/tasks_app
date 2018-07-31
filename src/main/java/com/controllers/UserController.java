package com.controllers;

import com.exceptions.CustomDatabaseException;
import com.model.CustomResponseObject;
import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ryandesmond on 7/30/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public CustomResponseObject<List<User>> getUsers() throws Exception {

        List<User> users = userService.findAllUsers();
        CustomResponseObject<List<User>> obj = new CustomResponseObject();
        obj.setData(users);
        obj.setStatusCode(200);

        return obj;

    }

    @GetMapping("/{id}")
    public CustomResponseObject<User> findUserById(@PathVariable("id") long id) throws Exception {
        User user = userService.findUserById(id);

        CustomResponseObject<User> obj = new CustomResponseObject();
        obj.setData(user);
        obj.setStatusCode(200);

        return obj;

    }

    @PostMapping
    public CustomResponseObject<User> createUser(@Valid @RequestBody User user) throws Exception {

        User u = userService.createUser(user);

        CustomResponseObject<User> obj = new CustomResponseObject();
        obj.setData(user);
        obj.setStatusCode(200);

        return obj;
    }

    @PutMapping
    public CustomResponseObject<User> updateUser(@Valid @RequestBody User user) throws CustomDatabaseException {

        User u = userService.updateUser(user);

        CustomResponseObject<User> obj = new CustomResponseObject();
        obj.setData(user);
        obj.setStatusCode(200);

        return obj;
    }

    @DeleteMapping("/{id}")
    public CustomResponseObject<String> deleteUser(@PathVariable("id") long id) throws Exception {

        boolean success = userService.deleteUser(id);

        CustomResponseObject<String> obj = new CustomResponseObject();
        if (success){
            obj.setData("User Successfully Deleted");
            obj.setStatusCode(200);
            return obj;
        }

        throw new CustomDatabaseException("Unable to delete user");
    }

}
