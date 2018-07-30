package com.controllers;

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
        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(users);
        obj.setStatusCode(200);

        return obj;

    }

    @GetMapping("/{id}")
    public CustomResponseObject<User> findUserById(@PathVariable("id") long id) throws Exception {
        User user = userService.findUserById(id);

        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(user);
        obj.setStatusCode(200);

        return obj;

    }

    @PostMapping
    public CustomResponseObject<User> createUser(@Valid @RequestBody User user) throws Exception {

        User u = userService.createUser(user);

        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(user);
        obj.setStatusCode(200);

        return obj;
    }



}
