/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rslakra.imageservice.controller;

import com.rslakra.imageservice.domain.User;
import com.rslakra.imageservice.payload.UserResponse;
import com.rslakra.imageservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 11:16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/users", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<UserResponse> createUser(@PathVariable User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(new UserResponse(user.getId(), user.getUserName(), user.getRole()));
    }

    @PutMapping(path = "/users", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<UserResponse> updateUser(@PathVariable User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(new UserResponse(user.getId(), user.getUserName(), user.getRole()));
    }

    @GetMapping(value = "/users/{id}", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<UserResponse> getUser(@PathVariable int id) {
        // Load from database
        User user = userService.getUser(id);
        if (user != null)
            return ResponseEntity.ok().body(new UserResponse(user.getId(), user.getUserName(), user.getRole()));

        return null;
    }

    @GetMapping(path = "/users/getAllUsers", produces = {"application/json;charset=UTF-8"})
    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userService.getUsers();
        final List<UserResponse> allUsersResponse = new ArrayList<>();
        allUsers.forEach(user -> allUsersResponse.add(new UserResponse(user.getId(), user.getUserName(), user.getRole())));
        return allUsersResponse;
    }

}