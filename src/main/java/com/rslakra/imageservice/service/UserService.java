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
package com.rslakra.imageservice.service;

import com.rslakra.imageservice.domain.Role;
import com.rslakra.imageservice.domain.User;
import com.rslakra.imageservice.exception.InvalidUserException;
import com.rslakra.imageservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 10:45
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * @param user
     */
    public void saveUser(User user) {
        if (isAuthenticated(user)) {
            userRepository.save(user);
        }
    }

    /**
     * @return
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new InvalidUserException("User does not exist with id:" + id));
    }

    /**
     * @param user
     * @return
     */
    public boolean isAuthenticated(User user) {
        if (Role.USER.equals(user.getRole())) {
            return true;
        } else if (Role.ADMIN.equals(user.getRole())) {
            return true;

        }

        return false;
    }
}
